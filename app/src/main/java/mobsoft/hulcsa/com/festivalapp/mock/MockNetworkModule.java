package mobsoft.hulcsa.com.festivalapp.mock;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.hulcsa.com.festivalapp.network.NetworkModule;
import mobsoft.hulcsa.com.festivalapp.network.api.EventApi;
import mobsoft.hulcsa.com.festivalapp.network.api.StageApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public EventApi provideEventApi(Retrofit retrofit) {
        return networkModule.provideEventApi(retrofit);
    }

    @Provides
    @Singleton
    public StageApi provideStageApi(Retrofit retrofit) {
        return networkModule.provideStageApi(retrofit);
    }
}
