package mobsoft.hulcsa.com.festivalapp.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.ui.eventdetails.EventDetailsPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.events.EventsPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.favourites.FavouritesPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainPresenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public FavouritesPresenter provideFavouritesPresenter() {
        return new FavouritesPresenter();
    }

    @Provides
    @Singleton
    public EventsPresenter provideEventsPresenter() {
        return new EventsPresenter();
    }

    @Provides
    @Singleton
    public EventDetailsPresenter provideEventDetailsPresenter() {
        return new EventDetailsPresenter();
    }
}
