package mobsoft.hulcsa.com.festivalapp.mock.interceptor;

import android.net.Uri;

import java.util.ArrayList;
import java.util.HashMap;

import mobsoft.hulcsa.com.festivalapp.model.Event;
import mobsoft.hulcsa.com.festivalapp.model.Stage;
import mobsoft.hulcsa.com.festivalapp.network.NetworkConfig;
import mobsoft.hulcsa.com.festivalapp.repository.MemoryRepository;
import mobsoft.hulcsa.com.festivalapp.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static mobsoft.hulcsa.com.festivalapp.mock.interceptor.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

public class FestivalMock {

    private static HashMap<String, Stage> stages;
    private static HashMap<String, Event> events;

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "stages") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(new ArrayList<>(getStages().values()));
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "stages/") && request.method().equals("GET")) {
            if (!uri.getLastPathSegment().equals("events")) {
                String id = uri.getLastPathSegment();
                if (getStages().containsKey(id)) {
                    responseString = GsonHelper.getGson().toJson(getStages().get(id));
                    responseCode = 200;
                } else {
                    responseString = "NOT FOUND";
                    responseCode = 404;
                }
            } else {
                if (uri.getPath().contains("s1")) {
                    responseString = GsonHelper.getGson().toJson(new ArrayList<>(getEvents().values()));
                    responseCode = 200;
                } else if (uri.getPath().contains("s2")) {
                    responseString = GsonHelper.getGson().toJson(new ArrayList<Event>());
                    responseCode = 200;
                } else {
                    responseString = "NOT FOUND";
                    responseCode = 404;
                }
            }
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "events/") && request.method().equals("GET")) {
            String id = uri.getLastPathSegment();
            if (getEvents().containsKey(id)) {
                responseString = GsonHelper.getGson().toJson(getEvents().get(id));
                responseCode = 200;
            } else {
                responseString = "NOT FOUND";
                responseCode = 404;
            }
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }

    private static HashMap<String, Stage> getStages() {
        if (stages == null) {
            stages = new HashMap<>();

            Stage stage1 = new Stage();
            Stage stage2 = new Stage();
            stage1.setStageId("s1");
            stage2.setStageId("s2");

            stages.put("s1", stage1);
            stages.put("s2", stage2);
        }
        return stages;
    }

    private static HashMap<String, Event> getEvents() {
        if (events == null) {
            events = new HashMap<>();

            Event event1 = new Event();
            Event event2 = new Event();

            event1.setStageId("s1");
            event2.setStageId("s1");
            event1.setEventId("e1");
            event2.setEventId("e2");

            events.put("e1", event1);
            events.put("e2", event2);
        }
        return events;
    }
}
