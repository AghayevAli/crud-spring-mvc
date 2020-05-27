package az.com.course.util.handler;

import az.com.course.bean.ResponseBean;
import az.com.course.util.exception.NegativeIndexValue;
import az.com.course.util.exception.TokenIsEmpty;
import az.com.course.util.exception.UserNotFoundException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PushPack {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ResponseBean userNotFound() {
        return new ResponseBean(40040, "User not found");
    }

    @ExceptionHandler(NegativeIndexValue.class)
    @ResponseBody
    public ResponseBean negativeIndexValue() {
        return new ResponseBean(777, "You can't put negative size to index");
    }

    @ExceptionHandler(TokenIsEmpty.class)
    @ResponseBody
    public ResponseBean tokenIsEmpty() {
        return new ResponseBean(333, "Token can not been empty");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseBean throwable(Throwable ex) {
        ex.printStackTrace();
        return new ResponseBean(50001, "internal server");
    }

    @ExceptionHandler(MalformedJwtException.class)
    @ResponseBody
    public ResponseBean invalidToken() {
        return new ResponseBean(777, "invalid Jwt");
    }
}