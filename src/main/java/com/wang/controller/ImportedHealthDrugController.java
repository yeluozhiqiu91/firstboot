package com.wang.controller;

import com.wang.model.ImportHealthyDrug;
import com.wang.service.ImportHealthDrugService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.wang.chrome.Const.ChromeDriver_path;

/**
 * 进口保健药品
 */
@Controller
public class ImportedHealthDrugController {
    private static final int MAX_WORK_THEARD = Runtime.getRuntime().availableProcessors() + 6;

    public static String baseurl = "http://app1.sfda.gov.cn/datasearch/face3/content.jsp?tableId=31&tableName=TABLE31&tableView=进口保健食品&Id=";

    ExecutorService executor = Executors.newCachedThreadPool();


    @Autowired
    private ImportHealthDrugService service;

    @RequestMapping("/addImportedHealthDrug")
    @ResponseBody
    public String addItem() {
        System.setProperty("webdriver.chrome.driver", ChromeDriver_path);
        List<ImportHealthyDrug> taskList = new ArrayList<ImportHealthyDrug>();

        dividMainWorkThreads(MAX_WORK_THEARD, 1000);
//        dividMainWorkThreads(MAX_WORK_THEARD, 10);
        return "添加成功！";
    }

    private ImportHealthyDrug detectPage(WebDriver webdriver, int pageId) {
        ImportHealthyDrug model = null;
        try {
            model = null;

            String url = baseurl + (pageId);
            webdriver.get(url);
            if (webdriver.findElement(By.cssSelector(".listmain")).findElements(By.tagName("tr")).get(2).getText().equals("没有相关信息")) {//空白页
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

    private ImportHealthyDrug initPageItem(List<WebElement> webElementList, String url) {
        ImportHealthyDrug item = new ImportHealthyDrug();
        item.url = url;
        for (int k = 1; k <= 39; k++) {
            String value = webElementList.get(k).findElements(By.tagName("td")).get(1).getText();
            switch (k) {
                case 1:
                    item.setProductor_name_en(value);
                    break;
                case 2:
                    item.setUnregister_reason(value);
                    break;
                case 3:
                    item.setAddre(value);
                    break;
                case 4:
                    item.setHealth_func(value);
                    break;
                case 5:
                    item.setConstitute(value);
                    break;
                case 6:
                    item.setMain_material(value);
                    break;
                case 7:
                    item.setUnlimite_scope(value);
                    break;
                case 8:
                    item.setLimite_scope(value);
                    break;
                case 9:
                    item.setSpecification(value);
                    break;
                case 10:
                    item.setExpiration_date(value);
                    break;
                case 11:
                    item.setReserve_method(value);
                    break;
                case 12:
                    item.setLookout(value);
                    break;
                case 13:
                    item.setApproval_change_date(value);
                    break;
                case 14:
                    item.setChanged_content(value);
                    break;
                case 15:
                    item.setRecord_date(value);
                    break;
                case 16:
                    item.setExchanger_name(value);
                    break;
                case 17:
                    item.setExchanger_name_en(value);
                    break;
                case 18:
                    item.setExchanger_addre(value);
                    break;
                case 19:
                    item.setTaker(value);
                    break;
                case 20:
                    item.setTaker_addr(value);
                    break;
                case 21:
                    item.setApproval_before(value);
                    break;
                case 22:
                    item.setExchange_date(value);
                    break;
                case 23:
                    item.setSupplement_date(value);
                    break;
                case 24:
                    item.setExtra_hint(value);
                    break;
                case 25:
                    item.setProduct_name_en(value);
                    break;
                case 26:
                    item.setApproval_date(value);
                    break;
                case 27:
                    item.setApplicant_chinese_name(value);
                    break;
                case 28:
                    item.setProduct_sn(value);
                    break;
                case 29:
                    item.setApproval(value);
                    break;
                case 30:
                    item.setProduct_name(value);
                    break;
                case 31:
                    item.setApplicant_name(value);
                    break;
                case 32:
                    item.setApplicant_addre(value);
                    break;
                case 33:
                    item.setCompany_name(value);
                    break;
                case 34:
                    item.setProduce_county(value);
                    break;
                case 35:
                    item.setUse_illustration(value);
                    break;
                case 36:
                    item.setRecord_content(value);
                    break;
                case 37:
                    item.setTaker_en(value);
                    break;
                case 38:
                    item.setValidate_date_to(value);
                    break;
                case 39:
                    item.setUnregister_date(value);
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
                    List<ImportHealthyDrug> taskList = new ArrayList<ImportHealthyDrug>();

                    long start = System.currentTimeMillis();
                    System.out.println("开始 from page ( " + finalFromIndex + " to " + finalToIndex);

                    for (int page = finalFromIndex; page <= finalToIndex; page++) {//主要分页
                        ImportHealthyDrug model = detectPage(webdriver, page);
                        if (model != null) {
                            taskList.add(model);
                        }
                    }

                    for (ImportHealthyDrug model :
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
