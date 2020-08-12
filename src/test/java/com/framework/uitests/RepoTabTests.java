package com.framework.uitests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepoTabTests extends BaseTestClass {

    @Test
    void repoCountIsCorrect() {
        // Act
        driver.get("https://github.com/jbeatty88?tab=repositories");

        List<WebElement> repoList = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // Assert
        assertEquals(20, repoList.size());
    }
}
