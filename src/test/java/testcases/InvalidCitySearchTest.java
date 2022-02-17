package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidCitySearchTest {

	@Test
	public void invalidCity() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://weatherapp-appsvc.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String expErrorMsg = "No results";

		driver.findElement(By.xpath("//*[@class='search']")).sendKeys("abcd");

		String actErrorMsg = driver.findElement(By.xpath("//span[normalize-space()='No results.']")).getText();

		System.out.println("Actual Error message for invalid city search: " + actErrorMsg);

		Assert.assertEquals(actErrorMsg, expErrorMsg);

		driver.quit();
	}

}
