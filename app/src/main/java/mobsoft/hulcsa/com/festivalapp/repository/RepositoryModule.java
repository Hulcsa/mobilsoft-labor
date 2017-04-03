package mobsoft.hulcsa.com.festivalapp.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }
}
