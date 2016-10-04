package degea9.movies.view.contract;

/**
 * Created by tuandang on 8/7/2016.
 */

import android.content.Context;

/**
 * Interface representing a base contract for all UI views(Activity or fragments)
 *
 */
public interface LoadDataView {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    void showError(String message);

    /**
     * Get a {@link android.content.Context}.
     */
    Context context();
}
