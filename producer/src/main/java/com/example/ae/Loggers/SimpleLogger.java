package com.example.ae.Loggers;

import com.example.ae.POJO.LogPOJO;
import org.springframework.stereotype.Component;

@Component("console")
public class SimpleLogger implements BaseLogger{
    @Override
    public void logRequests(LogPOJO logPOJO) {
        System.out.println(logPOJO.toString());
    }
}
