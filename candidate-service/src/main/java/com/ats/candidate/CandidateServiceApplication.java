package com.ats.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CandidateServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CandidateServiceApplication.class, args);
        System.out.println("Candidate Service running on port 8082");
    }
}
