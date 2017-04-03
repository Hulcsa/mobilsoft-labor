package mobsoft.hulcsa.com.festivalapp.interactor.event;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class EventInteractor {

    @Inject
    EventBus eventBus;

    public EventInteractor() {
        FestivalAppApplication.injector.inject(this);
    }

    public void getEvent(String id) {

    }

    public void getEvents(String stageId) {

    }
}
