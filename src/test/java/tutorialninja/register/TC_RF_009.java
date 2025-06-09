package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_009 {

	@Test
	public void verifyRegisterWithEmailAlready() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("pradeep");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("midde");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("amotoori1@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9876543210");

        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("abcde");
        driver.findElement(By.xpath("//label[normalize-space()='No']")).click();

        driver.findElement(By.xpath("//input[@name='agree']")).click();		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String expectedwarning = "Warning: E-Mail Address is already registered!";
		String actualwarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(expectedwarning, actualwarning);
	
	}
}
