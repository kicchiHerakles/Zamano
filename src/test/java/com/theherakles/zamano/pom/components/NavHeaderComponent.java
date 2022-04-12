package com.theherakles.zamano.pom.components;

import com.theherakles.zamano.annotations.Desktop;
import com.theherakles.zamano.annotations.Phone;
import com.theherakles.zamano.utils.AbstractPage;
import com.theherakles.zamano.utils.DriverUtil;
import java.util.Locale;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Desktop(NavHeaderComponent.class)
@Phone(NavHeaderComponentMobile.class)
public class NavHeaderComponent extends AbstractPage {
  protected WebDriver driver;

  protected NavHeaderComponent(){
    driver = DriverUtil.getDriver();
    PageFactory.initElements(driver, this);
  }

  protected final String menuRootSelector = "//li[@class='w3-hide-small']";

  public WebElement getNavMenuByName(String menuName){
    return driver.findElement(
        By.xpath(menuRootSelector + "//a[@href='#" + menuName.toLowerCase(Locale.ROOT).replace(" ", "") + "']"));
  }
}

class NavHeaderComponentMobile extends  NavHeaderComponent{
  protected final String menuRootSelector = "//div[@id='navDemo']";

  @FindBy(xpath = "//i[@class='fa fa-bars']")
  private WebElement navMenuOpener;

  private WebElement getMenuRootElement(){
    return driver.findElement(By.xpath(menuRootSelector));
  }

  @Override
  public WebElement getNavMenuByName(String menuName){
    openNavHeaderMenu();
    return driver.findElement(
        By.xpath(menuRootSelector + "//a[@href='#" + menuName.toLowerCase(Locale.ROOT).replace(" ", "") + "']"));
  }

  public void openNavHeaderMenu(){
    String navMenuOpenerClasses = getMenuRootElement().getAttribute("class");
    if (!navMenuOpenerClasses.contains("w3-show"))
      navMenuOpener.click();
  }
}