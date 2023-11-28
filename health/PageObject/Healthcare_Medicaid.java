package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Healthcare_Medicaid {
	private WebDriver driver;
	WebDriverWait wait;

	public Healthcare_Medicaid(WebDriver driver) {
		this.driver = driver;
	}

	private By clickonmakeappointment = By.xpath("//a[@id='btn-make-appointment']");
	private By username = By.xpath("//input[@id='txt-username']");
	private By password = By.xpath("//input[@id='txt-password']");
	private By loginbutton = By.xpath("//button[@id='btn-login']");
	private By verifymakeappointment = By.xpath("//*[contains(text(),'Make Appointment')]");
	private By seoulhealthcare = By.xpath("//select[@id='combo_facility']");
	private By readmissioncheckbox = By.xpath("//input[@id='chk_hospotal_readmission']");
	private By medicaid = By.xpath("//label[normalize-space()='Medicaid']");
	private By date = By.xpath("//input[@id='txt_visit_date']");
	private By comment = By.xpath("//textarea[@id='txt_comment']");
	private By bookappoint = By.xpath("//button[@id='btn-book-appointment']");
	private By verifybookappointment = By.xpath("//*[contains(text(),'Appointment Confirmation')]");

	public void clickappointment() {
		WebElement click = driver.findElement(clickonmakeappointment);
		click.click();
	}

	public void usernamelogin(String usernames) {
		WebElement mail = driver.findElement(username);
		mail.sendKeys(usernames);
	}

	public void passwordenter(String pass) {
		WebElement passbutton = driver.findElement(password);
		passbutton.sendKeys(pass);
	}

	public void clickloginbutton() {
		WebElement clicklogins = driver.findElement(loginbutton);
		clicklogins.click();
	}

	public boolean ismakeappointmentvisible() {
		return driver.findElement(verifymakeappointment).isDisplayed();
	}

	public void verifyappointment() {
		Assert.assertTrue(ismakeappointmentvisible(), "MAKE APPOINTMENT NOT VISIBLE");
		driver.navigate().refresh();
	}

	public void dropdown() {
		WebElement configdropdown = driver.findElement(seoulhealthcare);
		Actions actions = new Actions(driver);
		actions.click(configdropdown).build().perform();
		WebElement optionToSelect = driver
				.findElement(By.xpath("//*[contains(text(),'Seoul CURA Healthcare Center')]"));
		optionToSelect.click();
	}

	public void checkbox() {
		WebElement clicklcheckbox = driver.findElement(readmissioncheckbox);
		clicklcheckbox.click();
	}

	public void mediacidcheckbox() {
		WebElement selectmedicad = driver.findElement(medicaid);
		selectmedicad.click();
	}

	public void visitdate() {
		WebElement selectdate = driver.findElement(date);
		selectdate.click();
		WebElement pickdate = driver.findElement(By.xpath("//td[@class='day'][normalize-space()='1']"));
		pickdate.click();

	}

	public void commentpass(String pass) {
		WebElement passcomment = driver.findElement(comment);
		passcomment.click();
		passcomment.sendKeys(pass);
	}

	public void clickbookappointments() {
		WebElement booking = driver.findElement(bookappoint);
		booking.click();
	}

	public void verifybokkapointment() {

	}

	public boolean isbookppointmentvisible() {
		return driver.findElement(verifybookappointment).isDisplayed();
	}

	public void verifybookappointment() {
		Assert.assertTrue(isbookppointmentvisible(), "APPOINTMENT CONFIRMITION NOT VISIBLE");

	}
}
