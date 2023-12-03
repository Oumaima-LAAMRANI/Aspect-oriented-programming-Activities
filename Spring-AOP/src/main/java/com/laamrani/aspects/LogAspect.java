package com.laamrani.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy // @EnableAspectJAutoProxy(proxyTargetClass = true) is equivalent to <aop:aspectj-autoproxy proxy-target-class="true"
public class LogAspect {
        Logger logger = Logger.getLogger(LogAspect.class.getName());
        public LogAspect() throws IOException {
                logger.addHandler(new FileHandler("log.xml"));
                logger.setUseParentHandlers(false);
        }
        @Around("@annotation(com.laamrani.aspects.Loggable)")
        public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
                long t1 = System.currentTimeMillis();
                logger.info("******************************");
                logger.info("From Logging Aspect ... Before process" + pjp.getSignature().getName());
                Object o = pjp.proceed();
                long t2 = System.currentTimeMillis();
                logger.info("From Logging Aspect ... After process" + pjp.getSignature().getName());
                logger.info("Temps d'execution de la methode " + pjp.getSignature().getName() + " est " + (t2-t1) + " ms");
                logger.info("******************************");
                return o;
        }
}
