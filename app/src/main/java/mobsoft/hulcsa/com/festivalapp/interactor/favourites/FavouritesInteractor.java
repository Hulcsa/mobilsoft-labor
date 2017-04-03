package mobsoft.hulcsa.com.festivalapp.interactor.favourites;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.event.AddFavouriteEvent;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.event.GetFavouritesEvent;
import mobsoft.hulcsa.com.festivalapp.interactor.favourites.event.RemoveFavouriteEvent;
import mobsoft.hulcsa.com.festivalapp.model.Event;
import mobsoft.hulcsa.com.festivalapp.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class FavouritesInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus eventBus;

    public FavouritesInteractor() {
        FestivalAppApplication.injector.inject(this);
    }

    public void getFavourites() {
        GetFavouritesEvent event = new GetFavouritesEvent();
        try {
            List<Event> favourites = repository.getFavourites();
            event.setPayload(favourites);
            eventBus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }

    public void addFavourite(Event event) {
        AddFavouriteEvent addFavouriteEvent = new AddFavouriteEvent();
        addFavouriteEvent.setPayload(event);
        try {
            repository.addFavourite(event);
            eventBus.post(addFavouriteEvent);
        } catch (Exception e) {
            addFavouriteEvent.setThrowable(e);
            eventBus.post(event);
        }
    }

    public void removeFavourites(Event event) {
        RemoveFavouriteEvent removeFavouriteEvent = new RemoveFavouriteEvent();
        removeFavouriteEvent.setPayload(event);
        try {
            repository.removeFavourite(event);
            eventBus.post(removeFavouriteEvent);
        } catch (Exception e) {
            removeFavouriteEvent.setThrowable(e);
            eventBus.post(removeFavouriteEvent);
        }
    }
}
