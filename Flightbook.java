package Motique;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flightbook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.easemytrip.com/");
		
		driver.findElement(By.id("rtrip")).click();
		driver.findElement(By.id("chkStudent"));
		driver.findElement(By.id("ddate")).click();
		
		driver.findElement(By.className("active-date")).click();
		
		driver.findElement(By.id("rdate")).click();
		
//		while(!driver.findElement(By.xpath("//div[@class=\"month2\"]")).getText().contains("Sep 2023")){
//			driver.findElement(By.id("img2Nex")).click();
//		}
		
	List<WebElement> date = driver.findElements(By.xpath("//li[@style=\"visibility:show\"]"));
	int count=date.size();
	for(int i=0;i<count;i++) {
    String text=date.get(i).getText();
    if(text.equalsIgnoreCase("4")) {
    	date.get(i).click();
    	break;
    }
			
	}
		

	}

}
