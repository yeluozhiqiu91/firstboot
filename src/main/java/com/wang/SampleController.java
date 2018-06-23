package com.wang;

import com.wang.task.BaseController;
import com.wang.task.TaskParam;
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


        TaskParam taskParam = new TaskParam("国产器械"
                , "http://app1.sfda.gov.cn/datasearch/face3/search.jsp?tableId=26&State=1&bcId=118103058617027083838706701567&State=1&tableName=TABLE26&State=1&viewtitleName=COLUMN184&State=1&viewsubTitleName=COLUMN181,COLUMN180&State=1&State=1&tableView=%25E5%259B%25BD%25E4%25BA%25A7%25E5%2599%25A8%25E6%25A2%25B0&State=1&curstart="
                , "http://app1.sfda.gov.cn/datasearch/face3/content.jsp?tableId=26&tableName=TABLE26&tableView=国产器械&Id=");


        baseController.startTask(taskParam);



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
