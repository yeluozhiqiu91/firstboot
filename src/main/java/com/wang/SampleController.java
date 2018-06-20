package com.wang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

import static com.wang.chrome.Const.ChromeDriver_path;

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
        System.setProperty("webdriver.chrome.driver", ChromeDriver_path);
        Properties sysProps = System.getProperties();
        sysProps.put("proxySet", "true");
        sysProps.put("proxyHost", "jp1-sta73.tj07a.website");
        sysProps.put("proxyPort", "43193");

        SpringApplication.run(SampleController.class,args);// 进口药品


    }
}
