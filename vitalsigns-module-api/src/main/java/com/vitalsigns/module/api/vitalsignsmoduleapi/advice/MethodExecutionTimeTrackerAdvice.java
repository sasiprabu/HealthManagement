package com.vitalsigns.module.api.vitalsignsmoduleapi.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MethodExecutionTimeTrackerAdvice {
    Logger logger = LoggerFactory.getLogger(MethodExecutionTimeTrackerAdvice.class);

    @Around("@annotation(com.vitalsigns.module.api.vitalsignsmoduleapi.advice.TrackingExecuteTime)")
    public Object executionTime(ProceedingJoinPoint procJointPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object object = procJointPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method name"+procJointPoint.getSignature()+" time taken to execute : "+(endTime-startTime));
        return object;
    }
}
