package sprint1;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class SAL011_3_DeleteOpportunity {
	public static void main(String[] args)  {
		//Launch the browser



		//Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//1.Login to https://login.salesforce.com/
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.id("Login")).click();

		//2.Click on toggle menu button from the left corner
		driver.findElement(By.className("slds-r5")).click();

		//3.Click view all and click sales from Application Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();//click on 'view all'
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");// type sales in search box
		driver.findElement(By.xpath("(//p[@class='slds-truncate']//mark)[3]")).click();// click on sales



		//4. Click on Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].scrollIntoView();",opportunities);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",opportunities);

		//5.Search the Opportunity 'Salesforce Automation by Your Name'
		driver.findElement(By.name("Opportunity-search-input")).sendKeys("Salesforce Automation by Your Selvi");

		//6.Click on  the Dropdown icon 
		driver.findElement(By.xpath("//a[@title='Show 3 more actions']")).click();

		//7. Select Delete.
		driver.findElement(By.xpath("//a[@title='Delete']")).click();


		//8.Verify Whether Opportunity is Deleted using Opportunity Name.Expected Result: Opportunity is Successfully deleted   
		WebElement deletionMessage = driver.findElement(By.xpath("//span[text()='Opportunity deleted.']"));
		if (deletionMessage.isDisplayed()) {
			System.out.println("Opportunity is Successfully deleted");
		} else {
			System.out.println("Opportunity deletion failed");
		}

		// 9.Close the browser
		driver.quit();
	}

}
