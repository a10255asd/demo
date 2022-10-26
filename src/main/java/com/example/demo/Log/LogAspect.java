package com.example.demo.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.example.demo.Log.Log)")
    public void pointCut(){}


    @Before("pointCut()")
    public void before(){
        System.out.println("处理之前");
    }
    @AfterReturning(pointcut = "pointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        System.out.println("处理之后");
    }
}
