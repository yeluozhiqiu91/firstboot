package com.wang.task;


import com.wang.chrome.ChromeWebDriver;
import com.wang.model.BaseModel;
import com.wang.service.impl.BaseServiceImpl;
import com.wang.utils.RegexUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.wang.chrome.Const.MAX_WORK_THEARD;

/**
 * 通用 查询器材
 */
@Component
@Controller
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    private TaskParam taskParam;

    /**
     * 总分页数目
     */
    private int totalPage = 0;
    /**
     * 本任务总条数。
     */
    private int totalCount = 0;

    /**
     * 数据口中已经插入的条目数
     */
    private int total_exist = 0;

    ExecutorService executor = Executors.newCachedThreadPool();

    List<Long> existsList = new ArrayList<Long>();
    @Autowired
    private BaseServiceImpl service;

    public void startTask(TaskParam taskParam) {
        this.taskParam = taskParam;

        initTotalPage();
        if (totalPage <= 0) {
            logger.info("总分页数查询失败", "totalPage:" + totalPage);
            return;
        }
        queryPageIds();
        dividSubWorkThreads(MAX_WORK_THEARD, 1, totalPage);
//        dividSubWorkThreads(2, 1, 10);
    }


    public String queryPageIds() {
        List<Long> list = service.queryPageIds(taskParam.taskName);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.size());
        existsList.clear();
        existsList.addAll(list);
        return "success";
    }

    @ResponseBody
    public String addItem() {
        return "添加成功！";
    }


    /**
     * 初始化最大条数
     *
     * @return
     */
    public int initTotalPage() {
        int result = 0;
        WebDriver webdriver = ChromeWebDriver.getWebDriver(false);


        String pageIndex = "1";
        webdriver.get(taskParam.pagedListURL + pageIndex);//默认拿第一页来查

        String totalPageString = "";
        String totalMissioncount = "";
        try {
            totalPageString = RegexUtils.getFirstMatch(webdriver.getPageSource().toString(), "共", "\\d+", "页");
            totalMissioncount = RegexUtils.getFirstMatch(webdriver.getPageSource().toString(), "共", "\\d+", "条");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            totalPage = Integer.parseInt(totalPageString);
            totalCount = Integer.parseInt(totalMissioncount);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        logger.info("总分页数" + totalPage + "     总条数 ： " + totalMissioncount);
        webdriver.close();
        return result;
    }


    public boolean isExist(long pageid) {
        if (existsList != null && existsList.size() > 0) {
            return existsList.contains(pageid);
        } else {
            return false;
        }
    }

    private BaseModel detectPage(WebDriver webdriver, int pageId) {
//        WebDriver webdriver = webdriver = ChromeWebDriver.getWebDriver();


        BaseModel model = null;
        try {
            String url = taskParam.baseurl + (pageId);
            webdriver.get(url);

            boolean haspage = true;
            try {//a[contains(@href, ‘logout’)]
                haspage = webdriver.findElement(By.xpath("//div[contains(@class,'listmain')]")).findElements(By.tagName("tr")).get(2).getText().equals("没有相关信息");
            } catch (Exception e) {
//                e.printStackTrace();
                haspage = false;
            }

            if (haspage) {//空白页
                System.out.println("----  " + pageId);
                return null;
            } else {
                List<WebElement> webElementList = webdriver.findElement(By.cssSelector(".listmain")).findElements(By.tagName("tr"));
                model = initPageItem(webElementList, url, pageId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        webdriver.close();

        return model;
    }

    private BaseModel initPageItem(List<WebElement> webElementList, String url, int pageId) {
        BaseModel item = new BaseModel();
        item.taskName = taskParam.taskName;
        item.pageId = pageId;
        item.url = url;

        for (int k = 1; k < webElementList.size(); k++) {

            String value = null;
            try {
                value = webElementList.get(k).findElements(By.tagName("td")).get(1).getText();
            } catch (Exception e) {
                continue;
            }
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
                case 24:
                    item.setC24(value);
                    break;
                case 25:
                    item.setC25(value);
                    break;
                case 26:
                    item.setC26(value);
                    break;
                case 27:
                    item.setC27(value);
                    break;
                case 28:
                    item.setC28(value);
                    break;
                case 29:
                    item.setC29(value);
                    break;
                case 30:
                    item.setC30(value);
                    break;
                case 31:
                    item.setC31(value);
                    break;
                case 32:
                    item.setC32(value);
                    break;
                case 33:
                    item.setC33(value);
                    break;
                case 34:
                    item.setC34(value);
                    break;
                case 35:
                    item.setC35(value);
                    break;
                case 36:
                    item.setC36(value);
                    break;
                case 37:
                    item.setC37(value);
                    break;
                case 38:
                    item.setC38(value);
                    break;
                case 39:
                    item.setC39(value);
                    break;
                case 40:
                    item.setC40(value);
                    break;
                case 41:
                    item.setC41(value);
                    break;
                case 42:
                    item.setC42(value);
                    break;
                case 43:
                    item.setC43(value);
                    break;
                case 44:
                    item.setC44(value);
                    break;
                case 45:
                    item.setC45(value);
                    break;
                case 46:
                    item.setC46(value);
                    break;
                case 47:
                    item.setC47(value);
                    break;
                case 48:
                    item.setC48(value);
                    break;
                case 49:
                    item.setC49(value);
                    break;
                case 50:
                    item.setC50(value);
                    break;

                default:
                    break;
            }

        }
        return item;
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
                toIndex = fromIndex + taskSize;
            }

            if (taskSize == 0) {//强制初始化
                toIndex = totalNum;
            }

            final int finalFromIndex = fromIndex;
            final int finalToIndex = toIndex;
            executor.execute(new Runnable() {
                @Override
                public void run() {
//                    每页15条
                    System.out.println("开始 from page [ " + finalFromIndex + " to " + (finalToIndex) + ")");
                    for (int page = finalFromIndex; page < finalToIndex; page++) {//主要分页

                        System.out.println("current pageIndex  :" + page);

                        getCurrent_PageIdList(page);
                    }
                }
            });
        }
    }

    /**
     * 获取列表页的15条URL 的pageId
     *
     * @param currentPageIndex 当前分页数
     * @return
     */
    public void getCurrent_PageIdList(int currentPageIndex) {
        long start = System.currentTimeMillis();

        List<BaseModel> list = new ArrayList<BaseModel>();
        WebDriver webdriver = webdriver = ChromeWebDriver.getWebDriver();

        webdriver.get(taskParam.pagedListURL + currentPageIndex);

        List<Integer> currentPageIdlist = new ArrayList<Integer>();

        List<WebElement> elements = webdriver.findElements(By.xpath("//a[contains(@href, 'content.jsp?tableId=')]"));
        for (WebElement ele : elements) {
            String id = RegexUtils.getFirstMatch(ele.getAttribute("href").toString(), "&Id=", "\\d+", "',");
            Integer pageId = null;
            try {
                pageId = Integer.parseInt(id);
                currentPageIdlist.add(pageId);
                logger.info("id:  " + id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                logger.error(ele.getAttribute("href"));
            }
        }


        for (int i = 0; i < currentPageIdlist.size(); i++) {
            int pageId = currentPageIdlist.get(i);

            if (isExist(pageId)) {
                System.out.println("page is exixt" + pageId + "     exixtCount : " + ++total_exist);//当前数据已经存在
                continue;
            }

            BaseModel model = detectPage(webdriver, pageId);
            if (model != null) {
                list.add(model);
            }
        }
        webdriver.close();


        //每跑完一页就保存一次
        for (BaseModel model :
                list) {
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

    }


}
