package com.example.ae.loggers;

import com.example.ae.pojo.LogPOJO;
import org.springframework.stereotype.Component;

@Component("console")
public class SimpleLogger implements BaseLogger{
    @Override
    public void logRequests(LogPOJO logPOJO) {
        System.out.println(logPOJO.toString());
    }
}
