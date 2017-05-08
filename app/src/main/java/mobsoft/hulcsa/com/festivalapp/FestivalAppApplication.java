package mobsoft.hulcsa.com.festivalapp;

import android.app.Application;

import javax.inject.Inject;

import mobsoft.hulcsa.com.festivalapp.repository.Repository;
import mobsoft.hulcsa.com.festivalapp.ui.UIModule;

public class FestivalAppApplication extends Application {
    public static FestivalAppApplicationComponent injector;

    @Inject
    Repository repository;

    public void setInjector(FestivalAppApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setInjector(
                DaggerFestivalAppApplicationComponent.builder().
                        uIModule(new UIModule(this)).build());
    }
}
