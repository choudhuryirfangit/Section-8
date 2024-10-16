import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] veggies = { "Cucumber", "Tomato", "Carrot", "Brinjal" };
		int j = 0;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			j++;
			String name = products.get(i).getText();
			String[] splittedName = name.split("-");
			String formattedName = splittedName[0].trim();

			List<String> itemsNeeded = Arrays.asList(veggies);

			if (itemsNeeded.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == veggies.length) {
					break;
				}
			}

		}
	}
}
