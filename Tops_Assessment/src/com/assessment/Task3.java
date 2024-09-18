package com.assessment;

import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;




/*
 *Task 1 : Write a script to click on Edit button for given name 
 *Task 2 : Write a Script to click on Delete button for given name  
 *Link : https://demoqa.com/webtables
 */

public class Task3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", 
				"D:\\\\SeleniumNew\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/h1"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		driver.findElement(By.xpath("//*[@id=\"edit-record-1\"]")).click();
		
		WebElement fnameElement=driver.findElement(By.id("firstName"));
		
		fnameElement.clear();
		Thread.sleep(2000);
		fnameElement.sendKeys("swara");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@id='delete-record-1']//*[name()='svg']")).click();
		Thread.sleep(10000);
		
		driver.close();
			
				
	}
	
}
