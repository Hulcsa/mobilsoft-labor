package mobsoft.hulcsa.com.festivalapp.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import mobsoft.hulcsa.com.festivalapp.model.Event;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Event> getFavourites() {
        return SugarRecord.listAll(Event.class);
    }

    @Override
    public void addFavourite(Event event) {
        SugarRecord.save(event);
    }

    @Override
    public void removeFavourite(Event event) {
        SugarRecord.delete(event);
    }
}
