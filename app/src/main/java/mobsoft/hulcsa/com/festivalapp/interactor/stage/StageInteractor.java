package mobsoft.hulcsa.com.festivalapp.interactor.stage;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class StageInteractor {

    @Inject
    EventBus eventBus;

    public StageInteractor() {
        FestivalAppApplication.injector.inject(this);
    }

    public void getStage(String id) {

    }

    public void getStages() {

    }
}
