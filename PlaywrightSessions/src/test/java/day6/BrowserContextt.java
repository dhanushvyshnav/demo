package day6;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextt {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch();
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://bookcart.azurewebsites.net/login");
		page.locator("//*[@id=\"mat-mdc-form-field-label-0\"]/mat-label").type("John");
		page.locator("//*[@id=\"mat-mdc-form-field-label-2\"]/mat-label").type("john1234$");
		page. locator ("//form[@id='loginForm']/button[text()='Login']") .click();
	}
}
