package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.Verify_Booking_History;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3_Verify_Booking_History {

	private WebDriver driver;
	private Verify_Booking_History verify_Booking_History;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		verify_Booking_History = new Verify_Booking_History(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void appointment() {
		verify_Booking_History.clickappointment();
	}

	@Test(priority = 2, dependsOnMethods = "appointment")
	public void logindetails() {
		verify_Booking_History.usernamelogin("John Doe");
		verify_Booking_History.passwordenter("ThisIsNotAPassword");
		verify_Booking_History.clickloginbutton();
	}

	@Test(priority = 3, dependsOnMethods = "logindetails")
	public void verifyappointmentword() {
		verify_Booking_History.verifyappointment();
	}

	@Test(priority = 4, dependsOnMethods = "verifyappointmentword")
	public void checkboxclick() {
		verify_Booking_History.checkbox();
	}

	@Test(priority = 5, dependsOnMethods = "checkboxclick")
	public void selectvisitdate() {
		verify_Booking_History.visitdate();
	}

	@Test(priority = 6, dependsOnMethods = "selectvisitdate")
	public void comments() {
		verify_Booking_History.commentpass("Sir i need urgent appointment");
	}

	@Test(priority = 7, dependsOnMethods = "comments")
	public void bookappointment() {
		verify_Booking_History.clickbookappointments();
	}

	@Test(priority = 8, dependsOnMethods = "bookappointment")
	public void bookappointmentverify() {
		verify_Booking_History.verifybookappointment();
	}

	@Test(priority = 9, dependsOnMethods = "bookappointmentverify")
	public void historydetails() {
		verify_Booking_History.dahboard();
		verify_Booking_History.historyclick();
	}

	@Test(priority = 10, dependsOnMethods = "historydetails")
	public void verifyfacilitiesvisible() {
		verify_Booking_History.verifyfacilityvisible();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
