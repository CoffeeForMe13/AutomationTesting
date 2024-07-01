package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

    private Properties properties;

    public ConfigurationLoader(String propertyFilePath){
        properties = new Properties();

        try(FileInputStream inputStream = new FileInputStream(propertyFilePath)){
            //because inputStream is in the try parenthesis, the cleanup is done by java
            properties.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException("Fisierul de proprietati nu a fost gasit in locatia " + propertyFilePath);
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
