package com.example.ae.Loggers;

import com.example.ae.POJO.LogPOJO;
import org.springframework.stereotype.Component;

public interface BaseLogger {

    public void logRequests(LogPOJO logPOJO);

}
