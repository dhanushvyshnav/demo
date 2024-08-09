package day7;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
public class RecordVideo {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions()
					.setRecordVideoDir(Paths.get("videos/"))
					.setRecordVideoSize(1280, 720));
			Page page = context.newPage();
			page.navigate("https://www.aboutamazon.in/");
			Page page1 = page.waitForPopup(() -> {
				page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Subscribe")).click();
			});
			page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Return to About Amazon")).click();
			page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Who We Are")).nth(1).click();
			page1.getByRole(AriaRole.BANNER).getByRole(AriaRole.NAVIGATION).locator("li").filter(new Locator.FilterOptions().setHasText("Our Employees")).nth(3).click();
			page1.locator("li").filter(new Locator.FilterOptions().setHasText("I'm a VP at AWS. Here's why I")).getByRole(AriaRole.LINK).nth(2).click();
			page1.navigate("https://www.aboutamazon.in/workplace/employees");
			page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Improving Packaging")).click();
			page.close();
			context.close();
			browser.close();
			playwright.close();
		}
}
