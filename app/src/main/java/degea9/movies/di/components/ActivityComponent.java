/**
 * Created by tuandang on 9/13/2016.
 */
package degea9.movies.di.components;

import android.app.Activity;

import dagger.Component;
import degea9.movies.di.modules.ActivityModule;
import degea9.movies.di.scope.PerActivity;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
