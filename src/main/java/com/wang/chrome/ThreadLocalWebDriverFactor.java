package com.wang.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.wang.chrome.Const.ChromeDriver_path;

/**
 * 每个线程持有一个webclient 线程内部实例，简单粗暴，不出问题。
 */
public class ThreadLocalWebDriverFactor {

    //单例工厂模式
    private final static ThreadLocalWebDriverFactor instance = new ThreadLocalWebDriverFactor();

    public static ThreadLocalWebDriverFactor getInstance() {
        return instance;
    }

    // 覆写ThreadLocal的initialValue方法
    //线程的本地实例存储器，用于存储WebClient实例
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>() {

        @Override
        //该方法ThreadLocal变量第一次get的时候执行,如果该线程已经执行过set方法，initialValue不会执行
        protected synchronized WebDriver initialValue() {
//            set  local driver path  and  proxy related
            System.setProperty("webdriver.chrome.driver", ChromeDriver_path);
            //now with no proxy for full speed .
//            Properties sysProps = System.getProperties();
//            sysProps.put("proxySet", "true");
//            sysProps.put("proxyHost", "jp1-sta73.tj07a.website");
//            sysProps.put("proxyPort", "43193");

            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            options.addArguments("--start-maximized");

            //Instantiate Web Driver
            WebDriver webdriver = new ChromeDriver(options);
            return webdriver;
        }
    };



    public WebDriver getWebDriver() {
        return webDriver.get();

//        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--headless");
////        options.addArguments("--start-maximized");
////        Instantiate Web Driver
//        WebDriver webdriver = new ChromeDriver(options);
//        return webdriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver.set(webDriver);
    }
}
