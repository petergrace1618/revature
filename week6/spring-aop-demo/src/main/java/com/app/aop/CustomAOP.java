package com.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class CustomAOP {

    @Pointcut("execution(* com.app.service.MyService.v*(..))")
    public void myService() { }

    @Pointcut("execution(* com.app.service.MyService.t*(..))")
    public void myServiceAround() {}

    @Pointcut("execution(* com.app.service.MyService.e*(..))")
    public void myServiceException() {}

    @Pointcut("execution(* com.app.service.MyService.r*(..))")
    public void myServiceReturn() {}

    @After("myService()")
    public void afterAdvice(JoinPoint jp) {
        System.out.println("After "+jp.getSignature());
    }

    @Before("myService()")
    public void beforeAdvice(JoinPoint jp) {
        System.out.println("Before "+jp.getSignature());
    }

    @Around("myServiceAround()")
    public void aroundAdvice(ProceedingJoinPoint pjp) {
        System.out.println("Before "+pjp.getSignature());
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("After "+pjp.getSignature());
    }

    @AfterThrowing(value="myServiceException()", throwing = "t")
    public void throwingAdvice(JoinPoint jp, Throwable t) {
        System.out.println("CustomAOP.throwingAdvice()");
        System.out.println("exception '"+t+"' occurred in "+jp.getSignature());
    }

    @AfterReturning(value = "myServiceReturn()", returning = "res")
    public void afterReturnAdvice(JoinPoint jp, String res) {
        System.out.println("After CustomAOP.afterReturnAdvice()");
    }

}
