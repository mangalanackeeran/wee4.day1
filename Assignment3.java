package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		WebElement frameTextBox = driver.findElement(By.xpath("//iframe[@id=\"frame1\"]"));
		driver.switchTo().frame(frameTextBox);
		driver.findElement(By.xpath("/html/body/input")).sendKeys("test");

		WebElement frameCheckBox = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frameCheckBox);

		WebElement checkBox = driver.findElement(By.xpath("//input[@id='a']"));
		checkBox.click();
		driver.switchTo().defaultContent();

		WebElement frameDropDown = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frameDropDown);
		WebElement dropDrown = driver.findElement(By.className("col-lg-3"));
		Select selects = new Select(dropDrown);
		selects.selectByIndex(1);

	}

}
