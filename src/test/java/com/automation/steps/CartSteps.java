package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {
    CartPage cartPage = new CartPage();

    @Then("verify item is added into cart and should displays {string}")
    public void verifyItemIsAddedIntoCartAndShouldDisplays(String cartItemsCount) {
        Assert.assertTrue(cartPage.takesCartCount().contains(cartItemsCount));
    }

    @And("user views the cart contents")
    public void userViewsTheCartContents() {
        Assert.assertTrue(cartPage.cartContentsIsDisplayed());
    }

    @When("user clicks on remove button next to an item")
    public void userClicksOnRemoveButtonNextToAnItem() {
        cartPage.clickOnRemoveButton();
    }

    @Then("the item {string} should be removed from the cart")
    public void theItemShouldBeRemovedFromTheCart(String removedProductKey) {
        Assert.assertFalse(cartPage.getCartContentText(removedProductKey).contains(ConfigReader.getConfigValue("search.value1")));
    }

    @And("the cart should display the updated cart count")
    public void theCartShouldDisplayTheUpdatedCartCount() {
        Assert.assertTrue(cartPage.takesCartCount().contains("1"));
    }

    @Then("verify the total cart value is correct based on product prices")
    public void verifyTheTotalCartValueIsCorrectBasedOnProductPrices() {
        Assert.assertTrue(cartPage.validatingTheCartPriceIsMatchingWithCalculatedPrice());
    }

    @And("user enters pin code {string}")
    public void userEntersPinCode(String pinCodeKey) {
        cartPage.enterPinCodeText(pinCodeKey);
    }

    @Then("then validate whether pin code is valid or not")
    public void thenValidateWhetherPinCodeIsValidOrNot() {
        Assert.assertTrue(cartPage.findPinCodeIsValidOrNot().contains("delivery by"));
    }
}
