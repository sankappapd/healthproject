package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Profile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCAse4_Profile {
	private WebDriver driver;
	private Profile profile;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		profile = new Profile(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void appointment() {
		profile.clickappointment();
	}

	@Test(priority = 2, dependsOnMethods = "appointment")
	public void logindetails() {
		profile.usernamelogin("John Doe");
		profile.passwordenter("ThisIsNotAPassword");
		profile.clickloginbutton();
	}

	@Test(priority = 3, dependsOnMethods = "logindetails")
	public void verifyappointmentword() {
		profile.verifyappointment();
	}

	@Test(priority = 4, dependsOnMethods = "verifyappointmentword")
	public void checkboxclick() {
		profile.checkbox();
	}

	@Test(priority = 5, dependsOnMethods = "checkboxclick")
	public void selectvisitdate() {
		profile.visitdate();
	}

	@Test(priority = 6, dependsOnMethods = "selectvisitdate")
	public void comments() {
		profile.commentpass("Sir i need urgent appointment");
	}

	@Test(priority = 7, dependsOnMethods = "comments")
	public void bookappointment() {
		profile.clickbookappointments();
	}

	@Test(priority = 8, dependsOnMethods = "bookappointment")
	public void bookappointmentverify() {
		profile.verifybookappointment();
	}

	@Test(priority = 9, dependsOnMethods = "bookappointmentverify")
	public void viewprofile() {
		profile.dahboard();
		profile.profileclick();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
