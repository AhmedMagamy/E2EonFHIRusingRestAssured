package utilities.filiesUtility;

import utilities.Logger;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {
    private static FileReader reader = null;
    private static OutputStream output=null;
    private static String propRoot = "src/main/resources/";
    private static Properties property = new Properties();

    public static String getProperty(String propertyFileName, String propertyName) {
        String propPath = propRoot + propertyFileName;

        try {
            reader = new FileReader(propPath);
        } catch (FileNotFoundException e) {
            Logger.logMessage("No file found in the given path: " + propPath);
            e.printStackTrace();
        }

        try {
            property.load(reader);
        } catch (IOException e) {
            Logger.logMessage("Couldn't find any properties with the given property name: " + propertyName);
            e.printStackTrace();
        }
        return property.getProperty(propertyName);
    }

    public static void setProperty(String propertyFileName, String propertyName,String propertyValue) {
        String propPath = propRoot + propertyFileName;

        try {
            output = new FileOutputStream(propPath);
        } catch (FileNotFoundException e) {
            Logger.logMessage("No file found in the given path: " + propPath);
            e.printStackTrace();
        }

        try {
            property.load(reader);
        } catch (IOException e) {
            Logger.logMessage("Couldn't find any properties with the given property name: " + propertyName);
            e.printStackTrace();
        }
       property.setProperty(propertyName,propertyValue);
    }



}
