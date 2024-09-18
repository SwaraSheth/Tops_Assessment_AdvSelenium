package com.assessment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/*
 *  Write script to fill this form using selenium webdriver. 
 * 	URL : https://demoqa.com/automation-practice-form 
 * 
 */
public class Task1 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", 
				"D:\\\\SeleniumNew\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions actions=new Actions(driver);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		WebElement element=driver.findElement(By.id("firstName"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		driver.findElement(By.id("firstName")).sendKeys("Swara");
		Thread.sleep(2000);
		
		driver.findElement(By.id("lastName")).sendKeys("Shah");
		Thread.sleep(2000);
		
		driver.findElement(By.id("userEmail")).sendKeys("Swara@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("userNumber")).sendKeys("0123456789");
		Thread.sleep(2000);
		
		driver.findElement(By.id("dateOfBirthInput")).click();
		Thread.sleep(2000);
		
		WebElement birthmonth=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
		Select s1=new Select(birthmonth);
		s1.selectByValue("1");
		
		WebElement birthyear=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
		Select s2=new Select(birthyear);
		s2.selectByValue("1994");
		
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("subjectsInput")).sendKeys("Software Testing");
		Thread.sleep(2000);
		
		 
		driver.findElement(By.id("currentAddress")).sendKeys("Surat");
		Thread.sleep(2000);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 js2.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		 driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[text()='Rajasthan']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[2]/div")).click();
		 Thread.sleep(2000);	
		 driver.findElement(By.xpath("//div[text()='Jaipur']")).click();
		 Thread.sleep(2000);
		 
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
		File file=((org.openqa.selenium.remote.RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Top_Assessment\\\\ScreenShots\\FormDetails.jpg"));
		driver.close();
	}
	
	
}
