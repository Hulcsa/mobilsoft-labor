package mobsoft.hulcsa.com.festivalapp;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.festivalapp.ui.UIModule;
import mobsoft.hulcsa.com.festivalapp.ui.eventdetails.EventDetailsPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.events.EventsPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.favourites.FavouritesPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainPresenter;
import mobsoft.hulcsa.com.festivalapp.utils.UiExecutor;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

@Module
public class TestModule {

    private final mobsoft.hulcsa.com.festivalapp.ui.UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    public FavouritesPresenter provideFavouritesPresenter() {
        return UIModule.provideFavouritesPresenter();
    }

    @Provides
    public EventsPresenter provideEventsPresenter() {
        return UIModule.provideEventsPresenter();
    }

    @Provides
    public EventDetailsPresenter provideEventDetailsPresenter() {
        return UIModule.provideEventDetailsPresenter();
    }


    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }
}
