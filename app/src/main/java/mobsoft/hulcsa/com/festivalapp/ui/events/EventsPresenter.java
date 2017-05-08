package mobsoft.hulcsa.com.festivalapp.ui.events;


import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.event.EventInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.event.event.GetEventsEvent;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

public class EventsPresenter extends Presenter<EventsScreen> {
    @Inject
    EventBus eventBus;
    @Inject
    Executor executor;
    @Inject
    EventInteractor eventInteractor;

    private String selectedStageId;

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

    public void getEvents() {
        if (selectedStageId != null) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    eventInteractor.getEvents(selectedStageId);
                }
            });
        }
    }

    public void onEventMainThread(GetEventsEvent event) {
        if (screen != null) {
            if (event.getThrowable() != null) {
                screen.showNetworkError(new NetworkError(event.getCode(), event.getThrowable().getMessage()));
            } else {
                screen.showEvents(event.getPayload());
            }
        }
    }

    public String getSelectedStageId() {
        return selectedStageId;
    }

    public void setSelectedStageId(String selectedStageId) {
        this.selectedStageId = selectedStageId;
    }
}
