package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnIO {
public static void main(String[] args) {
	
	Playwright playwright= Playwright.create();
	Browser browser= playwright.chromium().launch
			(new BrowserType.LaunchOptions().setHeadless(false));
	
	Page page= browser.newPage();
	page.navigate("https://letcode.in/edit");
	page.locator("//*[@id=\"fullName\"]").type("Cbum");
	
	Locator locator= page.locator("//*[@id=\"join\"]");
	locator.press("End");
	locator.type(" Man");
	locator.press("Tab");
	//page.type("//*[@id=\\\"fullName\\\"]", "John");
	
		String value= page.locator("id=getMe").getAttribute("value");
		System.out.println(value);
		
		page.locator("//*[@id=\"clearMe\"]").clear();
	
}
}
