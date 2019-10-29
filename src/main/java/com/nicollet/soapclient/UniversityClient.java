package com.nicollet.soapclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import universities.wsdl.GetAllUniversitiesRequest;
import universities.wsdl.GetAllUniversitiesResponse;
import universities.wsdl.GetUniversityRequest;
import universities.wsdl.GetUniversityResponse;

public class UniversityClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(UniversityClient.class);

    public GetUniversityResponse getUniversity(String university) {

        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(university);

        log.info("Requesting location for " + university);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7000/ws/universities", request,
                        new SoapActionCallback(
                                "http://localhost:7000/ws/universities"));

        return response;
    }

    public GetAllUniversitiesResponse getAllUniversities() {

        GetAllUniversitiesRequest request = new GetAllUniversitiesRequest();
        log.info("Get All Universities ");

        GetAllUniversitiesResponse response = (GetAllUniversitiesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7000/ws/universities", request);

        return response;
    }

}
