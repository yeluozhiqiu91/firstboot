package com.wang.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.wang.chrome.Const.ChromeDriver_path;

public class ChromeWebDriver {

    private boolean hasUI = false;

    /**
     * 默认 有UI
     *
     * @return
     */
    public static WebDriver getWebDriver() {
        return getWebDriver(false);
    }

    /**
     * 是否显示UI
     *
     * @param hasUI
     * @return
     */
    public static WebDriver getWebDriver(boolean hasUI) {
        System.setProperty("webdriver.chrome.driver", ChromeDriver_path);
        //now with no proxy for full speed .
//            Properties sysProps = System.getProperties();
//            sysProps.put("proxySet", "true");
//            sysProps.put("proxyHost", "jp1-sta73.tj07a.website");
//            sysProps.put("proxyPort", "43193");

        ChromeOptions options = new ChromeOptions();
        if (!hasUI) {
            options.addArguments("--headless");
        }
        options.addArguments("--start-maximized");

        //Instantiate Web Driver
        WebDriver webdriver = new ChromeDriver(options);
        return webdriver;
    }

}
