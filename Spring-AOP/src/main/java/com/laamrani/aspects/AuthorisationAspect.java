package com.laamrani.aspects;

import com.laamrani.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorisationAspect {
    @Around(value = "@annotation(securedByAspect)",argNames = "pjp,securedByAspect")
    public Object secure(ProceedingJoinPoint pjp, SecuredByAspect securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean isAuthorized = false;
        for (String role : roles) {
            if (SecurityContext.hasRole(role)) {
                isAuthorized = true;
                break;
            }
        }
        if (isAuthorized) {
                Object rslt = pjp.proceed();
                return rslt;
        }
        else {
            throw new RuntimeException("Access denied to " + pjp.getSignature().getName() + " method");
        }
    }
    //@AfterReturning()
    //@AfterThrowing()
}
