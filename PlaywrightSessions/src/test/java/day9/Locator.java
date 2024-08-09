package day9;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Locator {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions headless=  new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome");
		Page page= playwright.chromium().launch(headless).newPage();
			page.navigate("https://www.amazon.in/b?ie=UTF8&node=14030937031");
			page.getByPlaceholder("Search Amazon.in").type("Atomic habits");
			page.getByRole(AriaRole.OPTION).first().click();
			page.getByAltText("data-image-source-density=\"1\"").click();
		

	}

}
