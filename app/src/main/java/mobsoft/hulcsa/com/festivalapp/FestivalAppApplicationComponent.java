package mobsoft.hulcsa.com.festivalapp;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.hulcsa.com.festivalapp.ui.UIModule;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface FestivalAppApplicationComponent {
    void inject(MainActivity mainActivity);
}
