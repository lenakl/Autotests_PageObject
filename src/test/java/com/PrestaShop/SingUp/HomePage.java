package com.PrestaShop.SingUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "header")
    private WebElement header;

    private By singUpLocator = By.cssSelector("[href=\"http://prestashop.qatestlab.com.ua/en/my-account\"]");

    private By mainSingUp = By.id("slider_row");

    public void open() {
        driver.get("http://prestashop.qatestlab.com.ua/en/");
    }

    public void getStarted() {
        header.findElement(singUpLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainSingUp));

    }
}
