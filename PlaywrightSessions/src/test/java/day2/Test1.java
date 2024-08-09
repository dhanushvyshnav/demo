package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test1 {

	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		Browser browser= playwright.chromium().launch
				(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page= browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		page.click("//*[@id=\"user-message\"]");
		page.type("//*[@id=\"user-message\"]", "Hello ES...!");
		page.click("//*[@id=\"showInput\"]");
		
		String value=  page.locator("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div[2]/div/div[2]").getAttribute("Your Message: ");
		System.out.println(value);
		
	}

}
