package mobsoft.hulcsa.com.festivalapp.network.api;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

import mobsoft.hulcsa.com.festivalapp.model.Event;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;


public interface EventApi {
    /**
     * Event
     * The Event endpoint returns with an Event with the given id.
     * @param id The id of a event
     * @return Call<Event>
     */

    @GET("events/{id}")
    Call<Event> eventsIdGet(
            @Path("id") String id
    );


    /**
     * Events
     * The Events endpoint returns with an array of Event associated with the Stage of the given id.
     * @param id The id of a stage
     * @param skip Event count to skip
     * @param limit Max event count for request
     * @return Call<List<Event>>
     */

    @GET("stages/{id}/events")
    Call<List<Event>> stagesIdEventsGet(
            @Path("id") String id, @Query("skip") Integer skip, @Query("limit") String limit
    );

}
