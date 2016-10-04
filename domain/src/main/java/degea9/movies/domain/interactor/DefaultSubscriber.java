/**
 * Created by tuandang on 9/11/2016.
 */
package degea9.movies.domain.interactor;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override public void onCompleted() {
        // no-op by default.
    }

    @Override public void onError(Throwable e) {
        // no-op by default.
    }

    @Override public void onNext(T t) {
        // no-op by default.
    }
}
