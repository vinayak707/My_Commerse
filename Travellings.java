package MakeMyTrip;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Travellings {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
		
		driver.findElement(By.xpath("//p[@class='textCenter appendBottom5 appendTop20 font12 blackText lineHeight18']//a[contains(text(),'Privacy Policy')]")).click();
		driver.navigate().back();
WebElement fromPlace = driver.findElement(By.xpath("//label[@for='fromCity']"));
fromPlace.click();
		WebElement selectableValue = driver.findElement(By.xpath("//p[contains(text(),'Bengaluru, India')]"));
		selectableValue.click();
		
		//To place selecting
		driver.findElement(By.id("toCity")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
		
		//To select current from calendar widget
		driver.findElement(By.xpath("//div[@class=\"DayPicker-Day DayPicker-Day--selected\"]")).click();
		
		driver.findElement(By.xpath("//span[@class=\"lbl_input appendBottom5\"]")).click();
		
		driver.findElement(By.xpath("//button[@class=\"primaryBtn btnApply pushRight\"]")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.findElement(By.xpath("//button[contains(.,'OKAY')]")).click();
		WebElement cheapestFlight = driver.findElement(By.xpath("//div[@class=\"clusterTabHeadList makeFlex active\"]"));
		
		
		String cheapFlightDetails = cheapestFlight.getText();
		

		
		
		
		List<WebElement> otherFlight = driver.findElements(By.xpath("//div[@class=\"clusterTabHeadList makeFlex \"]"));
		
		System.out.println("Cheapest Flight Details"+cheapFlightDetails );
	//	System.out.println("Other flight Details"+otherFlight);
		driver.close();
	}
}
