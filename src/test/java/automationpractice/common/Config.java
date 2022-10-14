package automationpractice.common;

public class Config {

    public static final String CHROME_PATH = "src/test/resources/chromedriver";
    public static final String TEST_DATA_PROPERTIES_PATH = "src/test/resources/testData.properties";
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    /**
     * To keep the browser open after suite
     * if true - browser close
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;
}
