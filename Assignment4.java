package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/frame.html");
		List<WebElement> tagnames = driver.findElements(By.tagName("iframe"));
		int size = tagnames.size();
		System.out.print("Number of frame present is"+ size);

	}

}
