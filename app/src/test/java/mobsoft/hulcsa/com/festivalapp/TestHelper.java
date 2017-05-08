package mobsoft.hulcsa.com.festivalapp;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        FestivalAppApplication application = (FestivalAppApplication) RuntimeEnvironment.application;
        FestivalAppApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }

}
