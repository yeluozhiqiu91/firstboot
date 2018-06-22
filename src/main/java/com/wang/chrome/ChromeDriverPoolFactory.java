package com.wang.chrome;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.wang.chrome.Const.ChromeDriver_path;

public class ChromeDriverPoolFactory extends BasePooledObjectFactory<WebDriver> {

    @Override
    public WebDriver create() throws Exception {
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

    @Override
    public PooledObject<WebDriver> wrap(WebDriver webDriver) {
        return new DefaultPooledObject<WebDriver>(webDriver);
    }
}
