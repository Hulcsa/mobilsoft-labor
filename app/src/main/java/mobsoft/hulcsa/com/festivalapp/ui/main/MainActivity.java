package mobsoft.hulcsa.com.festivalapp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;

import javax.inject.Inject;

import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.R;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;
import mobsoft.hulcsa.com.festivalapp.model.Stage;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;
    Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FestivalAppApplication.injector.inject(this);

        FestivalAppApplication application = (FestivalAppApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTracker.setScreenName("Screen~Main");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void showStages(List<Stage> stages) {

    }

    @Override
    public void showNetworkError(NetworkError networkError) {

    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
