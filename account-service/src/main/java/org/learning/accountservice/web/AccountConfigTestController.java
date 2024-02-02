package org.learning.accountservice.web;

import org.learning.accountservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccountConfigTestController {

    @Value("${global.params.x}")
    private int p1;

    @Value("${global.params.y}")
    private int p2;

    @Value("${customer.params.z}")
    private int p3;

    @Value("${customer.params.w}")
    private int p4;

    private final GlobalConfig globalConfig;

    AccountConfigTestController(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }
    @GetMapping("/testconfig")
    public Map<String, Integer> getAllParams() {
        return Map.of("p1", p1, "p2", p2, "p3", p3, "p4", p4);
    }

    @GetMapping("/globalconfig")
    public GlobalConfig globalConfig() {
        return globalConfig;
    }
}
