package com.nicollet.soapclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class UniversityConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("universities.wsdl");
        return marshaller;
    }

    @Bean
    public UniversityClient universityClient(Jaxb2Marshaller marshaller) {
        UniversityClient client = new UniversityClient();
        client.setDefaultUri("http://localhost:7000/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
