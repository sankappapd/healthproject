package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Verify_Profile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_Verify_Profile {
	private WebDriver driver;
	private Verify_Profile verify_Profile;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		verify_Profile = new Verify_Profile(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void appointment() {
		verify_Profile.clickappointment();
	}

	@Test(priority = 2, dependsOnMethods = "appointment")
	public void logindetails() {
		verify_Profile.usernamelogin("John Doe");
		verify_Profile.passwordenter("ThisIsNotAPassword");
		verify_Profile.clickloginbutton();
	}

	@Test(priority = 3, dependsOnMethods = "logindetails")
	public void verifyappointmentword() {
		verify_Profile.verifyappointment();
	}

	@Test(priority = 4, dependsOnMethods = "verifyappointmentword")
	public void checkboxclick() {
		verify_Profile.checkbox();
	}

	@Test(priority = 5, dependsOnMethods = "checkboxclick")
	public void selectvisitdate() {
		verify_Profile.visitdate();
	}

	@Test(priority = 6, dependsOnMethods = "selectvisitdate")
	public void comments() {
		verify_Profile.commentpass("Sir i need urgent appointment");
	}

	@Test(priority = 7, dependsOnMethods = "comments")
	public void bookappointment() {
		verify_Profile.clickbookappointments();
	}

	@Test(priority = 8, dependsOnMethods = "bookappointment")
	public void bookappointmentverify() {
		verify_Profile.verifybookappointment();
	}

	@Test(priority = 9, dependsOnMethods = "bookappointmentverify")
	public void viewverify_Profile() {
		verify_Profile.dahboard();
		verify_Profile.profileclick();

	}

	@Test(priority = 10, dependsOnMethods = "viewverify_Profile")
	public void viewverify_Profile_UNDERCONSTRUCTION() {
		verify_Profile.verifyunderconstruction();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
