package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Verify_Homepage {
	private WebDriver driver;
	WebDriverWait wait;

	public Verify_Homepage(WebDriver driver) {
		this.driver = driver;
	}

	private By verifyhomepage = By.xpath("(//*[contains(text(),'CURA Healthcare Service')])[1]");

	public boolean ishealthhomevisible() {
		return driver.findElement(verifyhomepage).isDisplayed();
	}

	public void verifyhealthhomepagevisible() {
		Assert.assertTrue(ishealthhomevisible(), "CURA Healthcare Service not visible");

	}

}
