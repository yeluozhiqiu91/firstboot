package com.wang;

import com.wang.controller.BaseController;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 */
@SpringBootApplication
@MapperScan("com.wang.mapper")
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    BaseController baseController;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);// 进口药品
    }


    @PostConstruct
    public void postConstruct() throws Exception {
        //项目启动后，在这里执行数据抓取任务
        long startTime = System.currentTimeMillis();

//        baseController.initTotalPage();
        baseController.startTask();



        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        StringBuilder sb = new StringBuilder();
        sb.append(costTime % 1000).append("毫秒");
        if (costTime > 1000) {
            costTime = costTime / 1000;
            sb.insert(0, "秒");
            sb.insert(0, costTime % 60);
        }
        if (costTime > 60) {
            costTime = costTime / 60;
            sb.insert(0, "分钟");
            sb.insert(0, costTime % 60);
        }
        if (costTime > 60) {
            costTime = costTime / 60;
            sb.insert(0, "小时");
            sb.insert(0, costTime % 60);
        }
        logger.info("任务结束，耗时{}", sb.toString());
    }

}
