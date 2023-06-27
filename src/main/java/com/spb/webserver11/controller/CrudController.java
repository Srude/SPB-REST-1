package com.spb.webserver11.controller;

import com.spb.webserver11.data.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @GetMapping
    public String getName() {
        return "cannip";
    }

    @GetMapping("/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }

    @GetMapping("/param")
    public String getNameWithParam(@RequestParam String name){
        return "hola" + name +"~~~~" ;
    }

    @PostMapping
    public ResponseEntity<MemberDTO> getMember(
            @RequestBody MemberDTO request,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        System.out.println(request.getName());
        System.out.println(request.getEmail());
        System.out.println(request.getOrganization());
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);
        memberDTO.setEmail(email);
        memberDTO.setOrganization(organization);
        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDTO> addHeader(@RequestHeader("my-header") String header, @RequestBody MemberDTO memberDTO){

        System.out.println(header);

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }


}
