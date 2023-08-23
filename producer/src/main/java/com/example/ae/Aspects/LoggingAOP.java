package com.example.ae.Aspects;

import com.example.ae.Loggers.BaseLogger;
import com.example.ae.POJO.LogPOJO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;


@Aspect
@Component
public class LoggingAOP {

    @Autowired
    @Qualifier("console")
    private BaseLogger baseLogger;
    @Around(("@annotation(org.springframework.web.bind.annotation.RequestMapping)"))
    public Object RequestLog(ProceedingJoinPoint joinPoint)throws Throwable{
        /*
            check if there is an argument
            if exist check for its type, if it's GET then get the response and log it
                                         if it's POST try to find the request object and log it
             get the function arguments and log them

            THEN get all the response entity objects and log them
        */

//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // method signature
//        Method method =  methodSignature.getMethod();
//        RequestMapping methodAnnotation= method.getAnnotation(RequestMapping.class);
//        String requestMethod = methodAnnotation.method()[0].name(); // get the request method
//        if (requestMethod == "GET" || requestMethod=="DELETE" ) {
//
//        }


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        baseLogger.logRequests(new LogPOJO(request.getMethod(), LocalDateTime.now(), request.getRequestURI(), joinPoint.getArgs()));

        Object proceed = joinPoint.proceed();
        return proceed;
    }

}
