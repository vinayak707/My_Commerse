package MakeMyTrip;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTrip {
public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.makemytrip.com/");

driver.findElement(By.cssSelector("a[href*='holidays-international']")).click();
String MainWindow=driver.getWindowHandle();

for(String winHandle : driver.getWindowHandles()){
driver.switchTo().window(winHandle);
}

driver.close();
// Switching to Parent window i.e Main Window.
driver.switchTo().window(MainWindow);

//driver.findElement(By.xpath("//[@placeholder='Type Departure City']")).sendKeys("New Delhi");
}
}