package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Seoulhealthcare;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase6_SeolHealthcare {
	private WebDriver driver;
	private Seoulhealthcare seoulhealthcare;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		seoulhealthcare = new Seoulhealthcare(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void appointment() {
		seoulhealthcare.clickappointment();
	}

	@Test(priority = 2, dependsOnMethods = "appointment")
	public void logindetails() {
		seoulhealthcare.usernamelogin("John Doe");
		seoulhealthcare.passwordenter("ThisIsNotAPassword");
		seoulhealthcare.clickloginbutton();
	}

	@Test(priority = 3, dependsOnMethods = "logindetails")
	public void verifyappointmentword() {
		seoulhealthcare.verifyappointment();
	}

	@Test(priority = 4, dependsOnMethods = "verifyappointmentword")
	public void seouldropdown() {
		seoulhealthcare.dropdown();
	}

	@Test(priority = 5, dependsOnMethods = "seouldropdown")
	public void checkboxclick() {
		seoulhealthcare.checkbox();
	}

	@Test(priority = 6, dependsOnMethods = "checkboxclick")
	public void selectvisitdate() {
		seoulhealthcare.visitdate();
	}

	@Test(priority = 7, dependsOnMethods = "selectvisitdate")
	public void comments() {
		seoulhealthcare.commentpass("Sir i need urgent appointment");
	}

	@Test(priority = 8, dependsOnMethods = "comments")
	public void bookappointment() {
		seoulhealthcare.clickbookappointments();
	}

	@Test(priority = 8, dependsOnMethods = "bookappointment")
	public void bookappointmentverify() {
		seoulhealthcare.verifybookappointment();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
