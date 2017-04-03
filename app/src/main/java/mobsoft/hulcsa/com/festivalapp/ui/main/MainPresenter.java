package mobsoft.hulcsa.com.festivalapp.ui.main;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.stage.StageInteractor;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    EventBus eventBus;
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
}
