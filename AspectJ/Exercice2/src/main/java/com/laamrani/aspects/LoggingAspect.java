package com.laamrani.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    long t1, t2;
    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }
    @Pointcut("execution(* com.laamrani.metier.IMetierBanqueImpl.*(..))")
    public void MyPointcut() {}
    /*@Before("MyPointcut()")
    public void logBefore(JoinPoint jp) {
        t1= System.currentTimeMillis();
        logger.info("******************************");
        logger.info("Avant l'execution de la methode " + jp.getSignature().getName());
    }
    @After("MyPointcut()")
    public void logAfter(JoinPoint jp) {
        t2= System.currentTimeMillis();
        logger.info("Après l'execution de la methode " + jp.getSignature().getName());
        logger.info("Temps d'execution de la methode " + jp.getSignature().getName() + " est " + (t2-t1) + " ms");
        logger.info("*****************************");
    }*/
    @Around("MyPointcut()")
    public Object logAround(ProceedingJoinPoint pjp, JoinPoint jp) throws Throwable{
        t1= System.currentTimeMillis();
        logger.info("******************************");
        logger.info("Avant l'execution de la methode " + jp.getSignature().getName());
        Object o = pjp.proceed();
        t2= System.currentTimeMillis();
        logger.info("Après l'execution de la methode " + jp.getSignature().getName());
        logger.info("Temps d'execution de la methode " + jp.getSignature().getName() + " est " + (t2-t1) + " ms");
        logger.info("*****************************");
        return o;
    }
}
