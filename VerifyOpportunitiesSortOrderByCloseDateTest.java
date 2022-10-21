package seleniumLearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyOpportunitiesSortOrderByCloseDateTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
//				driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("mosu@win.com");
		driver.findElement(By.id("password")).sendKeys("mosu@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='0Qk5g0000079gY0CAI']")).click();
		WebElement we = driver.findElement(By.xpath("//span[@title='Close Date']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i=0;i<2; i++)
		{
			jse.executeScript("arguments[0].click()", we);
			Thread.sleep(6000);
		}  

		String SortingOrderCheck = driver.findElement(By.xpath("//span[text()='Sorted Ascending']")).getText();
		SortingOrderCheck.equals("Sorted Ascending");
		System.out.println("Opportunities displayed in ascending order by Close date");
		driver.quit();	
	}

}
