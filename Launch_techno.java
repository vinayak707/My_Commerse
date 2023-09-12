package Technosport;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Swaglabs.Run;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_techno {
	@Test
	public void AestGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
//			WebDriver driver=new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					ChromeDriver driver = new ChromeDriver(options);
					//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			driver.get("https://www.technosport.in");
			Actions action=new Actions(driver);
			WebElement mens = driver.findElement(By.xpath("//li[@id=\"nav_20912\"]"));
			
			action.moveToElement(mens);
			action.click().perform();
			Thread.sleep(3000);
			//driver.quit();
			
			//click on categories
			
			driver.findElement(By.xpath("//h4[contains(.,'Topwear')]")).click();
			
			WebElement small_size = driver.findElement(By.xpath("//label[@for=\"S\"]"));
			small_size.click();
			Thread.sleep(3000);
			
			JavascriptExecutor Js=(JavascriptExecutor)driver;
			Js.executeScript("window.scrollTo(0,5000);");
			Thread.sleep(3000);
			Js.executeScript("document.getElementsByName(\"Category\")[0].click()");
			
			Thread.sleep(3000);
			Js.executeScript("document.getElementById(\"T-shirt\").click();");
			
			Js.executeScript("window.scrollBy(0,1000);");
			
			Thread.sleep(3000);
			Js.executeScript("document.getElementById(\"Crew Neck\").click();");
			
			Thread.sleep(3000);
			Js.executeScript("document.getElementsByName(\"Colour\")[0].click();");
			
			Thread.sleep(3000);
			WebElement Gym_wear = driver.findElement(By.xpath("//label[@for=\"Gym Wear\"]"));
			Thread.sleep(3000);
			Gym_wear.click();
			
			
			driver.quit();
			
			
			
					
	}

}
