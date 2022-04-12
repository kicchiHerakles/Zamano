package com.theherakles.zamano.utils;

import com.theherakles.zamano.annotations.Desktop;
import com.theherakles.zamano.annotations.Phone;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

@Log4j2
public class PageFactory {

  public static <T extends AbstractPage> T create(Class<T> clazz, Object... args){
    T newPage = null;
    String className = "UNSET_CLASS_NAME";

    try {
      Class<? extends Annotation> annotation = null;
      switch (EnvironmentUtil.getBrowserType()) {
        case CHROME:
          annotation = Desktop.class;
          break;
        case ANDROID_PHONE:
          annotation = Phone.class;
          break;
        default:
          throw new RuntimeException("PageFactory could not determine factory config key.");
      }

      Class<?> platformClass = null;
      if (clazz.isAnnotationPresent(annotation)) {
        Annotation annotationInstance = clazz.getAnnotation(annotation);
        platformClass = (Class) annotationInstance.getClass().getMethod("value")
            .invoke(annotationInstance);
      }

      if (platformClass == null) {
        throw new UnsupportedOperationException(
            "No valid implementation was found for " + clazz.getCanonicalName());
      }

      Constructor<?> constructor = platformClass.getDeclaredConstructor();
      constructor.setAccessible(true);
      //newPage = (AbstractPage)clazz.cast(constructor.newInstance(args));
      newPage = (T) constructor.newInstance(args);
      className = newPage.getClass().getSimpleName();

      log.info("PageFactory has created " + className);
    }catch (Exception ex){
      log.warn("Exception thrown waiting for " + className);
      log.warn("Cause: " + ex.getCause() + " --- Message: " + ex.getMessage());
      ex.printStackTrace();
      Assert.fail("Cause: " + ex.getCause() + " --- Message: " + ex.getMessage());
    }

    return newPage;
  }

}
