package mobsoft.hulcsa.com.festivalapp.ui.favourites;

import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.FavouritesInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.event.GetFavouritesEvent;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;
import mobsoft.hulcsa.com.festivalapp.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class FavouritesPresenter extends Presenter<FavouritesScreen> {
    @Inject
    EventBus eventBus;
    @Inject
    Executor executor;
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

    public void onEventMainThread(GetFavouritesEvent event) {
        if (screen != null) {
            if (event.getThrowable() != null) {
                screen.showDatabaseError();
            } else {
                screen.showFavourites(event.getPayload());
            }
        }
    }

    public void getFavourites() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                favouritesInteractor.getFavourites();
            }
        });
    }
}
