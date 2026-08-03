package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.ConfigReader;

public class BaseClass {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext browserContext;
    public Page page;
    public HomePage homePage;
    public RegistrationPage registrationPage;
    public LoginPage loginPage;

    @Parameters("browser")
    @BeforeTest
    public void setup(@Optional("chrome") String browserName){

        playwright = Playwright.create();

        switch(browserName.toLowerCase()){

            case "chrome":
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            case "edge":
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
                break;

            case "firefox":
                browser = playwright.firefox().launch(
                        new BrowserType.LaunchOptions().setHeadless(false));
                break;

            default:
                throw new RuntimeException("Invalid Browser");
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();

        homePage = new HomePage(page);
        registrationPage = new RegistrationPage(page);
        loginPage = new LoginPage(page);
    }

    @AfterTest
    public void exit() {
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
