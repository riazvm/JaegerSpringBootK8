package com.example.ordermgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.opentracing.Tracer;

@RestController
public class OrderMgrController {

    @Autowired
    private RestTemplate restTemplate;

    private static String accountMgrUrl = System.getProperty("ACCOUNTMGR_URL", System.getenv("ACCOUNTMGR_URL"));
    //private static String accountMgrUrl = "http://localhost:9090";
    
    //@Autowired
    //private Tracer tracer;

    @RequestMapping("/buy")
    public String buy() throws InterruptedException {
        Thread.sleep(1 + (long)(Math.random()*500));
       // Optional.ofNullable(tracer.activeSpan()).ifPresent(as -> as.setBaggageItem("transaction", "buy"));
        //try (Scope scope = tracer.buildSpan("SomeWork").startActive(true)) {
          //  scope.span().setTag("work", "buying");

            ResponseEntity<String> response = restTemplate.getForEntity(accountMgrUrl + "/account", String.class);
            return "BUY + " + response.getBody();
        //}
    }

    @RequestMapping("/sell")
    public String sell() throws InterruptedException {
        Thread.sleep(1 + (long)(Math.random()*500));
        //Optional.ofNullable(tracer.activeSpan()).ifPresent(as -> as.setBaggageItem("transaction", "sell"));
        ResponseEntity<String> response = restTemplate.getForEntity(accountMgrUrl + "/account", String.class);
        return "SELL + " + response.getBody();
    }

    @RequestMapping("/fail")
    public String fail() throws InterruptedException {
        Thread.sleep(1 + (long)(Math.random()*500));
        ResponseEntity<String> response = restTemplate.getForEntity(accountMgrUrl + "/missing", String.class);
        return "FAIL + " + response.getBody();
    }

    @RequestMapping("/health")
    public String getHealth() throws InterruptedException {
        return "Ok";
    }

}
