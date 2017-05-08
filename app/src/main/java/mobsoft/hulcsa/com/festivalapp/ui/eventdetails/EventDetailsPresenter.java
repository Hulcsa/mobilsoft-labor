package mobsoft.hulcsa.com.festivalapp.ui.eventdetails;

import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.event.EventInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.event.event.GetEventEvent;
import mobsoft.hulcsa.com.festivalapp.model.Event;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class EventDetailsPresenter extends Presenter<EventDetailsScreen> {
    @Inject
    EventBus eventBus;
    @Inject
    Executor executor;
    @Inject
    EventInteractor eventInteractor;

    private String selectedEventId;
    private Event selectedEvent;

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

    public void getEventDetails() {
        if (selectedEventId != null) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    eventInteractor.getEvent(selectedEventId);
                }
            });
        }
    }

    public void onEventMainThread(GetEventEvent event) {
        if (screen != null) {
            if (event.getThrowable() != null) {
                screen.showNetworkError(new NetworkError(event.getCode(), event.getThrowable().getMessage()));
            } else {
                selectedEvent = event.getPayload();
                screen.showEvent(selectedEvent);
            }
        }
    }

    public String getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(String selectedEventId) {
        this.selectedEventId = selectedEventId;
    }
}
