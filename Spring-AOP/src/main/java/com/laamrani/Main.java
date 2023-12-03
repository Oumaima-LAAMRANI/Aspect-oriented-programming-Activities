package com.laamrani;


import com.laamrani.service.IMetier;
import com.laamrani.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class Main {
    public static void main(String[] args) {
        try {
            SecurityContext.authenticate("root", "1234", new String[]{"USER"});
            //ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
            ApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
            IMetier metier = context.getBean(IMetier.class);
            System.out.println("******************************");
            System.out.println(metier.getClass().getName());
            System.out.println("******************************");
            metier.process();
            System.out.println(metier.compute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//@ComponentScan(basePackages = {"com.laamrani.service"})
@ComponentScan(value = { "com.laamrani"})
@Configuration
class Myconfig {

}
