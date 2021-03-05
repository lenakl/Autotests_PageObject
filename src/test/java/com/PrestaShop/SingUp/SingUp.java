package com.PrestaShop.SingUp;

import com.PrestaShop.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingUp extends WebDriverSettings {

    @Test
    public void singUp() {
        // Инициализация страницы
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getStarted();

        //  Логинимся
        SingUpPage singUpPage = PageFactory.initElements(driver, SingUpPage.class);
        singUpPage.fillEmail("elena_klymenko@ukr.net");
        singUpPage.fillPassword("Password");
        singUpPage.submitForm();

        // Позитивный тест
        Assert.assertTrue(singUpPage.getCurrentUrl().equals("http://prestashop.qatestlab.com.ua/en/my-account"));
    }

    @Test
    public void singUpFailed() {
        // Инициализация страницы
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getStarted();

        //  Логинимся
        SingUpPage singUpPage = PageFactory.initElements(driver, SingUpPage.class);
        singUpPage.fillEmail("elena_klymenko@ukr.net");
        singUpPage.fillPassword("Fogotten");
        singUpPage.submitForm();

        // Негативный тест
        Assert.assertTrue(singUpPage.checkErrorRequedField().equals("Authentication failed."));
   }

}
