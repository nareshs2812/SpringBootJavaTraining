package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");
        Student s = (Student) context.getBean("st");
        s.internshipProgram();
        SpringBoot f = (SpringBoot) context.getBean("fun");
        f.hello("hello");
//      System.out.println("Hello World");
        Register r = (Register) context.getBean("regi");
        r.reg("register");
        Login l = (Login) context.getBean("lo");
        l.log("login");
        Attendclass ac = (Attendclass) context.getBean("atte");
        ac.att("attend");
        ViewProfile vp = (ViewProfile) context.getBean("viewp");
        vp.pro("view profile");
        logout lo = (logout) context.getBean("logo");
        lo.logou("logout");
    }
}