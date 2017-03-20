package mobsoft.hulcsa.com.festivalapp.ui.events;

import java.util.List;

import mobsoft.hulcsa.com.festivalapp.model.Event;
import mobsoft.hulcsa.com.festivalapp.model.NetworkError;

public interface EventsScreen {
    void showEvents(List<Event> events);
    void showNetworkError(NetworkError networkError);
}
