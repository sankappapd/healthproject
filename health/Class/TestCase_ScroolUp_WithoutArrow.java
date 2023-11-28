package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.ScroolUp_Using_Arrow;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_ScroolUp_WithoutArrow {
	private WebDriver driver;
	private ScroolUp_Using_Arrow scroolUp_Using_Arrow;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		scroolUp_Using_Arrow = new ScroolUp_Using_Arrow(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void downscore() {
		scroolUp_Using_Arrow.scrollToBottom();
	}

	@Test(priority = 2, dependsOnMethods = "downscore")
	public void scroolup() {
		scroolUp_Using_Arrow.scroolup();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
