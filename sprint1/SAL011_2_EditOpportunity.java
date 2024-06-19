package sprint1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SAL011_2_EditOpportunity {
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
		
		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.className("slds-r5")).click();
		
		//3. Click View All and click Sales from the Application Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();//click on 'view all'
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");// type sales in search box
		driver.findElement(By.xpath("(//p[@class='slds-truncate']//mark)[3]")).click();// click on sales
		
		
		//4. click on Opportunity
			WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));

	        driver.executeScript("arguments[0].scrollIntoView();",opportunities);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();",opportunities);
	        
	      //5.Search the Opportunity 'Salesforce Automation by Your Name
	        
	        
	        //6. Click on the Dropdown icon and Select Edit
	        
	        
	        
	        //7.Choose close date as Tomorrow date
	        
	        
	        //8. Select 'Stage' as Perception Analysis
	        
	        
	        //9 Select Deliver Status as In Progress
	        
	        //10.Enter Description as SalesForce
	        
	        //11.Click on Save
	        
	        
	        
		
		 //12.Verify Stage as Perception Analysis Expected Result:The Oppurtunity is Edited Successfully  
		
	       // 13.Close the browser
	        driver.quit();
	}

}
