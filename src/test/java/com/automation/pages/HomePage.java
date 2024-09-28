package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    WebElement allowNotificationPopUp;

    @FindBy(xpath = "//android.view.View[@content-desc='skip']")
    WebElement skipButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    WebElement plumLogo;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search ']")
    WebElement searchBoxField;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement searchBoxTxt;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'trending at plum')]")
    WebElement trendingAtPlumForScroll;

    @FindBy(xpath = "//android.widget.HorizontalScrollView")
    WebElement bestOfFragrances;

    public void openApplication() {
        clickOnElementIfPresent(allowNotificationPopUp);
        clickOnElementIfPresent(skipButton);
    }

    public boolean verifyHomePage() {
        waitForElementToBeVisible(plumLogo);
        waitForElementToBeVisible(searchBoxField);
        return searchBoxField.isDisplayed();
    }

    public void enterValueOnSearchBar(String searchValue) {
        searchBoxField.click();
        searchBoxTxt.click();
        searchBoxTxt.sendKeys(searchValue);
    }

    public void selectProductCategory(String productCategory) {
        String productCategoryXpath = "//android.view.View[@content-desc='%s']";
        WebElement product = driver.findElement(By.xpath(String.format(productCategoryXpath, productCategory)));
        product.click();
    }

    public void selectProductFromDropDown(String productType) {
        String productTypeXpath = "//android.view.View[@content-desc='%s']";
        performScrollTillElementVisible(bestOfFragrances);
        WebElement productCategory = driver.findElement(By.xpath(String.format(productTypeXpath, productType)));
        productCategory.click();
    }
}
