//package com.wang.chrome;
//
//import org.apache.commons.pool2.BasePooledObjectFactory;
//import org.apache.commons.pool2.PooledObject;
//import org.apache.commons.pool2.impl.DefaultPooledObject;
//import org.apache.commons.pool2.impl.GenericObjectPool;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import static com.wang.chrome.Const.ChromeDriver_path;
//import static org.apache.commons.pool2.impl.GenericObjectPoolConfig.DEFAULT_MIN_IDLE;
//
//public class ChromeDriverPoolFactory extends BasePooledObjectFactory<WebDriver> {
//    static GenericObjectPool<WebDriver> pool = null;
//
//    // 取得对象池工厂实例
//    public synchronized static GenericObjectPool<WebDriver> getInstance() {
//        if (pool == null) {
//            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//            poolConfig.setMaxIdle(10);
//            poolConfig.setMaxTotal(60);
//            poolConfig.setMinIdle(10);
//            poolConfig.setLifo(false);
//            pool = new GenericObjectPool<WebDriver>(new ChromeDriverPoolFactory(), poolConfig);
//        }
//        return pool;
//    }
//
//    public static WebDriver borrowObject() throws Exception {
//        return (WebDriver) ChromeDriverPoolFactory.getInstance().borrowObject();
//    }
//
//    public static void returnObject(WebDriver WebDriver) throws Exception {
//        ChromeDriverPoolFactory.getInstance().returnObject(WebDriver);
//    }
//
//    public static void close() throws Exception {
//        ChromeDriverPoolFactory.getInstance().close();
//    }
//
//    public static void clear() throws Exception {
//        ChromeDriverPoolFactory.getInstance().clear();
//    }
//
//    @Override
//    public WebDriver create() throws Exception {
//        System.setProperty("webdriver.chrome.driver", ChromeDriver_path);
//        //now with no proxy for full speed .
////            Properties sysProps = System.getProperties();
////            sysProps.put("proxySet", "true");
////            sysProps.put("proxyHost", "jp1-sta73.tj07a.website");
////            sysProps.put("proxyPort", "43193");
//
//        ChromeOptions options = new ChromeOptions();
////            options.addArguments("--headless");
//        options.addArguments("--start-maximized");
//
//        //Instantiate Web Driver
//        WebDriver webdriver = new ChromeDriver(options);
//        return webdriver;
//    }
//
//    @Override
//    public PooledObject<WebDriver> wrap(WebDriver webDriver) {
////        WebDriver d = null;
////        try {
////            d = create();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        return new DefaultPooledObject<WebDriver>(webDriver);
//    }
//
//}
