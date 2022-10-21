/*
*
* @author: Mohanasundaram M
* @purpose: Create the New Opportunity
* @copyright: none
*
*/


package seleniumLearning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateNewOpportunityTest {

	public static void main(String[] args) {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
//		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("mosu@win.com");
		driver.findElement(By.id("password")).sendKeys("mosu@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='0Qk5g0000079gY0CAI']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Kalpana1");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		String date = dateFormat.format(today);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(date);
		driver.findElement(By.xpath("//button[@aria-label='Stage, --None--']")).click();
		List<WebElement> Dropdown_List = driver.findElements(By.xpath("(//span[@class='slds-media__body']//span)"));
		for (WebElement StageOptionDropdownList : Dropdown_List) {
			String StageOptionDropdownListText = StageOptionDropdownList.getText();
			if(StageOptionDropdownListText.equals("Needs Analysis"))
			{
				StageOptionDropdownList.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.quit();

	}

}
