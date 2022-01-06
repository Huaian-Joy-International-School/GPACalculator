package top.zhanganzhi.gpacalculator.utils;

import java.util.Properties;

public record ApplicationProperties(Properties properties) {
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getName() {
        return getProperty("name");
    }

    public String getVersion() {
        return getProperty("version");
    }

    public int getWidth() {
        return Integer.parseInt(getProperty("width"));
    }

    public int getHeight() {
        return Integer.parseInt(getProperty("height"));
    }
}
