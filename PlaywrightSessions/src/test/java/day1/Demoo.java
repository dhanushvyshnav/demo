package day1;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demoo {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright= Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.
				LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page= browser.newPage();
		page.navigate("https://www.letcode.in/");
		Thread.sleep(8000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("letcode.png")).setFullPage(true));
		
		Thread.sleep(8000);
		String title= page.title();
		System.out.println("page title is : "+ title); 

		String url= page.url();
		System.out.println("url is : "+ url);
		page.close();
		browser.close();
		playwright.close();
	}
}
