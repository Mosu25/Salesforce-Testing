package seleniumLearning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateOpportunitywithoutmandatoryfieldsTest {

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
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		String date = dateFormat.format(tomorrow);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(date);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String NameAlertMsg = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[1]")).getText();
		String StageAlertMsg = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]")).getText();
		NameAlertMsg.equals("Complete this field");
		System.out.println("Name Alrert displayed UI and verified this text " + NameAlertMsg);
		StageAlertMsg.equals("Complete this field");
		System.out.println("Stage Alrert displayed UI and verified this text " + NameAlertMsg);
		driver.quit();

	}

}
