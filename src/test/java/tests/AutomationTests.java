package tests;

import base.BaseClass;
import listeners.TestListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.FakerData;

//@Listeners(TestListeners.class)
public class AutomationTests extends BaseClass {

    @Test(priority = 1)
    public void gotoAPK(){

        homePage.verifyNavigation();
        homePage.getPageTitle();

    }

    @Test(priority = 2)
    public void verifySignup(){
        registrationPage.gotoSignup();
        registrationPage.userSignup(FakerData.userName(),FakerData.emailAddress(),FakerData.password());
    }
    @Test(priority = 3)
    public void login(){
        loginPage.navigateLoginPage();
        loginPage.loginApk(ConfigReader.getProperties("user"),ConfigReader.getProperties("pass"));
        loginPage.successMsg();
    }
    @Test(priority = 4)
    public void checkoutCart(){
        itemsPage.checkOutItem();
    }
    @Test(priority = 5)
    public void verifySearchBar(){
        itemsPage.searchItem("shirt");
    }
}
