package io.javabrains.springbootconfig.controller;

import io.javabrains.springbootconfig.config.DbSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class GreetingController {

    @Value("${my.greeting: default valueee}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${dbValues}}")
    private Map<String, String> mapvalue = new HashMap<>();

    @Autowired
    private DbSetting dbSetting;
    @Autowired
    private Environment env;


    @GetMapping("/greeting")
    public String greetings() {
        return greetingMessage + listValues + mapvalue + dbSetting.getHost() + dbSetting.getPort();
    }

    @GetMapping("/envdetails")
    public String envdetail() {
        return env.toString();
    }
}
