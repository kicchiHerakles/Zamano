package com.theherakles.zamano.step_definitions.ui;

import com.theherakles.zamano.utils.BrowserUtil;
import com.theherakles.zamano.utils.DriverUtil;
import com.theherakles.zamano.utils.EnvironmentUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        BrowserUtil.turnOnImplicitWaits();
        if (EnvironmentUtil.isDesktopBrowser())
            DriverUtil.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) DriverUtil.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        DriverUtil.closeDriver();
    }
}
