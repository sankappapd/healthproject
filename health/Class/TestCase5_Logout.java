package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Logout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5_Logout {
	private WebDriver driver;
	private Logout logout;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		logout = new Logout(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void appointment() {
		logout.clickappointment();
	}

	@Test(priority = 2, dependsOnMethods = "appointment")
	public void logindetails() {
		logout.usernamelogin("John Doe");
		logout.passwordenter("ThisIsNotAPassword");
		logout.clickloginbutton();
	}

	@Test(priority = 3, dependsOnMethods = "logindetails")
	public void verifyappointmentword() {
		logout.verifyappointment();
	}

	@Test(priority = 4, dependsOnMethods = "verifyappointmentword")
	public void checkboxclick() {
		logout.checkbox();
	}

	@Test(priority = 5, dependsOnMethods = "checkboxclick")
	public void selectvisitdate() {
		logout.visitdate();
	}

	@Test(priority = 6, dependsOnMethods = "selectvisitdate")
	public void comments() {
		logout.commentpass("Sir i need urgent appointment");
	}

	@Test(priority = 7, dependsOnMethods = "comments")
	public void bookappointment() {
		logout.clickbookappointments();
	}

	@Test(priority = 8, dependsOnMethods = "bookappointment")
	public void bookappointmentverify() {
		logout.verifybookappointment();
	}

	@Test(priority = 9, dependsOnMethods = "bookappointmentverify")
	public void viewverify_Profile() {
		logout.dahboard();

	}

	@Test(priority = 10, dependsOnMethods = "viewverify_Profile")
	public void logoutuser() {
		logout.logoutclick();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
