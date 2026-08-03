package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import static org.testng.Assert.*;


public class LoginPage {
    public Page page;
    Locator navigateLogin;
    Locator userName;
    Locator password;
    Locator loginBtn;
    Locator pageTitle;
    Locator loginMsg;

    public LoginPage(Page page){
        this.page=page;
        navigateLogin = page.locator("//a[@onclick=\"showSection('login')\"]");
        userName = page.locator("#login-username");
        password = page.locator("#login-password");
        loginBtn = page.locator("//button[@onclick=\"handleLogin()\"]");
        pageTitle = page.getByText("Login to your account");
        loginMsg = page.locator("#login-message");

    }

    public void navigateLoginPage(){
        navigateLogin.click();
        System.out.println(pageTitle.textContent());
        assertThat(pageTitle).isVisible();

    }

    public void loginApk(String user, String pass){
        userName.fill(user);
        password.fill(pass);
        loginBtn.click();
    }
    public void successMsg(){
        String msg = loginMsg.textContent();
        System.out.println(msg);
        assertTrue(msg.contains("Login successful"));
    }

}
