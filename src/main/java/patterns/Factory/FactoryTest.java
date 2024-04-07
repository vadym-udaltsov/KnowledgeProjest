package patterns.Factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FactoryTest {

    @Test
    public void mobileTest() {
        WebDriver driver = DriverTestFactory.getTestDriver("ios");
        WebElement signButton = driver.findElement(By.xpath("//button[text()='signButton']"));
        Assertions.assertTrue(signButton.isDisplayed());
    }

    @Test
    public void androidTest() {
        WebDriver driver = DriverTestFactory.getTestDriver("android");
        WebElement signButton = driver.findElement(By.xpath("//button[text()='signButton']"));
        Assertions.assertTrue(signButton.isDisplayed());
    }

    @Test
    public void webTest() {
        WebDriver driver = DriverTestFactory.getTestDriver("windows");
        WebElement signButton = driver.findElement(By.id("L2AGLb"));
        Assertions.assertTrue(signButton.isDisplayed());
    }
}
