package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_011 {

	WebDriver driver;
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	public void verifyRegisterAccountInvalidNumber() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("pradeep");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("midde");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(genarateEmail());
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("adcde");
        
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("abcde");
        driver.findElement(By.xpath("//label[normalize-space()='No']")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedwarining = "Telephone does not appear to be valid!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@type='tel']//following-sibling::div")).getText(), expectedwarining);
	}
	public String genarateEmail() {
        String emailwithtimestamp = new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";  //chaining
        return emailwithtimestamp;
    }
}
