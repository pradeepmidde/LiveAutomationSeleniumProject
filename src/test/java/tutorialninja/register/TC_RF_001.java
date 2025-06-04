package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

    @Test
    public void verifyRegisterFields() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("pradeep");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("midde");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(genarateEmail());
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9876543210");

        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");

        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click(); 
        
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        
        String expectedheading="Your Account Has Been Created!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"common-success\"]//h1")).getText(), expectedheading);
        

        //driver.quit();
    }

    public String genarateEmail() {
        String emailwithtimestamp = new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";  //chaining
        return emailwithtimestamp;
    }
}
