package com.theherakles.zamano.pom;

import com.theherakles.zamano.annotations.Desktop;
import com.theherakles.zamano.annotations.Phone;
import com.theherakles.zamano.pom.components.NavHeaderComponent;
import com.theherakles.zamano.utils.AbstractPage;
import com.theherakles.zamano.utils.DriverUtil;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Desktop(HomePage.class)
@Phone(HomePagePhone.class)
public class HomePage extends AbstractPage {
  public HomePage(){
    super();
    PageFactory.initElements(DriverUtil.getDriver(), this);
  }

  @FindBy(xpath = "//h1/b")
  private WebElement pageName;
}

class HomePagePhone extends HomePage {


}