/**
 * Created by tuandang on 9/11/2016.
 */
package degea9.movies.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import degea9.movies.data.api.MovieApiService;
import degea9.movies.di.modules.ApiModule;
import degea9.movies.di.modules.ApplicationModule;
import degea9.movies.domain.executor.PostExecutionThread;
import degea9.movies.domain.repository.MovieRepository;
import degea9.movies.view.activity.BaseActivity;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    PostExecutionThread postExecutionThread();
    MovieRepository movieResposity();
    MovieApiService movieApiService();
}
