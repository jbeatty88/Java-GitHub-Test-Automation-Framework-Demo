package com.framework.uitests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.testframwork.DriverFactory.getGeckoDriver;

public class BaseTestClass {

    public static final String BASE_GITHUB_URL = "https://github.com/";

    /* Steps to speed it up
     *     Make sure setup and cleanup execute after ALL not EACH (otherwise it opens a bunch of windows)
     *     Make the driver and Before/After All methods static
     * */
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = getGeckoDriver();
    }

    @AfterAll
    static void cleanup() {
        driver.close();
    }

}
