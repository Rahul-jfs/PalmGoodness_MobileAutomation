package com.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='FILTERS']/../android.view.View/android.view.View/android.view.View[1]")
    WebElement selectProductField;

    @FindBy(xpath = "//android.view.View[@content-desc='cart']/../android.widget.ImageView[1]")
    WebElement cartScreenToNavigatesBack;

    @FindBy(xpath = "(//android.view.View[@content-desc]/../../..//following-sibling::android.widget.ImageView)[1]")
    WebElement productDescScreenToNavigatesBack;

    @FindBy(xpath = "(//android.view.View[@content-desc]/../android.widget.ImageView)[1]")
    WebElement productScreenToNavigatesBack;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4]")
    WebElement shoppingCartIcon;

    @FindBy(xpath = "(//android.view.View[@content-desc='notify me']/..)[1] | (//android.view.View[@content-desc='add to cart']/..)[1]")
    WebElement firstProductInSearchedResults;


    public void verifySearchedProductScreenIsDisplayedInApp(String productValue) {
        String searchedProductXpath = "//android.view.View[@content-desc='%s']";
        driver.findElement(By.xpath(String.format(searchedProductXpath, productValue))).isDisplayed();
    }

    public void clicksOnItem() {
        waitForElementToBeVisible(selectProductField);
        selectProductField.click();
    }

    public void navigatesForNextProductSearching() {
        cartScreenToNavigatesBack.click();
        productDescScreenToNavigatesBack.click();
        productScreenToNavigatesBack.click();
    }

    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    
    public boolean verifyProductName(String validatedProductName) {
        waitForElementToBeVisible(firstProductInSearchedResults);
        return getContentDescriptionOfAnElement(firstProductInSearchedResults).contains(validatedProductName);
    }
}
