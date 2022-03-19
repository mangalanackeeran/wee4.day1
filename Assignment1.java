package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("(//input[@name='ComboBox_partyIdFrom']//following::img)[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> allwindowHandlesList = new ArrayList<String>();
		allwindowHandlesList.addAll(windowHandles);
		String oldWindow = allwindowHandlesList.get(0);
		String newWindow = allwindowHandlesList.get(1);

		driver.switchTo().window(newWindow);

		driver.findElement(By.xpath("(//div[text()='Contact ID']/following::a[@class='linktext'])[1]")).click();

		driver.switchTo().window(oldWindow);

		driver.findElement(By.xpath("(//input[@id='ComboBox_partyIdTo']//following::img)[1]")).click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println(windowHandles1);
		List<String> allwindowHandlesList1 = new ArrayList<String>();
		allwindowHandlesList1.addAll(windowHandles1);
		String oldWindow1 = allwindowHandlesList1.get(0);
		String newWindow1 = allwindowHandlesList1.get(1);

		driver.switchTo().window(newWindow1);

		driver.findElement(By.xpath("(//div[text()='Contact ID']/following::a[@class='linktext'])[6]")).click();
		driver.switchTo().window(oldWindow1);

		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		Alert alert = driver.switchTo().alert();

		alert.accept();

		String title = driver.getTitle();
		if (title.equals("View Contact | opentaps CRM")) {
			System.out.println("Title verified");
		} else {
			System.out.println("Incorrect title");
		}

	}

}
