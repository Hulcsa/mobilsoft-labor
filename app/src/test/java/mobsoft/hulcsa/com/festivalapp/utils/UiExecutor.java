package mobsoft.hulcsa.com.festivalapp.utils;

import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

import android.os.Handler;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

public class UiExecutor implements Executor {

    private Handler mHandler;

    public UiExecutor() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mHandler.post(command);
    }
}
