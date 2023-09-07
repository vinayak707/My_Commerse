package Motique;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

		class Test1 {

			public static void main(String args[])
			{
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();

				// Maximize the browser
				driver.manage().window().maximize();

				// Launch Website
				driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
				//RemoteWebDriver Js=(RemoteWebDriver)driver;
				JavascriptExecutor Js = (JavascriptExecutor) driver;
				Js.executeScript("window.scrollBy(0,3500)", "");
				
				driver.findElement(By.id("first_date_picker")).click();
				while(!driver.findElement(By.className("ui-datepicker-month")).getText().contains("September")) {
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					
				}
				List<WebElement> date = driver.findElements(By.className("ui-state-default"));
				int count=date.size();
				System.out.println(count);
				
				for(int i=0;i<count;i++) {
					String Text=driver.findElements(By.className("ui-state-default")).get(i).getText();
					if(Text.equalsIgnoreCase("4")) {
						driver.findElements(By.className("ui-state-default")).get(i).click();
						break;
					}
				}
			}
		}

		

	
