/**
 * Created by tuandang on 9/10/2016.
 */
package degea9.movies.domain.executor;

import rx.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
