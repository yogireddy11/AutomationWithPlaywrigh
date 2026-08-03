package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import utilities.FakerData;

public class AutomationTests extends BaseClass {

    @Test(priority = 1)
    public void gotoAPK(){
        homePage.navigateToAPK();
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
        loginPage.loginApk("admin","admin");
        loginPage.successMsg();
    }

//    @Test(priority = 3,dataProvider = "SignupData",dataProviderClass = DataProviderClass.class)
//    public void verifySignUp(String username,
//                             String email,
//                             String password){
//
//        registrationPage.userSignup( username,  email,  password);
//    }
}
