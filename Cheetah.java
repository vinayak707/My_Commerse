package Motique;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cheetah {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://theskinstory.test.bitsila.com/");
		driver.findElement(By.xpath("//span[@class=\"fw-400 font-30\"]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("mobile-number")).sendKeys("7457894578");
		driver.findElement(By.xpath("//button[@onclick=\"userLogin2();\"][1]")).click();
		String otp = driver.findElement(By.xpath("//h6[@class=\"fw-600 mb-0\"][1]")).getText();
		System.out.println(otp);
		System.out.println("rrrrrrrrrrrrrrr");
		
		
		
		
		
		
		
		
		//driver.findElement(By.className("fw-400 font-30")).click();
		
	}

}
