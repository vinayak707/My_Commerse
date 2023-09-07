package Motique;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("window.scrollBy(0,3500)", "");
		//driver.findElement(By.id("second_date_picker")).click();
		driver.findElement(By.id("first_date_picker")).click();
		while(!driver.findElement(By.className("ui-datepicker-month")).getText().contains("March")) {
			driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
			
		}
		List<WebElement> date = driver.findElements(By.className("ui-state-default"));
		
		//long Total_days = date.stream().count();
		int Today_days=date.size();
		System.out.println(Today_days);
		
		for(int i=0;i<Today_days;i++) {
			String actualDate = date.get(i).getText();
			if(actualDate.equalsIgnoreCase("7")) {
				driver.findElements(By.className("ui-state-default")).get(i).click();
				break;
				
			}
		}
		
		//calender 3
		driver.findElement(By.id("third_date_picker")).click();
		WebElement months = driver.findElement(By.className("ui-datepicker-month"));
		
		
		months.click();
		Select sc=new Select(months);
		sc.selectByIndex(3);
		
		WebElement years = driver.findElement(By.className("ui-datepicker-year"));
		years.click();
		Select scyear=new Select(years);
		scyear.selectByIndex(11);
		
		List<WebElement> days2024 = driver.findElements(By.xpath("//td[@data-handler=\"selectDay\"]"));
		int count1=days2024.size();
		System.out.println(count1);
		
		for(int i=0;i<count1;i++) {
			String dayText = days2024.get(i).getText();
			if(dayText.equalsIgnoreCase("20")) {
				days2024.get(i).click();
			}
		}
		
		
		
//calender 5
		driver.findElement(By.id("fifth_date_picker")).click();
		List<WebElement> disabled_days = driver.findElements(By.xpath("//td[@class=\" ui-datepicker-unselectable ui-state-disabled \"]"));

		int dcount=disabled_days.size();
		System.out.println("disabled days"+dcount);
		
		
	}

}
