package com.maciejfec;

import com.maciejfec.baseclass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions extends BaseClass {

    @Before
    public void setUp() {

        super.setUp();
        // Goes to specified page
        super.getDriver().get(super.getBaseUrl());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {

        super.tearDown();
    }

    @Given("I am on the index page")
    public void i_am_on_the_index_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click the {string} button")
    public void i_click_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The number is increased")
    public void the_number_is_increased() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The number is decreased")
    public void the_number_is_decreased() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The number should be {int}")
    public void the_number_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
