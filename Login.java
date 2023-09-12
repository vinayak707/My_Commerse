package cheetah;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://theskinstory.test.bitsila.com/");
        driver.findElement(By.xpath("//span[@class=\"fw-400 font-30\"]")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.name("mobile-number")).sendKeys("7457894578");
        driver.findElement(By.xpath("//button[@onclick=\"userLogin2();\"][1]")).click();
        
        // Use a WebDriverWait to wait for the OTP element to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement otpElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("otp-number1")));

        String otpSentence = otpElement.getText();

        String input = otpSentence;

        // Define a regular expression pattern to match a 6-digit OTP enclosed in parentheses
        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");

        // Create a Matcher to find the pattern in the input string
        Matcher matcher = pattern.matcher(input);

        // Check if the pattern is found
        String otpStr = "" ;
        if (matcher.find()) {
            // Extract the OTP from the matched portion
            otpStr = matcher.group();

            // Convert the OTP from a string to an integer
            int otp = Integer.parseInt(otpStr);

            System.out.println(otp);
        } else {
            System.out.println("OTP not found in the input string.");
        }
        
        //driver.findElement(By.xpath("//span[@onclick=\"otpdismiss();\"]")).click();

        // Now, you can enter the OTP digits as before
//        for (int i = 0; i < otpStr.length(); i++) {
////            char digit = otpStr.charAt(i);
//            List<WebElement> otpInput = driver.findElements(By.name("otp-number"));
//            int otpbx = otpInput.size();
//            System.out.println(otpbx);
            
            
            for (int i = 1; i <= 6; i++) {
                // Find the OTP input box by its ID or other suitable locator
                WebElement otpBox = driver.findElement(By.name("otp-number" + i)); // Replace with the actual ID or locator

                // Enter the digit from the OTP into the current box
                char digit = otpStr.charAt(i - 1); // Get the current digit from OTP
                otpBox.sendKeys(Character.toString(digit));
            }
            
        }

        // Close the browser
       
    }

