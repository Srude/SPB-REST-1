package com.spb.webserver11.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @GetMapping
    public String getName() {
        return "cannip"
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
    public ResponseEntity<MemDT>

}
