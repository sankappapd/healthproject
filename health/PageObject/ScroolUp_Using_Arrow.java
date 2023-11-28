package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScroolUp_Using_Arrow {
	private WebDriver driver;
	WebDriverWait wait;

	private By scroolarrow = By.xpath("//a[@id='to-top']");

	public ScroolUp_Using_Arrow(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollToBottom() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public void scroolup() {
		WebElement clickarrow = driver.findElement(scroolarrow);
		clickarrow.click();
	}

}
