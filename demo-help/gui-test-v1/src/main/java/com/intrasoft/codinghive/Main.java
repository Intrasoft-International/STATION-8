package com.intrasoft.codinghive;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test Suite: TS_CH_UI");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();

        suites.add("test_suites/TS_CH_UI.xml");
        String timeStamp = getTimestamp();
        new File("reports/TS_CH_UI_" + timeStamp).mkdirs();
        testng.setOutputDirectory("reports/TS_CH_UI_" + timeStamp);
        testng.setTestSuites(suites);
        testng.addListener(tla);
        testng.run();
    }

    private static String getTimestamp() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        return timeStamp;
    }
}
