package com.testframwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver getGeckoDriver() {
        // Create the driver object
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions().addArguments("start-fullscreen");

        /*BUG FIX: This is important. This tells the test harness how to run the browser*/
        options.setBinary("/opt/firefox/firefox-bin");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
