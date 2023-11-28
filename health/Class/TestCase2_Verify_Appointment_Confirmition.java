package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Verify_Appointment_Confirmition;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2_Verify_Appointment_Confirmition {

	private WebDriver driver;
	private Verify_Appointment_Confirmition verify_Appointment_Confirmition;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		verify_Appointment_Confirmition = new Verify_Appointment_Confirmition(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void appointment() {
		verify_Appointment_Confirmition.clickappointment();
	}

	@Test(priority = 2, dependsOnMethods = "appointment")
	public void logindetails() {
		verify_Appointment_Confirmition.usernamelogin("John Doe");
		verify_Appointment_Confirmition.passwordenter("ThisIsNotAPassword");
		verify_Appointment_Confirmition.clickloginbutton();
	}

	@Test(priority = 3, dependsOnMethods = "logindetails")
	public void verifyappointmentword() {
		verify_Appointment_Confirmition.verifyappointment();
	}

	@Test(priority = 4, dependsOnMethods = "verifyappointmentword")
	public void checkboxclick() {
		verify_Appointment_Confirmition.checkbox();
	}

	@Test(priority = 5, dependsOnMethods = "checkboxclick")
	public void selectvisitdate() {
		verify_Appointment_Confirmition.visitdate();
	}

	@Test(priority = 6, dependsOnMethods = "selectvisitdate")
	public void comments() {
		verify_Appointment_Confirmition.commentpass("Sir i need urgent appointment");
	}

	@Test(priority = 7, dependsOnMethods = "comments")
	public void bookappointment() {
		verify_Appointment_Confirmition.clickbookappointments();
	}

	@Test(priority = 8, dependsOnMethods = "bookappointment")
	public void bookappointmentverify() {
		verify_Appointment_Confirmition.verifybookappointment();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
