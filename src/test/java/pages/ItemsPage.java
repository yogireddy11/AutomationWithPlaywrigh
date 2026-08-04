package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import static org.testng.Assert.*;


public class ItemsPage {

    private final Page page;
    private final Locator sneakerItem;
    private final Locator cartCount;
    private final Locator itemsInCheckOut;
    private final Locator totalAmount;
    private final Locator checkOutBtn;
    private final Locator searchBar;
    private final Locator itemList;


    public ItemsPage(Page page) {
        this.page = page;
        sneakerItem = page.locator("//button[@onclick=\"addToCart(3);event.stopImmediatePropagation()\"]");
        cartCount = page.locator("#cart-count");
        itemsInCheckOut = page.locator("//div[@class=\"flex justify-between items-center\"]");
        totalAmount = page.locator("//div[@class=\"flex justify-between text-lg font-semibold\"]");
        checkOutBtn = page.locator("button[onclick=\"checkout()\"]");
        searchBar = page.locator("#search-input");
        itemList = page.locator("//div[@class=\"product-card bg-white border rounded-3xl overflow-hidden\"]/div/h4");
    }

    public void checkOutItem() {
        sneakerItem.click();
        assertThat(cartCount).hasCount(1);
        cartCount.click();
        System.out.print(itemsInCheckOut.textContent());
        System.out.println(totalAmount.textContent());
        page.onceDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept();
        });
        checkOutBtn.click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Checkout.png")));
    }

    public void searchItem(String item) {

        searchBar.fill(item);
        page.keyboard().press("Enter");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("SearchFilter.png")));
        for (int i = 0; i < itemList.count(); i++) {
            Locator product = itemList.nth(i);
            System.out.println(product.textContent());
        }
    }


}
