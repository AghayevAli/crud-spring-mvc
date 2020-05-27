package az.com.course.bean.token;

import az.com.course.bean.ResponseBean;

public class TokenResponseBean extends ResponseBean {
    private String token;

    public TokenResponseBean(int code, String message, String token) {
        super(code, message);
        this.token = token;
    }

    public TokenResponseBean() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
