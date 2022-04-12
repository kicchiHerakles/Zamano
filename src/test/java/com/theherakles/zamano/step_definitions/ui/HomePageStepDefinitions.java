package com.theherakles.zamano.step_definitions.ui;

import com.theherakles.zamano.pom.HomePage;
import com.theherakles.zamano.pom.components.NavHeaderComponent;
import com.theherakles.zamano.utils.ConfigurationReaderUtil;
import com.theherakles.zamano.utils.DriverUtil;
import com.theherakles.zamano.utils.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

@Log4j2
public class HomePageStepDefinitions {
  private NavHeaderComponent navHeaderComponent;

  @Given("Home page is loaded")
  public void home_page_is_loaded() {
    log.info("STEP - Navigate to home page");
    DriverUtil.getDriver().get(ConfigurationReaderUtil.getConfiguration().getMainPageUrl());
    navHeaderComponent = PageFactory.create(NavHeaderComponent.class);
    log.info("STEP - Home Page loaded");
  }

  @Then("user should see the following menus in the navigation bar")
  public void user_should_see_the_following_menus_in_the_navigation_bar(List<String> menuNames) {
    for (String menuName:menuNames) {
      log.info("VERIFY - " + menuName + " is visible at navigation bar");
      Assert.assertTrue(menuName + " is not visible!", navHeaderComponent.getNavMenuByName(menuName).isDisplayed());
    }
  }
}
