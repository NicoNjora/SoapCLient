package com.nicollet.soapclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import universities.wsdl.GetAllUniversitiesResponse;
import universities.wsdl.GetUniversityResponse;

@SpringBootApplication
public class SoapClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(UniversityClient quoteClient) {
        return args -> {
            String university = "Strathmore";

            if (args.length > 0) {
                university = args[0];
            }
            GetUniversityResponse response = quoteClient.getUniversity(university);
            System.err.println(response.getUniversity().getLocation());

            System.out.println("List All Universities");
            GetAllUniversitiesResponse allResponse = quoteClient.getAllUniversities();
            allResponse.getUniversity().stream().forEach(
                    e-> System.out.println(e.getName() + " " + e.getLocation() + " " + e.getYearFounded())
            );
        };
    }

}
