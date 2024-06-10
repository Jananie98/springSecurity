package com.greetings.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/greetings2")
public class Greeting2Controller {
    @GetMapping("")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello 2!");
    }

    @GetMapping("/bye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.ok("GoodBye2! See you later..");
    }
}
