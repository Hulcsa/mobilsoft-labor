package mobsoft.hulcsa.com.festivalapp.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import mobsoft.hulcsa.com.festivalapp.model.Event;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class MemoryRepository implements Repository {

    private static List<Event> favourites;


    @Override
    public void open(Context context) {
        favourites = new ArrayList<>();
    }

    @Override
    public void close() {
        favourites = null;
    }

    @Override
    public List<Event> getFavourites() {
        return favourites;
    }

    @Override
    public void addFavourite(Event event) {
        favourites.add(event);
    }

    @Override
    public void removeFavourite(Event event) {
        favourites.remove(event);
    }
}
