package mobsoft.hulcsa.com.festivalapp;

import android.app.Application;

import mobsoft.hulcsa.com.festivalapp.ui.UIModule;

public class FestivalAppApplication extends Application {
    public static FestivalAppApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerFestivalAppApplicationComponent.builder().
                        uIModule(new UIModule(this)).build();
    }
}
