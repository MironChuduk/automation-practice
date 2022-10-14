package automationpractice.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static automationpractice.common.Config.TEST_DATA_PROPERTIES_PATH;

public class PropertiesParser {

    public String[] parsProperties(String key) {
        FileInputStream propertyFile;
        Properties property = new Properties();

        try {
            propertyFile = new FileInputStream(TEST_DATA_PROPERTIES_PATH);
            property.load(propertyFile);
        } catch (IOException e) {
            System.err.println("ERROR! File of 'testData' is not found.");
        }
        String dataString = property.getProperty(key);
        return StringUtils.splitByWholeSeparatorPreserveAllTokens(dataString, ";");
    }
}