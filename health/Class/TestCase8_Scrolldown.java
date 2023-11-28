package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Scrooldown;
import PageObject.Seoulhealthcare;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase8_Scrolldown {
	private WebDriver driver;
	private Scrooldown scrooldown;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		scrooldown = new Scrooldown(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void downscore() {
		scrooldown.scrollToBottom();
	}
}
