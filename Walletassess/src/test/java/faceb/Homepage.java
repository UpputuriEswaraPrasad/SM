package faceb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Login {
	@FindBy(xpath = "//div[@class='m9osqain a5q79mjw jm1wdb64 k4urcfbm']")
	WebElement posting;
	

	public void HomePage() {

		posting.click();
		System.out.println("clicked on posting status");
		WebElement post = driver.findElement(By.xpath("//div[@class='rq0escxv buofh1pr df2bnetk hv4rvrfc dati1w0a l9j0dhe7 k4urcfbm du4w35lb gbhij3x4']"));
		post.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// executor.executeScript("arguments[0].click();", nam);
		executor.executeScript("arguments[0].value = '';", post);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		post.sendKeys("hello word");
	}
}
