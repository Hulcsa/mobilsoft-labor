package mobsoft.hulcsa.com.festivalapp.mock.interceptor;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import mobsoft.hulcsa.com.festivalapp.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static mobsoft.hulcsa.com.festivalapp.mock.interceptor.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();


        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "stages")
                || uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "events")) {
            return FestivalMock.process(request);
        }




        return makeResponse(request, headers, 404, "Unknown");

    }

}