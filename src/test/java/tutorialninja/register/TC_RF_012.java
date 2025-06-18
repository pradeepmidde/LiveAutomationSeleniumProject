package tutorialninja.register;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.CommonUtils;

public class TC_RF_012 {

	@Test
	public void verifyRegisteringAccountUsingKeyboardKeys()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		Actions actions=new Actions(driver);
		for(int i=1; i<=23;i++)
		{
			actions.sendKeys(Keys.TAB).perform();
		}
		actions.sendKeys("pradeep").perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys("midde").perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(CommonUtils.genarateEmail());
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys("9876512345").perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys("12345").perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys("12345").perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.LEFT).perform();
		actions.sendKeys(Keys.TAB).perform();
		WebElement privacyCheckbox = driver.findElement(By.name("agree"));
		privacyCheckbox.click();
		actions.sendKeys(Keys.TAB).perform();
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		actions.moveToElement(continueButton).click().perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).isDisplayed());
		
		//driver.quit();
		
	}
	
}
