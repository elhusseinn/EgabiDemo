package com.example.ae.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggingAOP {
    @Around(("@annotation(org.springframework.web.bind.annotation.RequestMapping)"))
    public Object RequestLog(ProceedingJoinPoint joinPoint)throws Throwable{

        System.out.println(joinPoint.getArgs()[0]);
        Object proceed = joinPoint.proceed();
        return proceed;
    }

}
