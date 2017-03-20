package mobsoft.hulcsa.com.festivalapp.ui.eventdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.R;
import mobsoft.hulcsa.com.festivalapp.model.Event;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;
import mobsoft.hulcsa.com.festivalapp.ui.events.EventsPresenter;

public class EventDetailsActivity extends AppCompatActivity implements EventDetailsScreen {

    @Inject
    EventDetailsPresenter eventDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        FestivalAppApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventDetailsPresenter.detachScreen();
    }

    @Override
    public void showEvent(Event event) {

    }

    @Override
    public void showNetworkError(NetworkError networkError) {

    }
}
