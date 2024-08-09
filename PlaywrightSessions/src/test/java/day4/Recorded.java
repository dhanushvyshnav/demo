package day4;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
public class Recorded {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://letcode.in/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign up")).click();
			page.getByPlaceholder("Enter your name").click();
			page.getByPlaceholder("Enter your name")
			.fill("Dhanush");
			page.getByPlaceholder("Enter valid email address").click();
			page.getByPlaceholder("Enter valid email address")
			.fill("dhanu1234@gmail.com");
			page.getByPlaceholder("Enter your password").click();
			page.getByPlaceholder("Enter your password")
			.fill("Dhan112234");
			page.getByLabel("I agree to the terms and").check();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN UP")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign out")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work-Space")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Drop-Down")).click();
			page.locator("#fruits").selectOption("2");
			page.locator("#superheros").selectOption("ds");
			page.locator(".card-content").first().click();
			page.locator("#lang").selectOption("java");
			page.locator("#country").selectOption("Paraguay");
			page.locator("#country").selectOption("India");
		}
	}
