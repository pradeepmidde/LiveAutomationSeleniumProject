package tutorialninja.register;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_008 {

	@Test
	public void verifyRegisterMismatchingPassword() {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//a[@title='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("pradeep");
	        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("midde");
	        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(genarateEmail());
	        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9876543210");

	        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
	        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("abcde");
	        driver.findElement(By.xpath("//label[normalize-space()='No']")).click();

	        driver.findElement(By.xpath("//input[@name='agree']")).click();		
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			String expectedwarning = "Password confirmation does not match password!";
			String actualwarning = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
			Assert.assertEquals(actualwarning, expectedwarning);
	        }
	public String genarateEmail() {
        String emailwithtimestamp = new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";  //chaining
        return emailwithtimestamp;
    }
}
