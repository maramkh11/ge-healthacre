package web.basic;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Report;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    private WebDriver webDriver;

    @BeforeMethod
    protected void startBrowser() {
        open();
        webDriver = Selenide.webdriver().driver().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    protected void tearDown() {
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
    }

    protected void getPage(String url) {
        Report.info("Get %s Page", url);
        webDriver.get(url);
    }

}
