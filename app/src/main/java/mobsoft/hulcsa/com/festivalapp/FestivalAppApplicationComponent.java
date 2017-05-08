package mobsoft.hulcsa.com.festivalapp;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.hulcsa.com.festivalapp.interactor.InteractorModule;
import mobsoft.hulcsa.com.festivalapp.interactor.event.EventInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.FavouritesInteractor;
import mobsoft.hulcsa.com.festivalapp.interactor.stage.StageInteractor;
import mobsoft.hulcsa.com.festivalapp.network.NetworkModule;
import mobsoft.hulcsa.com.festivalapp.repository.RepositoryModule;
import mobsoft.hulcsa.com.festivalapp.ui.UIModule;
import mobsoft.hulcsa.com.festivalapp.ui.eventdetails.EventDetailsActivity;
import mobsoft.hulcsa.com.festivalapp.ui.eventdetails.EventDetailsPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.events.EventsActivity;
import mobsoft.hulcsa.com.festivalapp.ui.events.EventsPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.favourites.FavouritesActivity;
import mobsoft.hulcsa.com.festivalapp.ui.favourites.FavouritesPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainActivity;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainPresenter;

@Singleton
@Component(modules = {
        UIModule.class,
        InteractorModule.class,
        RepositoryModule.class,
        NetworkModule.class})
public interface FestivalAppApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(EventsActivity eventsActivity);
    void inject(EventDetailsActivity eventDetailsActivity);
    void inject(FavouritesActivity favouritesActivity);

    void inject(FavouritesInteractor favouritesInteractor);

    void inject(EventInteractor eventInteractor);

    void inject(StageInteractor stageInteractor);

    void inject(MainPresenter mainPresenter);

    void inject(FavouritesPresenter favouritesPresenter);

    void inject(EventsPresenter eventsPresenter);

    void inject(EventDetailsPresenter eventDetailsPresenter);

    void inject(FestivalAppApplication festivalAppApplication);
}
