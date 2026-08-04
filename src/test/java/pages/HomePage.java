package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.ConfigReader;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;


public class HomePage {

    Page page;



    public HomePage(Page page){
        this.page=page;

    }

    public void verifyNavigation(){
        System.out.println("Navigate URL | "+page.url());
         assertThat(page).hasURL(ConfigReader.getProperties(("baseURL")));
    }

    public void getPageTitle(){
        Locator title = page.locator("//div[@class=\"flex items-center gap-3\"]");
        System.out.print(title.textContent());
    }

}
