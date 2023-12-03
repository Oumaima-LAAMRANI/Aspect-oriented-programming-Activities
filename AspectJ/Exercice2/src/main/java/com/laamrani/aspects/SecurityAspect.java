package com.laamrani.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* com.laamrani.Main.start(..))")
    public void MyPointcut() {}
    @Around("MyPointcut()")
    public void aroundStart(ProceedingJoinPoint pjp) throws Throwable{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer votre username: ");
        String username = scanner.nextLine();
        System.out.println("Entrer votre password: ");
        String password = scanner.nextLine();
        if (!username.equals("Laamrani") || !password.equals("1234"))
            System.out.println("Accès non autorisé ... ");
        pjp.proceed();
    }
}
