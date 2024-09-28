package com.automation.steps;

import com.automation.pages.ProductDescriptionPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ProductDescriptionSteps {

    ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();

    @Then("user should be redirected to the product details page")
    public void userShouldBeRedirectedToTheProductDetailsPage() {
        Assert.assertTrue("Items Description Page is not displayed",productDescriptionPage.productDescriptionPageDisplayed());
    }

    @When("user clicks the Add to Cart button")
    public void userClicksTheAddToCartButton() {
        productDescriptionPage.clickOnAddToCartBtn();
    }
}
