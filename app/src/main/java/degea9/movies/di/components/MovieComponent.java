/**
 * Created by tuandang on 9/13/2016.
 */
package degea9.movies.di.components;

import dagger.Component;
import degea9.movies.di.modules.ActivityModule;
import degea9.movies.di.modules.MovieModule;
import degea9.movies.di.scope.PerActivity;
import degea9.movies.view.fragment.PopularMovieFragment;

/**
 * A scope {@link PerActivity} component.
 * Injects movie specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, MovieModule.class})
public interface MovieComponent extends ActivityComponent {
    void inject(PopularMovieFragment popularMovieFragment);
    //void inject(UserDetailsFragment userDetailsFragment);
}

