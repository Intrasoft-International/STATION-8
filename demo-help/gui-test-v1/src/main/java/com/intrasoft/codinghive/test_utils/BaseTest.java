package com.intrasoft.codinghive.test_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.nio.file.Paths;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

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

    public static String getResourcesPath() {
        String filePathString = getAbsolutePath() + "/src/main/resources";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = getAbsolutePath();
        return filePathString;
    }

    private static String getAbsolutePath() {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        return absPath.replace("\\", "/");
    }

}
