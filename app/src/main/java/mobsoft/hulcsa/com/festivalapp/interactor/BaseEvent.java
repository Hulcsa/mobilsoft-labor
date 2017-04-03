package mobsoft.hulcsa.com.festivalapp.interactor;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public abstract class BaseEvent<T> {
    private int code;
    private T payload;
    private Throwable throwable;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
