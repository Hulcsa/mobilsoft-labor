package mobsoft.hulcsa.com.festivalapp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.util.List;

import mobsoft.hulcsa.com.festivalapp.BuildConfig;
import mobsoft.hulcsa.com.festivalapp.model.Stage;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainPresenter;
import mobsoft.hulcsa.com.festivalapp.ui.main.MainScreen;
import mobsoft.hulcsa.com.festivalapp.utils.RobolectricDaggerTestRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static mobsoft.hulcsa.com.festivalapp.TestHelper.setTestInjector;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainTest {

    private MainPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void testMain() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.getStages();

        ArgumentCaptor<List> todosCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen, times(1)).showStages(todosCaptor.capture());

        List<List> capturedTodos = todosCaptor.getAllValues();
        Stage s1 = (Stage) capturedTodos.get(0).get(0);
        Stage s2 = (Stage) capturedTodos.get(0).get(1);
        assertEquals("s1", s1.getStageId());
        assertEquals("s2", s2.getStageId());
    }



    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}
