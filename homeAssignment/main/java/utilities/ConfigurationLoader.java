package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileOutputStream;

public class ConfigurationLoader {

    private final Properties properties;

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
//
//    Properties property = new Properties();
//
//    public void addProperty(String propertyFilePath, String key, String value){
//        try(FileInputStream inputStream = new FileInputStream(propertyFilePath)){
//            //because inputStream is in the try parenthesis, the cleanup is done by java
//            properties.load(inputStream);
//        } catch (IOException e){
//            throw new RuntimeException("Fisierul de proprietati nu a fost gasit in locatia " + propertyFilePath);
//        }
//
//        try(OutputStream outputStream = new FileOutputStream(propertyFilePath)){
//
//            property.setProperty(key, value);
//            property.store(outputStream, null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
