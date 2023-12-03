package com.laamrani.aspects;

public aspect FirstAspect {
    pointcut myPointcut1() : execution(* com.laamrani.test.Main.main(..));

    /*before() : myPointcut1() {
        System.out.println("--------------------------------");
        System.out.println("Before main with aspectJ syntax");
        System.out.println("--------------------------------");
    }
    after() : myPointcut1() {
        System.out.println("--------------------------------");
        System.out.println("After main with aspectJ syntax");
        System.out.println("--------------------------------");
    }*/
    void around () : myPointcut1() {
        System.out.println("--------------------------------");
        System.out.println("Before main with aspectJ syntax");
        System.out.println("--------------------------------");
        proceed();
        System.out.println("-------------------------------");
        System.out.println("After main with aspectJ syntax");
        System.out.println("-------------------------------");
    }
}
