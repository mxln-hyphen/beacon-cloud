package com.mxln.beaconapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {
        "com.mxln.beaconapi",
        "com.mxln.beaconcommon.utils"
})
public class ApiStarterApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiStarterApp.class,args);
    }
}