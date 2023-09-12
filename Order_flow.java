package cheetah;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Order_flow {
	@Test

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://theskinstory.test.bitsila.com/");
		driver.findElement(By.xpath("//span[@class=\"fw-400 font-30\"]")).click();
		WebElement catagories = driver.findElement(By.xpath("//a[@class='mobile-hide']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(catagories).perform();

		WebElement cat1 = driver.findElement(By.xpath("//a[normalize-space()='SHOP BY CONCERN(20)']"));
		ac.moveToElement(cat1).perform();

		driver.findElement(By.xpath("//a[normalize-space()='Pigmantaions and Blemishes(5)']")).click();

		driver.findElement(By.xpath("//button[@class='btn btn-block primary-bg-color white-color fw-600']")).click();

		List<WebElement> catItems = driver.findElements(By.xpath("//div[@class=\"col-md-3 category_card p2\"]"));
		int cat1Item_Count = catItems.size();

		System.out.println("Pigmantaions And Blemishes items count  =" + cat1Item_Count);

		for (int i = 0; i < cat1Item_Count; i++) {
			String cat1Items = catItems.get(i).getText();
			System.out.println("Pigmantaions And Blemishes Names  =" + cat1Items);
		}
		driver.quit();

	}

	@Test
	public void Cart() throws InterruptedException {
		// span[normalize-space()='SKIN CARE & BODY CARE (2)']
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://theskinstory.test.bitsila.com/");
		driver.findElement(By.xpath("//span[@class=\"fw-400 font-30\"]")).click();

		WebElement searchLink = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"openSearchPage(); return false;\"]")));
		searchLink.click();

		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search-item']")));
		searchInput.sendKeys("Pigmentation Corrector Serum (25ml)");

		WebElement searchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='search-item-submit-btn']")));
		searchButton.click();

		WebElement detectLocationButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Detect current location']")));
		detectLocationButton.click();

		RemoteWebDriver js = (RemoteWebDriver) driver;
		js.executeScript("window.scrollTo(0,200);");

		String itemTitle = driver.findElement(By.xpath("//div[@class=\"product-title\"][1]")).getText();
		System.out.println(itemTitle);

		String itemPrice = driver.findElement(By.xpath("//div[@class=\"product-text\"][1]/div[3]/div[1]")).getText();
		System.out.println(itemPrice);

		List<WebElement> StockinItems = driver.findElements(By.xpath("//a[text()='+ Add'][1]"));
		int TotalavailableItems = StockinItems.size();
		System.out.println(" Total available Items    =" + TotalavailableItems);

		WebElement element = driver
				.findElement(By.xpath("//div[contains(@class,'item_add_btn-1047071')]//a[contains(text(),'+ Add')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

		WebElement cartButton = driver.findElement(By.xpath("//a[text()='Cart(']"));
		executor.executeScript("arguments[0].click();", cartButton);

		Thread.sleep(2000);
		String cart_item_name = driver.findElement(By.id("cart-item-name")).getText();

		String cart_item_price = driver.findElement(By.xpath("//span[@class=\"price_item_quant fw-400 font-18\"]"))
				.getText();

		if (cart_item_price.contains(itemPrice)) {
			System.out.println("Item price is same in cart");
		} else {
			System.out.println("Item price is not same in cart");
		}
		if (itemTitle.contains(cart_item_name)) {
			System.out.println("same item is add to cart");
		} else {
			System.out.println("in cart item name is change");
		}

		WebElement price_Details = driver.findElement(By.xpath("//div[@class='card-body p-3']"));
		if (price_Details.isDisplayed()) {
			System.out.println("Price Details are showing in cart page");
		} else {
			System.out.println("Price details are not showing in cart page");
		}

		WebElement cart_item_details = driver.findElement(
				By.xpath("//div[@class='cartitem position-relative d-flex flex-row align-items-center w-100 ']"));
		if (cart_item_details.isDisplayed()) {
			System.out.println("Item Details are showing in cart page");
		} else {
			System.out.println("Item Details are not showing in cart page");
		}
		driver.quit();

	}

	@Test
	public static void Order_flow() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://theskinstory.test.bitsila.com/");
		driver.findElement(By.xpath("//span[@class=\"fw-400 font-30\"]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("mobile-number")).sendKeys("7457894578");
		driver.findElement(By.xpath("//button[@onclick=\"userLogin2();\"][1]")).click();

		WebElement otp_verify_button = driver.findElement(By.xpath(
				"//div[@class='otp-verfication-div']//button[@class='btn btn-block primary-bg-color white-color fw-600 login-submit mt-4 w-100'][normalize-space()='Verify']"));
		Thread.sleep(15000);
		otp_verify_button.click();

		WebElement detectLocationButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Detect current location']")));
		detectLocationButton.click();

		Thread.sleep(5000);

		RemoteWebDriver js = (RemoteWebDriver) driver;
		js.executeScript("window.scrollTo(0,900);");

		WebElement add_cart = driver.findElement(By.xpath(
				"//section[@class='item_for_shopping d1 fadein fixed-frame-design visible']//div[@class='row']//div[2]//div[1]//div[2]//div[1]//div[3]//div[2]//div[1]//a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add_cart);
		Thread.sleep(4000);
		WebElement cartButton = driver.findElement(By.xpath("//a[text()='Cart(']"));
		// JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", cartButton);

		Thread.sleep(5000);
		// WebElement detectLocationButton =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Detect
		// current location']")));
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

		if (Order_Id.isDisplayed()) {
			System.out.println("TestCase passed, Order successfully Placed");
			System.out.println("Order id = " + Order_Id.getText());
			System.out.println("Ordered Item Description  = " + item_Description.getText());

		}
		driver.quit();

	}

}
