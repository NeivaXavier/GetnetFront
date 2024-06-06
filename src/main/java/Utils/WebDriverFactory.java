package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu"); 
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage"); 
        options.addArguments("--disable-extensions"); 
        options.addArguments("--disable-popup-blocking"); 
        options.addArguments("--remote-allow-origins=*"); 
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
