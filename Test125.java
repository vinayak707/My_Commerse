package cheetah;

import java.time.Duration;
import java.util.List;

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

public class Test125 {
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
	        
	        
	        WebElement searchLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"openSearchPage(); return false;\"]")));
            searchLink.click();
            
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search-item']")));
            searchInput.sendKeys("Pigmentation Corrector Serum (25ml)");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='search-item-submit-btn']")));
            searchButton.click();
            
            WebElement detectLocationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Detect current location']")));
            detectLocationButton.click();
            
            RemoteWebDriver js=(RemoteWebDriver)driver;
            js.executeScript("window.scrollTo(0,200);");
            
            
            String itemTitle = driver.findElement(By.xpath("//div[@class=\"product-title\"][1]")).getText();
            System.out.println(itemTitle);
            
            String itemPrice=driver.findElement(By.xpath("//div[@class=\"product-text\"][1]/div[3]/div[1]")).getText();
            System.out.println(itemPrice);
            
             List<WebElement> StockinItems = driver.findElements(By.xpath("//a[text()='+ Add'][1]"));
             int TotalavailableItems = StockinItems.size();
             System.out.println(" Total available Items    ="+TotalavailableItems);
          
             WebElement element = driver.findElement(By.xpath("//div[contains(@class,'item_add_btn-1047071')]//a[contains(text(),'+ Add')]"));
             JavascriptExecutor executor = (JavascriptExecutor) driver;
             executor.executeScript("arguments[0].click();", element);
             Thread.sleep(2000);
             
          WebElement cartButton = driver.findElement(By.xpath("//a[text()='Cart(']"));
          executor.executeScript("arguments[0].click();", cartButton);
          
          Thread.sleep(2000);
          String cart_item_name = driver.findElement(By.id("cart-item-name")).getText();
          
          
          String cart_item_price = driver.findElement(By.xpath("//span[@class=\"price_item_quant fw-400 font-18\"]")).getText();
         
          
         if( cart_item_price.contains(itemPrice)) {
        	 System.out.println("Item price is same in cart");
         }
         else {
        	 System.out.println("Item price is not same in cart");
         }
         if(itemTitle.contains(cart_item_name)) {
        	 System.out.println("same item is add to cart");
         }else {
        	 System.out.println("in cart item name is change");
         }
         
        WebElement price_Details = driver.findElement(By.xpath("//div[@class='card-body p-3']"));
        if(price_Details.isDisplayed()) {
        	 System.out.println("Price Details are showing in cart page");
        }else {
        	 System.out.println("Price details are not showing in cart page");
        }
        
        WebElement cart_item_details = driver.findElement(By.xpath("//div[@class='cartitem position-relative d-flex flex-row align-items-center w-100 ']"));
           if(cart_item_details.isDisplayed()) {
        	   System.out.println("Item Details are showing in cart page");
           }else {
        	   System.out.println("Item Details are not showing in cart page");
           }
           driver.quit();

         
	}
	
	

}
