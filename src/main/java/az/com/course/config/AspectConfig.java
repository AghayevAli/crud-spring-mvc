package az.com.course.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
    @Before("personControllerPT()")
    public void startMethod() {
        System.out.println("*** method start ***");
    }

    @After("personControllerPT()")
    public void endMethod() {
        System.out.println("*** method ent ***");
    }

    @Pointcut("execution(* az.com.course.controller.*.*(*))")
    public void personControllerPT() {

    }

//    @Pointcut("within(az.com.course.controller..*)")
//    public void underPackage() {
//
//    }
}
