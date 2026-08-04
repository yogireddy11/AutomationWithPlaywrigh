package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;
import pages.ItemsPage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.ConfigReader;

public class BaseClass {


    public HomePage homePage;
    public RegistrationPage registrationPage;
    public LoginPage loginPage;
    public ItemsPage itemsPage;

    @Parameters("browser")
    @BeforeTest
    public void setup(@Optional("chrome")String browser) {
        PlaywrightFactory.init(browser);
        PlaywrightFactory.getPage().navigate(ConfigReader.getProperties("baseURL"));


        homePage = new HomePage(PlaywrightFactory.getPage());
        registrationPage = new RegistrationPage(PlaywrightFactory.getPage());
        loginPage = new LoginPage(PlaywrightFactory.getPage());
        itemsPage = new ItemsPage(PlaywrightFactory.getPage());
    }

    @AfterTest
    public void exit() {
        PlaywrightFactory.clear();
    }
}
