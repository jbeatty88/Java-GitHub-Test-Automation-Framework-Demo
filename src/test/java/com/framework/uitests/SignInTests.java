package com.framework.uitests;

import com.testframwork.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class SignInTests extends BaseTestClass {
    @Test
    void invalidLoginFailsToSignIn() {
        // Act
        driver.get(BASE_GITHUB_URL + "login");

        driver.findElement(By.id("login-field")).sendKeys("somelogin");
        driver.findElement(By.id("password")).sendKeys(StringUtils.generateRandomString(5));
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        boolean isErrorDisplayed = driver.findElement(By.className("flash-error")).isDisplayed();

        // Assert
        assertTrue(isErrorDisplayed);

    }
}
