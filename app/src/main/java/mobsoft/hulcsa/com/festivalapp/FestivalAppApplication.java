package mobsoft.hulcsa.com.festivalapp;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;

import mobsoft.hulcsa.com.festivalapp.repository.Repository;
import mobsoft.hulcsa.com.festivalapp.ui.UIModule;

public class FestivalAppApplication extends Application {
    public static FestivalAppApplicationComponent injector;

    @Inject
    Repository repository;
    private Tracker mTracker;

    public void setInjector(FestivalAppApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        injector = DaggerFestivalAppApplicationComponent.builder().
                uIModule(new UIModule(this)).build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
