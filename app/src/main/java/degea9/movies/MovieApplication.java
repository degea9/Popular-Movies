/**
 * Created by tuandang on 9/11/2016.
 */
package degea9.movies;

import android.app.Application;

import degea9.movies.di.components.ApplicationComponent;
import degea9.movies.di.components.DaggerApplicationComponent;
import degea9.movies.di.modules.ApplicationModule;

public class MovieApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
