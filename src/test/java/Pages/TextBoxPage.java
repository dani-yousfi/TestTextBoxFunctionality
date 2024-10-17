package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {

    WebDriver driver;
    WebElement fullNameField, emailField, currentAddressField, permanentAddressField, submitButton, boxWithUserInfoAfterSubmit, fullNameDisplayAfterSubmit, emailDisplayAfterSubmit, errorEmailForm;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullNameField() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressField() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressField() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.cssSelector("button[id='submit']"));
    }

    public WebElement getFullNameDisplayAfterSubmit() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailDisplayAfterSubmit() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getBoxWithUserInfoAfterSubmit() {
        return driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12"));
    }

    public WebElement getErrorEmailForm() {
        return driver.findElement(By.cssSelector(".mr-sm-2.field-error.form-control"));
    }

    //---------------------------------------------------

    public void inputFullName(String fullName) {
        getFullNameField().clear();
        getFullNameField().sendKeys(fullName);
    }

    public void inputEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress) {
        getCurrentAddressField().clear();
        getCurrentAddressField().sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress) {
        getPermanentAddressField().clear();
        getPermanentAddressField().sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }


}
