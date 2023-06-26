package com.spb.rest.service;

import com.spb.webserver11.data.dto.MemberDTO;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
@Service
public class RestTemplateService {
    public String getName(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8088")
                .path("crud-api")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String > responseEntity = restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();

    }

    public String getNameWithPathVariable(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8088")
                .path("crud-api/{name}")
                .encode()
                .build()
                .expand("srude")
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String > responseEntity = restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();
    }

    public String getNameWithParameter(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8088")
                .path("crud-api/param")
                .queryParam("name", "srude")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String > responseEntity = restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();
    }


    public ResponseEntity<MemberDTO> postWithParamAndBody(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8088")
                .path("crud-api")
                .queryParam("name", "srude")
                .queryParam("email", "srude@nya.nyan")
                .queryParam("organization", "PJF")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("srude");
        memberDTO.setEmail("srude@nya.nyan");
        memberDTO.setOrganization("uPJF");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);
        return responseEntity;
    }

    public ResponseEntity<MemberDTO> postWithHeader(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8088")
                .path("crud-api/add-header")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("srude");
        memberDTO.setEmail("srude@nya.nyan");
        memberDTO.setOrganization("uPJF");

        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri)
                .header("my-header", "my-header-api")
                .body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);
        return responseEntity;
    }


}

