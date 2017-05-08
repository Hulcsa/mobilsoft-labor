package mobsoft.hulcsa.com.festivalapp.mock;

import mobsoft.hulcsa.com.festivalapp.mock.interceptor.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

public class MockHttpServer {
    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
