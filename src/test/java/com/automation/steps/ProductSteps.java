package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {
    ProductPage productPage = new ProductPage();

    @Then("verify user is on searched {string} product page")
    public void verifyUserIsOnSearchedProductPage(String productKey) {
        productPage.verifySearchedProductScreenIsDisplayedInApp(ConfigReader.getConfigValue(productKey));
    }

    @When("user clicks on a product from the search results")
    public void userClicksOnAProductFromTheSearchResults() {
        productPage.clicksOnItem();
    }

    @And("navigates next to search next product")
    public void navigatesNextToSearchNextProduct() {
        productPage.navigatesForNextProductSearching();
    }

    @And("clicks on the shopping cart icon")
    public void clicksOnTheShoppingCartIcon() {
        productPage.clickOnShoppingCartIcon();
    }

    @Then("verify user is on selected product screen {string}")
    public void verifyUserIsOnSelectedProductScreen(String validatedProductName) {
        Assert.assertTrue(productPage.verifyProductName(validatedProductName));
    }
}
