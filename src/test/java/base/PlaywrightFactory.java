package base;

import com.microsoft.playwright.*;
import utilities.ConfigReader;

public class PlaywrightFactory {

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> context  = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static void init(String browserName){

        playwright.set(Playwright.create());
         browserName = ConfigReader.getProperties("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperties("headless"));
        BrowserType browserType;
        switch (browserName.toLowerCase()){
            case "firefox":
                browserType = playwright.get().firefox();
                break;
            case "webkit":
                browserType = playwright.get().webkit();
                break;
            default:
                browserType = playwright.get().chromium();
                break;
        }

        browser.set(browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless)));
        context.set(browser.get().newContext(new Browser.NewContextOptions().setViewportSize(1920,1080)));
        page.set(context.get().newPage());
    }

    public static Page getPage(){
        return page.get();
    }
    public static void clear(){
        context.get().close();
        browser.get().close();
        playwright.get().close();

        page.remove();
        context.remove();
        browser.remove();
        playwright.remove();
    }

}
