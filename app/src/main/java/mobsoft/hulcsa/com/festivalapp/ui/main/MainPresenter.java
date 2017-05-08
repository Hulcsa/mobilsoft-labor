package mobsoft.hulcsa.com.festivalapp.ui.main;

import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.stage.StageInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.stage.event.GetStagesEvent;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    EventBus eventBus;
    @Inject
    Executor executor;
    @Inject
    StageInteractor stageInteractor;

    public MainPresenter() {
        FestivalAppApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        eventBus.unregister(this);
    }

    public void getStages() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                stageInteractor.getStages();
            }
        });
    }

    public void onEventMainThread(GetStagesEvent event) {
        if (screen != null) {
            if (event.getThrowable() != null) {
                screen.showNetworkError(new NetworkError(event.getCode(), event.getThrowable().getMessage()));
            } else {
                screen.showStages(event.getPayload());
            }
        }
    }
}
