package day8;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TraceViwer {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();

		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);

		BrowserContext context = browser.newContext();

		context.tracing().start(
				new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(false));

		Page page = context.newPage();

		// basic input field interaction
		page.navigate("https://letcode.in/edit");
		page.locator("#fullName").type("Dhanush");
		Locator locator = page.locator("#join");
		locator.press("End");
		locator.type(" man");
		locator.press("Tab");
		//page.type("#fullName", "Dhanush");
		String value = page.locator("id=getMe").getAttribute("value");
		System.out.println(value);
		page.locator("(//label[text()='Clear the text']/following::input)[1]").clear();

		page.navigate("https://www.aboutamazon.in/");
		
		context.tracing().stop(
				new Tracing.StopOptions()
				.setPath(Paths.get("trace.zip")));

		context.close();
		playwright.close();
	}
}
