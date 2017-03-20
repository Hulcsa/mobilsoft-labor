package mobsoft.hulcsa.com.festivalapp.ui.eventdetails;

import mobsoft.hulcsa.com.festivalapp.model.Event;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;

public interface EventDetailsScreen {
    void showEvent(Event event);
    void showNetworkError(NetworkError networkError);
}
