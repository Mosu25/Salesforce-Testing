package seleniumLearning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditOpportunityTest {

	public static void main(String[] args) {
		
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("disable-notifications");
			WebDriver driver = new ChromeDriver(opt);
//			driver.manage().window().maximize();
			driver.get("https://login.salesforce.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.findElement(By.id("username")).sendKeys("mosu@win.com");
			driver.findElement(By.id("password")).sendKeys("mosu@123");
			driver.findElement(By.id("Login")).click();
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[@class='slds-button']")).click();
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='0Qk5g0000079gY0CAI']")).click();
			driver.findElement(By.xpath("//input[@type='search'][@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Kalpana",Keys.ENTER);
			driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']")).click();
			WebElement ele = driver.findElement(By.xpath("(//div[@class='branding-actions actionMenu']//ul/li/a/div)[1]"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow = calendar.getTime();
			String date = dateFormat.format(tomorrow);
			driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
			driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(date);
			driver.findElement(By.xpath("//button[@aria-label='Stage, Needs Analysis']")).click();
			List<WebElement> Dropdown_List = driver.findElements(By.xpath("(//span[@class='slds-media__body']//span)"));
			
			for (WebElement  StageOptionDropdownList : Dropdown_List) {
				String StageOptionDropdownListText = StageOptionDropdownList.getText();
				if(StageOptionDropdownListText.equals("Perception Analysis"))
				{
					StageOptionDropdownList.click();
					break;
				}
			}

			WebElement ele1 = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status, --None--']"));
			jse.executeScript("arguments[0].click()", ele1);
			List<WebElement> DSDDL = driver.findElements(By.xpath("(//span[@class='slds-media__body']//span)"));
			for (WebElement  DSDDLS : DSDDL) {
				String DSDDLT = DSDDLS.getText();
				if(DSDDLT.equals("In progress"))
				{
					DSDDLS.click();
					break;
				}
			}
					
			driver.findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys("SalesForce");
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			driver.quit();

	}

}
