package mobsoft.hulcsa.com.festivalapp.interactor;

import dagger.Module;
import dagger.Provides;
import mobsoft.hulcsa.com.festivalapp.interactor.event.EventInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.FavouritesInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.stage.StageInteractor;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

@Module
public class InteractorModule {

    @Provides
    public FavouritesInteractor provideFavouritesInteractor() {
        return new FavouritesInteractor();
    }

    @Provides
    public EventInteractor provideEventInteractor() {
        return new EventInteractor();
    }

    @Provides
    public StageInteractor provideStageInteractor() {
        return new StageInteractor();
    }
}
