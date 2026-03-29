package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            System.err.println("Không thể tải cấu hình database: " + e.getMessage());
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url", "jdbc:mysql://localhost:3306/quanlychuyenbay");
    }

    public static String getUser() {
        return properties.getProperty("db.user", "root");
    }

    public static String getPassword() {
        return properties.getProperty("db.password", "123456");
    }

    public static String getDriver() {
        return properties.getProperty("db.driver", "com.mysql.cj.jdbc.Driver");
    }
}