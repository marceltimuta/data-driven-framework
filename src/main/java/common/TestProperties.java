package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static Properties readConfigProps() {
        Properties config = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

}
