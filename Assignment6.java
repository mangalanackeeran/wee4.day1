package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro" + Keys.ENTER);
		String price = driver.findElement(By.xpath("//div[@data-index='2']//span[@class='a-price-whole']")).getText();
		System.out.println("price" + price);

		String star = driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[2]/div/span[1]"))
				.getDomAttribute("aria-label");
		System.out.println("Rating" + star);
		driver.findElement(By.xpath(
				"//div[@data-index='2']//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']"))
				.click();
		String percent = driver.findElement(By.xpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[3]/span[2]/a"))
				.getText();
		System.out.println("5 star percentage" + percent);
		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
				.click();
		Set<String> window = driver.getWindowHandles();
		System.out.println(window);
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(window);

		String newWindow = allWindowHandleList.get(1);
		System.out.println(newWindow);

		driver.switchTo().window(newWindow);
		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		
		WebElement elementTotal =
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')]//span)[1]"));
		String subTotal = elementTotal.getText();
		System.out.println("SubTotal: " + subTotal);
	}

}
