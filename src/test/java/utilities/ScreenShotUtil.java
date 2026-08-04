package utilities;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenShotUtil {

    public static String capture(Page page, String testName){
        String path = "Screenshot/"+testName+".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }

}
