package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//android.view.View[@content-desc='cart']/following-sibling::android.view.View[1]")
    WebElement cartCount;

    @FindBy(xpath = "//android.view.View[@content-desc='cart']//following-sibling::android.view.View/android.view.View//android.view.View[@content-desc][1]")
    WebElement cartContentField;

    @FindBy(xpath = "(//android.view.View[@content-desc='1'])[1]//following-sibling::android.widget.ImageView")
    WebElement removeIcon;

    @FindBy(xpath = "//android.view.View[@content-desc='remove']")
    WebElement removeButtonInDialogBox;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'order summary')]")
    WebElement orderSummaryField;

    @FindBy(xpath = "//android.view.View[@content-desc='checkout']")
    WebElement checkOutBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='cart']/following-sibling::android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[@content-desc]")
    List<WebElement> individualProductDescriptionTexts;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'delivery address')]")
    WebElement deliveryAddressField;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement checkDeliveryPinCodeTxt;

    @FindBy(xpath = "//android.view.View[@content-desc='check']")
    WebElement checkButtonClickForPinCode;

    
    public boolean cartContentsIsDisplayed() {
        return cartContentField.isDisplayed();
    }

    
    public void clickOnRemoveButton() {
        removeIcon.click();
        removeButtonInDialogBox.click();
    }
    
    public String getCartContentText(String removedProductName) {
        return "//android.view.View[contains(@content-desc,'%s')]";
    }

    public String takesCartCount() {
        return getContentDescriptionOfAnElement(cartCount);
    }

    public String sendCartEmptyText() {
        return "";
    }

    public boolean validatingTheCartPriceIsMatchingWithCalculatedPrice() {
        double totalCalculatedPrice = calculateTotalPriceFromProductList(individualProductDescriptionTexts);

        performScrollTillElementVisible(orderSummaryField);
        performScrollToMovePage();

        String cartSummaryTxt = getContentDescriptionOfAnElement(orderSummaryField);

        double toPayPriceDisplayedInApp = extractValueFromOrderSummaryText(cartSummaryTxt, "to pay");

        return totalCalculatedPrice==toPayPriceDisplayedInApp;
    }

    public void clicksOnCheckOutButton() {
        checkOutBtn.click();
    }

    public void enterPinCodeText(String pinCodeTxt) {
        performScrollTillElementVisible(deliveryAddressField);
        checkDeliveryPinCodeTxt.click();
        checkDeliveryPinCodeTxt.sendKeys(pinCodeTxt);
    }

    public String findPinCodeIsValidOrNot() {
        checkButtonClickForPinCode.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return checkDeliveryPinCodeTxt.getAttribute("hint");
    }
}
