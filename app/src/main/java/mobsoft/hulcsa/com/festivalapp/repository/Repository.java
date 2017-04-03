package mobsoft.hulcsa.com.festivalapp.repository;

import android.content.Context;

import java.util.List;

import mobsoft.hulcsa.com.festivalapp.model.Event;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Event> getFavourites();

    void addFavourite(Event event);

    void removeFavourite(Event event);
}
