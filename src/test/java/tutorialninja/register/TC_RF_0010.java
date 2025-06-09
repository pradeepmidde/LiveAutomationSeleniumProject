package tutorialninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_0010 {

	@Test
	public void verifyRegisterWithInvalidEmail() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("pradeep");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("midde");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("amotoori1");
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9876543210");

        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
        driver.findElement(By.xpath("//label[normalize-space()='No']")).click();

        driver.findElement(By.xpath("//input[@name='agree']")).click();		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		//screenshot methods
		File srcscreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcscreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		
		BufferedImage actualimage = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		BufferedImage expectedimage = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));
		
		ImageDiffer imgdiffer=new ImageDiffer();
		ImageDiff imgdifference = imgdiffer.makeDiff(expectedimage, actualimage);
//		boolean b = imgdifference.hasDiff();
//		System.out.println(b);
		Assert.assertFalse(imgdifference.hasDiff());
		driver.quit();
}
}
