package com.PrestaShop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPosNegLogin {

    @Test
    public void singUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(100, 100));
        driver.get("http://prestashop.qatestlab.com.ua/en/");

        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.cssSelector("[href=\"http://prestashop.qatestlab.com.ua/en/my-account\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slider_row")));

        //  Логинимся
        driver.findElement(By.id("email")).sendKeys("elena_klymenko@ukr.net");
        driver.findElement(By.id("passwd")).sendKeys("Password");
        driver.findElement(By.id("SubmitLogin")).click();


        // driver.getCurrentUrl() - получаете урлу у страницы личного кабинета, а потом сравниваете с помощью assertEquals
        String strURL = driver.getCurrentUrl();
        Assert.assertTrue(strURL.equals("http://prestashop.qatestlab.com.ua/en/my-account"));

        // Вылогинимся
        //header = driver.findElement(By.id("header"));
        //header.findElement(By.cssSelector("[href=\"http://prestashop.qatestlab.com.ua/en/?mylogout=\"]")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitCreate")));

        // driver.getCurrentUrl() - получаете урлу у страницы, а потом сравниваете с помощью assertEquals
        //String strURL = driver.getCurrentUrl();
        //Assert.assertTrue(strURL.equals("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account"));

        driver.quit();
    }

    @Test
    public void singUpFailed() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(100, 100));
        driver.get("http://prestashop.qatestlab.com.ua/en/");

        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.cssSelector("[href=\"http://prestashop.qatestlab.com.ua/en/my-account\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slider_row")));

        //  Логинимся
        driver.findElement(By.id("email")).sendKeys("elena_klymenko@ukr.net");
        driver.findElement(By.id("passwd")).sendKeys("Fogotten");
        driver.findElement(By.id("SubmitLogin")).click();

        // Не должны уйти с текущей страницы и получить сообщение об ошибке
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"alert alert-danger\"]")));
        WebElement errorBlock = driver.findElement(By.cssSelector("[class=\"alert alert-danger\"]"));
        //Assert.assertTrue(errorSingUp.equals("There is 1 error"));
        String errorSingUp = errorBlock.findElement(By.cssSelector("li")).getText();
        Assert.assertTrue(errorSingUp.equals("Authentication failed."));

        // Вылогинимся
        //header = driver.findElement(By.id("header"));
        //header.findElement(By.cssSelector("[href=\"http://prestashop.qatestlab.com.ua/en/?mylogout=\"]")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitCreate")));

        // driver.getCurrentUrl() - получаете урлу у страницы, а потом сравниваете с помощью assertEquals
        //strURL = driver.getCurrentUrl();
        //Assert.assertTrue(strURL.equals("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account"));

        driver.quit();
    }

}
