package com.theherakles.zamano.utils;

import com.theherakles.zamano.enums.BrowserType;

public class EnvironmentUtil {

  public static BrowserType getBrowserType(){
     return BrowserType.getByName(System.getProperty("browser"));
  }

  public static boolean isDesktopBrowser(){
    BrowserType browserType = getBrowserType();
    return (browserType == BrowserType.CHROME) || (browserType == BrowserType.EDGE) ||
        (browserType == BrowserType.FIREFOX) || (browserType == BrowserType.SAFARI);
  }

  public static boolean isAndroid(){
    BrowserType browserType = getBrowserType();
    return ((browserType == BrowserType.ANDROID_PHONE) || (browserType == BrowserType.ANDROID_TABLET));
  }

}
