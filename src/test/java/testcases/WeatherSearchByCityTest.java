package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WeatherSearchByCityTest {

	@Test
	public void weatherSearch() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://weatherapp-appsvc.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//*[@class='search']")).sendKeys("London");
		
		Thread.sleep(3000);

		List<WebElement> values = driver.findElements(By.id("locations"));

		for (WebElement value : values) {

			String name = value.toString();

			System.out.println(name);

			if (name == "London, LND") {

				value.click();
			}

		}

		//driver.quit();

	}

}
