package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5Train {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(10000);
		driver.findElement(By.partialLinkText("FLIGHTS")).click();

		// Get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> allwindowHandlesList = new ArrayList<String>();
		allwindowHandlesList.addAll(windowHandles);
		String parentWindow1 = allwindowHandlesList.get(0);
		String window2 = allwindowHandlesList.get(1);

		driver.switchTo().window(window2);

		WebElement elementNotification = driver.findElement(By.xpath("//button[text()='Later']"));
		if (elementNotification.isDisplayed()) {
			elementNotification.click();
		}

		driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).click();
		String email = driver.findElement(By.partialLinkText("flights@irctc.co.in")).getText();
		System.out.println("Customer care email: " + email);
		driver.switchTo().window(parentWindow1);
		driver.close();

	}

}
