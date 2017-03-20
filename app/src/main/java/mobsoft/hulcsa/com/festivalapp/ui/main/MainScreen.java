package mobsoft.hulcsa.com.festivalapp.ui.main;

import java.util.List;

import mobsoft.hulcsa.com.festivalapp.model.NetworkError;
import mobsoft.hulcsa.com.festivalapp.model.Stage;

public interface MainScreen {
    void showStages(List<Stage> stages);
    void showNetworkError(NetworkError networkError);
}
