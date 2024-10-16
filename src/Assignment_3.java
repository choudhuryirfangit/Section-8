import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
//		Implicit Wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		Assignment_3 a = new Assignment_3();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		a.login(driver, w);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.nav-link.btn.btn-primary")));
		a.addToCart(driver, w);
		System.out.println(driver.findElement(By.cssSelector("td.text-right h3 strong")).getText());
		driver.quit();

	}

	public void login(WebDriver driver, WebDriverWait w) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		Select s = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		s.selectByIndex(2);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
	}

	public void addToCart(WebDriver driver, WebDriverWait w) {
		List<WebElement> products = driver.findElements(By.cssSelector("div.card-body"));
		for (int i = 0; i < products.size(); i++) {
			driver.findElements(By.cssSelector("div.card-footer")).get(i).click();
		}
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

	}

}
