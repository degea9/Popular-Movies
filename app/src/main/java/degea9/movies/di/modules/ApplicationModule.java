/**
 * Created by tuandang on 9/11/2016.
 */
package degea9.movies.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import degea9.movies.MovieApplication;
import degea9.movies.UIThread;
import degea9.movies.data.repository.MovieDataRepository;
import degea9.movies.domain.executor.PostExecutionThread;
import degea9.movies.domain.repository.MovieRepository;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final MovieApplication application;

    public ApplicationModule(MovieApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    MovieRepository provideUserRepository(MovieDataRepository movieDataRepository) {
        return movieDataRepository;
    }
}
