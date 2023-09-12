package cheetah;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login2 {
	@Test

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.get("https://theskinstory.test.bitsila.com/");
        driver.findElement(By.xpath("//span[@class=\"fw-400 font-30\"]")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.name("mobile-number")).sendKeys("7457894578");
        driver.findElement(By.xpath("//button[@onclick=\"userLogin2();\"][1]")).click();
        
        WebElement otp_verify_button = driver.findElement(By.xpath("//div[@class='otp-verfication-div']//button[@class='btn btn-block primary-bg-color white-color fw-600 login-submit mt-4 w-100'][normalize-space()='Verify']"));
        Thread.sleep(15000);
        otp_verify_button.click();
       
        WebElement detectLocationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Detect current location']")));
        detectLocationButton.click();
      
        Thread.sleep(5000);

        RemoteWebDriver js=(RemoteWebDriver)driver;
        js.executeScript("window.scrollTo(0,900);");
        
        WebElement add_cart = driver.findElement(By.xpath("//section[@class='item_for_shopping d1 fadein fixed-frame-design visible']//div[@class='row']//div[2]//div[1]//div[2]//div[1]//div[3]//div[2]//div[1]//a[1]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", add_cart);
        Thread.sleep(4000);
        WebElement cartButton = driver.findElement(By.xpath("//a[text()='Cart(']"));
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", cartButton);
        
        Thread.sleep(5000);
        //WebElement detectLocationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Detect current location']")));
       // detectLocationButton.click();
        WebElement home_delivery_button = driver.findElement(By.id("home-delivery-btn"));
        home_delivery_button.click();
        
       WebElement third_loc = driver.findElement(By.xpath("//div[@id=\"address_list\"][3]"));
       third_loc.click();
       
      // js.executeScript("window.scrollTo(0,1000);");
       WebElement time_slot = driver.findElement(By.xpath("//div[@id=\"timepickup\"][1]"));
       executor.executeScript("arguments[0].click();", time_slot);
      
       
       Thread.sleep(5000);
       
      WebElement cod_radio = driver.findElement(By.id("cop-method"));
      executor.executeScript("arguments[0].click();", cod_radio);
      
      
     WebElement place_order = driver.findElement(By.id("place-order-method-active"));
     executor.executeScript("arguments[0].click();", place_order);
     
     WebElement Order_Id = driver.findElement(By.xpath("//div[@class=\"col-8\"]"));
    WebElement item_Description = driver.findElement(By.xpath("//div[@class=\"item-description\"]"));
     
     if(Order_Id.isDisplayed()) {
    	 System.out.println("TestCase passed, Order successfully Placed");
    	 System.out.println("Order id = "+Order_Id.getText());
    	 System.out.println("Ordered Item Description  = "+item_Description.getText());
    	 
     }
     driver.quit();
     
       
     
  
	}

	}


