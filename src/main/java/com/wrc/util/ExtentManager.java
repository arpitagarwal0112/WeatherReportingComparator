package com.wrc.util;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            Date d=new Date();
            String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
            extent = new ExtentReports(System.getProperty("user.dir")+"\\reports\\"+fileName, true, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
            // optional
            extent.addSystemInfo("Selenium Version", "2.53.1").addSystemInfo(
                    "Environment", "QA");
        }
        return extent;
    }
}
