package org.mykola.spilcaSecurityStudy.rest;

import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

import java.security.Principal;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Object role = authentication.getCredentials();
        Object details = authentication.getDetails();
        System.out.println("Hello, principal name "+principal.getName()+"! authentication name is "+name+"\n details\n"+details);
        return "Hello, principal name "+principal.getName()+"! authentication name is "+name+"\n details\n"+details;
    }

    @GetMapping("/ciao")
    public String ciao() throws Exception{
        Callable<String>task= ()->{
            SecurityContext context = SecurityContextHolder.getContext();
            return context.getAuthentication().getName();
        };
//        return "Name from Callable is "+task.call();
        ExecutorService e = Executors.newCachedThreadPool();
        try {
            var contextTask = new DelegatingSecurityContextCallable<>(task);
            return "Ciao, " + e.submit(contextTask).get() + "! "+contextTask.toString();
        } finally {
            e.shutdown();
        }
    }
}
