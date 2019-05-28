package org.sang.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }
    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba";
    }
    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }
    
}
