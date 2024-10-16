import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get("https://rahulshettyacademy.com/loginpagePractise/");
				WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
				driver.findElement(By.cssSelector("a.blinkingText")).click();
				Set<String> windows=driver.getWindowHandles();
				Iterator<String> it=windows.iterator();
				String parentwindow=it.next();
				String childwindow=it.next();
				driver.switchTo().window(childwindow);
				System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
				driver.findElement(By.cssSelector("p.im-para.red")).getText();
				String emailId=driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
				driver.switchTo().window(parentwindow);
				driver.findElement(By.id("username")).sendKeys(emailId);

	}

}
