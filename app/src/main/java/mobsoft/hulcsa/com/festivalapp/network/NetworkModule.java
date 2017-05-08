package mobsoft.hulcsa.com.festivalapp.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.hulcsa.com.festivalapp.network.api.EventApi;
import mobsoft.hulcsa.com.festivalapp.network.api.StageApi;
import mobsoft.hulcsa.com.festivalapp.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public EventApi provideEventApi(Retrofit retrofit) {
        return retrofit.create(EventApi.class);
    }

    @Provides
    @Singleton
    public StageApi provideStageApi(Retrofit retrofit) {
        return retrofit.create(StageApi.class);
    }
}
