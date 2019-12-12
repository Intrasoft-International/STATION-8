package com.intrasoft.codinghive.test_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Page page;

    @BeforeTest
    public void setUp() {
        //OPEN BROWSER AND APPLICATION URL
        System.setProperty("webdriver.chrome.driver", getResourcesPath() + "/chromedriver.exe");

        //create a new chrome driver
        driver = new ChromeDriver();

        // navigate to web application
        driver.get("http://localhost:7001");

        // define a global wait variable (e.g. 10 seconds until test fail)
        wait = new WebDriverWait(driver, 10);

        page = new Page();
        //maximize window
        //driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    /**
     * This is a method that return if an element exists or not
     *
     * @param by is the element locator
     * @return true when an element exists, false for the opposite
     */
    public Boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0)
            return true;
        else
            return false;
    }

    /**
     * This is method is used for dynamic waits until the page is loaded
     *
     */
    public void waitForLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(500);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     * This method returns the path of resources folder
     * @return
     */
    public static String getResourcesPath() {
        String filePathString = getAbsolutePath() + "/src/main/resources";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = getAbsolutePath();
        return filePathString;
    }

    /**
     * This method returns the absolute path of the test application (.jar file)
     * @return
     */
    private static String getAbsolutePath() {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        return absPath.replace("\\", "/");
    }

    /**
     * This method instantiates the Page Object Elements
     */
    protected void initPageFactory() {
        PageFactory.initElements(driver, this);
    }

    /**
     * This method returns a list of properties with prefix the test case ID (no step as suffix)
     * @return
     */
    public Properties getTestData() {
        return getProperties(
                loadProperties(getResourcesPath() + "/test_data/test_data.properties"), getClassName(), 0);
    }

    /**
     * This method returns a list of properties with prefix the test case ID and with a suffix the test step number
     * @return
     */
    public Properties getTestData(int step) {
        return getProperties(
                loadProperties(getResourcesPath() + "/test_data/test_data.properties"), getClassName(), step);
    }

    /**
     * This method returns the Class Name of the Test Case (Test Case ID)
     * @return
     */
    private String getClassName() {
        return this.getClass().getSimpleName();
    }

    /**
     * This method is used by method 'getTestData' and is used to load properties (test data) from external property files
     * @param testDataFile is the path of the property test data file
     * @return
     */
    private Properties loadProperties(String testDataFile) {
        Properties prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream(testDataFile);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            prop.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * This method is used from the 'getTestData' method and returns specific subset based on prefix (test case id) and suffix (test step number)
     * @param params properties as were returned by method "loadProperties"
     * @param prefix test case id prefix to get subset of properties
     * @param step  test step number suffix to get subset of properties
     * @return
     */
    private Properties getProperties(Properties params, String prefix, int step) {
        Properties result = new Properties();

        Enumeration<?> names = params.propertyNames();

        if (step > 0) {
            prefix += "." + step;
        }
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();

            if (name.indexOf(prefix) == 0) {
                result.put(name.substring(prefix.length() + 1), params.get(name));
            }
        }

        return result;
    }


}
