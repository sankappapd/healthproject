package Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Healthcare_Medicaid;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase11_Medicaid {
	private WebDriver driver;
	private Healthcare_Medicaid healthcare_Medicaid;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://katalon-demo-cura.herokuapp.com/"); // Replace with your login page URL
		healthcare_Medicaid = new Healthcare_Medicaid(driver); // Corrected initialization
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void appointment() {
		healthcare_Medicaid.clickappointment();
	}

	@Test(priority = 2, dependsOnMethods = "appointment")
	public void logindetails() {
		healthcare_Medicaid.usernamelogin("John Doe");
		healthcare_Medicaid.passwordenter("ThisIsNotAPassword");
		healthcare_Medicaid.clickloginbutton();
	}

	@Test(priority = 3, dependsOnMethods = "logindetails")
	public void verifyappointmentword() {
		healthcare_Medicaid.verifyappointment();
	}

	@Test(priority = 4, dependsOnMethods = "verifyappointmentword")
	public void seouldropdown() {
		healthcare_Medicaid.dropdown();
	}

	@Test(priority = 5, dependsOnMethods = "seouldropdown")
	public void checkboxclick() {
		healthcare_Medicaid.checkbox();
	}

	@Test(priority = 6, dependsOnMethods = "checkboxclick")
	public void mediacdselect() {
		healthcare_Medicaid.mediacidcheckbox();
	}

	@Test(priority = 7, dependsOnMethods = "mediacdselect")
	public void selectvisitdate() {
		healthcare_Medicaid.visitdate();
	}

	@Test(priority = 8, dependsOnMethods = "selectvisitdate")
	public void comments() {
		healthcare_Medicaid.commentpass("Sir i need urgent appointment");
	}

	@Test(priority = 9, dependsOnMethods = "comments")
	public void bookappointment() {
		healthcare_Medicaid.clickbookappointments();
	}

	@Test(priority = 10, dependsOnMethods = "bookappointment")
	public void bookappointmentverify() {
		healthcare_Medicaid.verifybookappointment();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
