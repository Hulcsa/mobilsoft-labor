package mobsoft.hulcsa.com.festivalapp;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.hulcsa.com.festivalapp.interactor.InteractorModule;
import mobsoft.hulcsa.com.festivalapp.mock.MockNetworkModule;
import mobsoft.hulcsa.com.festivalapp.repository.TestRepositoryModule;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends FestivalAppApplicationComponent {
}
