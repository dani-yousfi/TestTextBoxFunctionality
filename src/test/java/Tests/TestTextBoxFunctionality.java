package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTextBoxFunctionality extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to(" https://demoqa.com/");
        scrollToElement(homepagePage.getElementsButton().get(0));
        homepagePage.clickOnCard("Elements");
        scrollToElement(sidebarPage.getButton().get(0));
        sidebarPage.clickOnButton("Text Box");
    }

    @Test
    public void successfulFormSendWithValidFormOfEmail() {
        String fullName = "User User";
        String validFormOfMail = "mail@mail.com";
        textBoxPage.inputFullName(fullName);
        textBoxPage.inputEmail(validFormOfMail);
        textBoxPage.inputCurrentAddress("dasdasd 123");
        textBoxPage.inputPermanentAddress("sdadasd 123");
        scrollToElement(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.getFullNameDisplayAfterSubmit().getText().contains(fullName));
        Assert.assertTrue(textBoxPage.getEmailDisplayAfterSubmit().getText().contains(validFormOfMail));
        Assert.assertTrue(textBoxPage.getBoxWithUserInfoAfterSubmit().getText().contains("dasdasd 123"));
    }

    @Test
    public void unsuccessfulFormSendWithInvalidFormOfEmail() {
        String fullName = "User User";
        String validFormOfMail = "mail";
        textBoxPage.inputFullName(fullName);
        textBoxPage.inputEmail(validFormOfMail);
        scrollToElement(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();

        boolean isDisplayed = false;
        try {
            isDisplayed = textBoxPage.getBoxWithUserInfoAfterSubmit().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(isDisplayed);

        Assert.assertTrue(textBoxPage.getErrorEmailForm().isDisplayed());

    }


}
