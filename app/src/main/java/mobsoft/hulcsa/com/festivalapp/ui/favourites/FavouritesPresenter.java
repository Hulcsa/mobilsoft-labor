package mobsoft.hulcsa.com.festivalapp.ui.favourites;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.FavouritesInteractor;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class FavouritesPresenter extends Presenter<FavouritesScreen> {
    @Inject
    EventBus eventBus;
    @Inject
    FavouritesInteractor favouritesInteractor;

    public FavouritesPresenter() {
        FestivalAppApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(FavouritesScreen screen) {
        super.attachScreen(screen);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        eventBus.unregister(this);
    }
}
