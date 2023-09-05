import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.os.ExecutableFinder;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


public class TestClass1 extends FluentTest{

    @Override
    public String getWebDriver()
    {
        return "chrome";
    }

    @Override
    public Capabilities getCapabilities()
    {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        return options;
    }

    @BeforeClass
    public static void setup() {
            WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test1()
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),60);

        //Updated for google search images
        LocalFileDetector fileDetector = new LocalFileDetector();
        goTo("https://www.google.com/");
        File file = fileDetector.getLocalFile("/Users/sanpsicro/Desktop/images.png");
        getDriver().findElement(By.xpath("//div[@class='nDcEnd']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='encoded_image']")));
        getDriver().findElement(By.xpath("//input[@name='encoded_image']")).sendKeys(file.getAbsolutePath());


    }



}
