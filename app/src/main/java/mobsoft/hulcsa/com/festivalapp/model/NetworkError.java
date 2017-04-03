package mobsoft.hulcsa.com.festivalapp.model;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class NetworkError {
    private Integer code;
    private String message;

    public NetworkError() {}

    public NetworkError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
