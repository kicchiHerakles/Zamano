package com.theherakles.zamano.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.theherakles.zamano.config.ApplicationConfig;
import java.io.File;

/**
 * reads the properties file configuration.yml
 */
public class ConfigurationReaderUtil {

    public static ApplicationConfig getConfiguration(){
        try{
            File file = new File("src/test/resources/configuration.yml");
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            ApplicationConfig applicationConfig = objectMapper.readValue(file, ApplicationConfig.class);
            return applicationConfig;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}