package base;

import com.microsoft.playwright.Page;

public class PlaywrightFactory {

    ThreadLocal<Page>  threadLocal = new ThreadLocal<>();

}
