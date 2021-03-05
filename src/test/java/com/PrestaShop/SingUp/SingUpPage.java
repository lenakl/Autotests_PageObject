package com.PrestaShop.SingUp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "email")
    private WebElement eMail;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(css = "[class=\"alert alert-danger\"]")
    private WebElement errorMsgLocator;

    private By errorMsgText = By.cssSelector("li");

    public void openSingUpForm() {
        ;
    }

    public void fillEmail( String strEmail) {
        eMail.sendKeys(strEmail);
    }

    public void fillPassword( String strPassword) {
        password.sendKeys(strPassword);
    }

    public void submitForm() {
        submitLogin.click();
    }

    public String getCurrentUrl() {
       return driver.getCurrentUrl();
    }

    // Errors
    public String checkErrorRequedField() {
        return errorMsgLocator.findElement(errorMsgText).getText();
    }

}
