package mobsoft.hulcsa.com.festivalapp.ui.events;


import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.event.EventInteractor;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

public class EventsPresenter extends Presenter<EventsScreen> {
    @Inject
    EventBus eventBus;
    @Inject
    EventInteractor eventInteractor;

    public EventsPresenter() {
        FestivalAppApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(EventsScreen screen) {
        super.attachScreen(screen);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        eventBus.unregister(this);
    }
}
