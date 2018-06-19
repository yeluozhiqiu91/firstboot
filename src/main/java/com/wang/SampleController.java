package com.wang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 */
@SpringBootApplication
@MapperScan("com.wang.mapper")
public class SampleController {
    @RequestMapping("/hello")
    @ResponseBody
    String home(){
        return "Hello World!";
    }

    public static void main(String[] args) {
        //System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(SampleController.class,args);// 进口药品

//        SpringApplication.run(SampleController.class,args);// 进口药品



    }
}
