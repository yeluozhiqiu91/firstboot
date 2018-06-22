package com.wang.controller;

import com.wang.chrome.ThreadLocalWebDriverFactor;
import com.wang.model.HomeMadeInstrument;
import com.wang.model.ImportHealthyDrug;
import com.wang.service.impl.HomeMadeInstrumentServiceImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.wang.chrome.Const.ChromeDriver_path;
import static com.wang.chrome.Const.MAX_WORK_THEARD;

/**
 * 国产器械
 */
@Controller
public class HomeMadeInstrumentController {
    /**
     * 列表页 get  分页请求头，
     */
    public static String pagedListURL = "http://app1.sfda.gov.cn/datasearch/face3/content.jsp?tableId=26&tableName=TABLE26&tableView=国产器械&Id=";

    /**
     * 详情页 get请求头，
     */
    public static String baseurl = "http://app1.sfda.gov.cn/datasearch/face3/content.jsp?tableId=26&tableName=TABLE26&tableView=国产器械&Id=";

    ExecutorService executor = Executors.newCachedThreadPool();

    List<Long> existsList = new ArrayList<Long>();
    @Autowired
    private HomeMadeInstrumentServiceImpl service;

    @RequestMapping("/queryInstrumentid")
    public String queryPageIds() {
        List<Long> list = service.queryPageIds();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.size());
        return "success";
    }

    @RequestMapping("/homeMade_intrument")
    @ResponseBody
    public String addItem() {
        System.setProperty("webdriver.chrome.driver", ChromeDriver_path);
        List<ImportHealthyDrug> taskList = new ArrayList<ImportHealthyDrug>();
        existsList = service.queryPageIds();

        //patche
//        dividSubWorkThreads(MAX_WORK_THEARD , 94987, 100000);

        //full task
        dividSubWorkThreads(MAX_WORK_THEARD, 1, 100000);
        return "添加成功！";
    }

    public boolean isExist(long pageid) {
        if (existsList != null && existsList.size() > 0) {
            return existsList.contains(pageid);
        } else {
            return false;
        }
    }

    private HomeMadeInstrument detectPage(WebDriver webdriver, int pageId) {
        HomeMadeInstrument model = null;
        try {
            model = null;

            String url = baseurl + (pageId);
            webdriver.get(url);

            boolean haspage = true;
            try {
                haspage = webdriver.findElement(By.cssSelector(".listmain")).findElements(By.tagName("tr")).get(2).getText().equals("没有相关信息");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("没有相关信息 页面错误" + pageId);
            }

            if (haspage) {//空白页
                System.out.println("----  " + pageId);
                return null;
            } else {
                List<WebElement> webElementList = webdriver.findElement(By.cssSelector(".listmain")).findElements(By.tagName("tr"));
                model = initPageItem(webElementList, url);
                model.pageId = pageId;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    private HomeMadeInstrument initPageItem(List<WebElement> webElementList, String url) {
        HomeMadeInstrument item = new HomeMadeInstrument();
        item.url = url;
        for (int k = 1; k <= 23; k++) {
            String value = webElementList.get(k).findElements(By.tagName("td")).get(1).getText();
            switch (k) {
                case 1:
                    item.setC1(value);
                    break;
                case 2:
                    item.setC2(value);
                    break;
                case 3:
                    item.setC3(value);
                    break;
                case 4:
                    item.setC4(value);
                    break;
                case 5:
                    item.setC5(value);
                    break;
                case 6:
                    item.setC6(value);
                    break;
                case 7:
                    item.setC7(value);
                    break;
                case 8:
                    item.setC8(value);
                    break;
                case 9:
                    item.setC9(value);
                    break;
                case 10:
                    item.setC10(value);
                    break;
                case 11:
                    item.setC11(value);
                    break;
                case 12:
                    item.setC12(value);
                    break;
                case 13:
                    item.setC13(value);
                    break;
                case 14:
                    item.setC14(value);
                    break;
                case 15:
                    item.setC15(value);
                    break;
                case 16:
                    item.setC16(value);
                    break;
                case 17:
                    item.setC17(value);
                    break;
                case 18:
                    item.setC18(value);
                    break;
                case 19:
                    item.setC19(value);
                    break;
                case 20:
                    item.setC20(value);
                    break;
                case 21:
                    item.setC21(value);
                    break;
                case 22:
                    item.setC22(value);
                    break;
                case 23:
                    item.setC23(value);
                    break;
                default:
                    break;
            }

        }
        return item;
    }


    public void dividMainWorkThreads(int threadNum, int totalPages) {
        int taskSize = totalPages / threadNum;

        if (taskSize == 0) {
            threadNum = 1;
        }

        if (totalPages % threadNum != 0) {
            threadNum++;
        }

        for (int i = 0; i < threadNum; i++) {
            int fromIndex, toIndex;
            fromIndex = taskSize * i + 1;

            if (taskSize * (i + 1) > totalPages) {
                toIndex = fromIndex + totalPages % taskSize;
            } else {
                toIndex = taskSize * (i + 1);
            }

            if (taskSize == 0) {//强制初始化
                toIndex = totalPages;
            }

            final int finalFromIndex = fromIndex;
            final int finalToIndex = toIndex;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    WebDriver webdriver = new ChromeDriver();
                    List<HomeMadeInstrument> taskList = new ArrayList<HomeMadeInstrument>();

                    long start = System.currentTimeMillis();
                    System.out.println("开始 from page ( " + finalFromIndex + " to " + finalToIndex);

                    for (int page = finalFromIndex; page <= finalToIndex; page++) {//主要分页
                        if (isExist(page)) {
                            System.out.println("page is exixt" + page);
                            continue;
                        }

                        HomeMadeInstrument model = detectPage(webdriver, page);
                        if (model != null) {
                            taskList.add(model);
                        }
                    }

                    for (HomeMadeInstrument model :
                            taskList) {
                        try {
                            service.addItem(model);
                        } catch (Exception e) {
                            System.out.println(model.toString());
                            e.printStackTrace();
                        }
                    }

                    System.out.println((System.currentTimeMillis() - start) / 1000.0 + "秒结束。");
                    System.out.println((System.currentTimeMillis() - start) / 1000.0 / 60 + "分钟结束。");
                    System.out.println((System.currentTimeMillis() - start) / 1000.0 / 60 / 60 + "小时结束。");

                    webdriver.close();
                }
            });
        }
    }

    public void dividSubWorkThreads(int threadNum, int start, int to) {
        int totalNum = (to - start + 1);
        int taskSize = totalNum / threadNum;

        if (taskSize == 0) {
            threadNum = 1;
        }

        if (totalNum % threadNum != 0) {
            threadNum++;
        }

        for (int i = 0; i < threadNum; i++) {
            int fromIndex, toIndex;
            fromIndex = start + taskSize * i;

            if (taskSize * (i + 1) > totalNum) {
                toIndex = fromIndex + totalNum % taskSize;
            } else {
                toIndex = fromIndex + taskSize - 1;
            }

            if (taskSize == 0) {//强制初始化
                toIndex = totalNum;
            }

            final int finalFromIndex = fromIndex;
            final int finalToIndex = toIndex;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //Set Chrome Headless mode as TRUE
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");

                    //Instantiate Web Driver
                    WebDriver webdriver = ThreadLocalWebDriverFactor.getInstance().getWebDriver();

                    List<HomeMadeInstrument> taskList = new ArrayList<HomeMadeInstrument>();

                    long start = System.currentTimeMillis();
                    System.out.println("开始 from page ( " + finalFromIndex + " to " + finalToIndex);

                    for (int page = finalFromIndex; page <= finalToIndex; page++) {//主要分页
                        if (isExist(page)) {
                            System.out.println("page is exixt" + page);
                            continue;
                        }

                        HomeMadeInstrument model = detectPage(webdriver, page);
                        if (model != null) {
                            taskList.add(model);

                            if (taskList.size() == 20) {
                                for (HomeMadeInstrument m :
                                        taskList) {
                                    try {
                                        service.addItem(m);
                                    } catch (Exception e) {
                                        System.out.println(m.toString());
                                        e.printStackTrace();
                                    }
                                }

                                taskList.clear();
                            }
                        }
                    }

                    for (HomeMadeInstrument model :
                            taskList) {
                        try {
                            service.addItem(model);
                        } catch (Exception e) {
                            System.out.println(model.toString());
                            e.printStackTrace();
                        }
                    }

                    System.out.println((System.currentTimeMillis() - start) / 1000.0 + "秒结束。");
                    System.out.println((System.currentTimeMillis() - start) / 1000.0 / 60 + "分钟结束。");
                    System.out.println((System.currentTimeMillis() - start) / 1000.0 / 60 / 60 + "小时结束。");

                    webdriver.close();
                }
            });

        }
    }


}
