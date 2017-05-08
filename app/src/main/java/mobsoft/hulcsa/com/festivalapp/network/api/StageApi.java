package mobsoft.hulcsa.com.festivalapp.network.api;

import java.util.List;

import mobsoft.hulcsa.com.festivalapp.model.Stage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

public interface StageApi {
    /**
     * Stages
     * The Stages endpoint returns with an array of Stage.
     * @return Call<List<Stage>>
     */

    @GET("stages")
    Call<List<Stage>> stagesGet();



    /**
     * Stage
     * The Stage endpoint returns with an Stage with the given id.
     * @param id The id of a stage
     * @return Call<Stage>
     */

    @GET("stages/{id}")
    Call<Stage> stagesIdGet(
            @Path("id") String id
    );

}
