package mobsoft.hulcsa.com.festivalapp.ui.favourites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import mobsoft.hulcsa.com.festivalapp.FestivalAppApplication;
import mobsoft.hulcsa.com.festivalapp.R;
import mobsoft.hulcsa.com.festivalapp.model.Event;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainPresenter;

public class FavouritesActivity extends AppCompatActivity implements FavouritesScreen {

    @Inject
    FavouritesPresenter favouritesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        FestivalAppApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        favouritesPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        favouritesPresenter.detachScreen();
    }

    @Override
    public void showFavourites(List<Event> events) {

    }
}
