package mobsoft.hulcsa.com.festivalapp.ui.eventdetails;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class EventDetailsPresenter extends Presenter<EventDetailsScreen> {
    @Inject
    EventBus eventBus;

    public EventDetailsPresenter() {
        FestivalAppApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(EventDetailsScreen screen) {
        super.attachScreen(screen);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        eventBus.unregister(this);
    }
}
