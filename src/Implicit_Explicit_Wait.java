import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Implicit_Explicit_Wait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] neededItems= {"Beetroot","Cauliflower","Beans","Mushroom"};
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
//		Implicit Wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);	
		
		Implicit_Explicit_Wait a=new Implicit_Explicit_Wait();
		a.getData(driver, neededItems);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
//		Explicit Wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
//		Explicit Wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.quit();

	}
	public void getData(WebDriver driver, String[] neededItems) {
		int j=0;
		List<WebElement> products= driver.findElements(By.xpath("//h4[@class='product-name']"));
		for(int i=0;i<products.size();i++) {
		String[] splitItem=products.get(i).getText().split("-");
		String actualItem=splitItem[0].trim();
		
		List<String> NeededItemsList=Arrays.asList(neededItems);
		
		if(NeededItemsList.contains(actualItem)) {
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			j++;
			if(j==neededItems.length) {
				break;
			}
			
		}
		
		}
	}

}
