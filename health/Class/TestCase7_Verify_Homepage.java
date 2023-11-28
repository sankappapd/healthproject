package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Seoulhealthcare;
import PageObject.Verify_Homepage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase7_Verify_Homepage {
	private WebDriver driver;
	private Verify_Homepage verify_Homepage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		verify_Homepage = new Verify_Homepage(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test
	public void homepageverify() {
		verify_Homepage.verifyhealthhomepagevisible();
	}
}
