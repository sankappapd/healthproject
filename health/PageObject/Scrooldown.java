package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrooldown {
	private WebDriver driver;
	WebDriverWait wait;

	public Scrooldown(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollToBottom() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

}
