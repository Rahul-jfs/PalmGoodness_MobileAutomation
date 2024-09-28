package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import io.cucumber.java.*;

public class Hooks {


    @BeforeAll
    public static void setUpAll() {
        ConfigReader.initConfig();
        ExtentReportManager.initExtentReport();
    }

    @Before
    public void setUp(Scenario scenario) {
        CucumberReportManager.initReport(scenario);
        ExtentReportManager.createTest(scenario.getName());
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManager.getExtentTest().fail(scenario.getName() + " : FAILED");
            CucumberReportManager.attachScreenShot();
            ExtentReportManager.attachScreenShot();
        } else {
            ExtentReportManager.getExtentTest().pass(scenario.getName() + " : PASSED");
        }
        DriverManager.getDriver().quit();
    }

    @AfterAll
    public static void cleanUpAll() {
        ExtentReportManager.flush();
    }

}
