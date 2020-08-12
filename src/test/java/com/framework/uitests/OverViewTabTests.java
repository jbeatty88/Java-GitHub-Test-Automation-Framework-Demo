package com.framework.uitests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverViewTabTests extends BaseTestClass{
    String user = "jbeatty88";

    @BeforeEach
    void overviewTabSetup() {
        driver.get(BASE_GITHUB_URL + user);
    }

    @BeforeEach
    void localCleanup() {

    }

    @Test
    void userNameIsCorrectOnOverview() {
        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(user, actualUserName);

    }

    @Test
    void overviewRepoLinkGoesToCorrectRepo() {

        // Act
        String repoName = "Projects";
        /*This is how you can simulate and test a click event*/
        WebElement repoClick = driver.findElement(By.linkText(repoName));
        repoClick.click();
        /* Check the new URL after the click event to a new repo*/
        String updatedURL = driver.getCurrentUrl();

        // Assert
        assertEquals(BASE_GITHUB_URL + "jbeatty88/" + repoName, updatedURL);
    }
}
