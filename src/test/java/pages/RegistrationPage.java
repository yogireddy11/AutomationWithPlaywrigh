package pages;

import base.BaseClass;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.DataProvider;
import utilities.FakerData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class RegistrationPage extends BaseClass {

    Page page;
    Locator signup;
    Locator pageTitle;
    Locator userName;
    Locator email;
    Locator password;
    Locator signupBtn;
    Locator errorMsg;
    Locator logOutBtn;
    public RegistrationPage(Page page){
        this.page=page;
        signup = page.locator("//a[@onclick=\"showSection('signup')\"]");
        pageTitle = page.getByText("Create New Account");
        userName = page.locator("#reg-name");
        email = page.locator("#reg-email");
        password = page.locator("#reg-password");
        signupBtn = page.locator("//button[text()='Create Account']");
        errorMsg = page.locator("//label[@class=\"block text-sm font-medium mb-2\"]");
        logOutBtn = page.locator("//div[@onclick=\"showSection('login')\"]");


    }
    public void gotoSignup(){
        signup.click();
        System.out.println(pageTitle.textContent());
        assertThat(pageTitle).isVisible();
    }


    public void userSignup(String user, String emailA, String pass){

        userName.fill(user);
        email.fill(emailA);
        password.fill(pass);
        final String[] alertMessage = new String[1];
        System.out.println(userName.inputValue()+" | "+email.inputValue()+" | "+password.inputValue());
        page.onceDialog(dialog -> {
            alertMessage[0] = dialog.message();
            System.out.println(alertMessage[0]);
            dialog.accept();
        });

        signupBtn.click();
    }





}
