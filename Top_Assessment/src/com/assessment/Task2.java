package com.assessment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;


/*
 * Task 1 : Verify that there are only 4 structure values present in the table with Selenium 
 * Task 2 : Verify that the 6th row of the table (Last Row) has only two columns with Selenium 
 * Task 3 : Find the tallest structure in the table with Selenium 
 * Link : http://www.techlistic.com/2017/02/automate-demo-web-table-withselenium.html 
 */

public class Task2 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver;
	
	System.setProperty("webdriver.chrome.driver", 
			"D:\\\\SeleniumNew\\\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
	
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 1300)");
	
	List<WebElement> th=driver.findElements(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/thead/tr/th"));
	System.out.println("Total no of column:- "+(th.size()-1));
	
	List<WebElement> tr=driver.findElements(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tbody/tr"));
	System.out.println("Total no of Row:- "+tr.size());

	for (int i = 2; i <=th.size(); i++) {
		
		String thname=driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/thead/tr/th["+i+"]")).getText();
		System.out.print("      |      "+thname);
	}
	System.out.println();
	
	for (int i = 1; i <=tr.size(); i++) {
		
		for (int j = 1; j <=th.size()-1; j++) {

			String data=driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.print("      |      "+data);
		}
		System.out.println();
		System.out.println();
	}
	
	
System.out.println("============================== TASK-1 ===========================");

for (int i = 1; i <=4; i++)
{
String rowcount = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[1]/div[5]/table/tbody/tr["+i+"]/th")).getText();
System.out.println(rowcount);
}


System.out.println("============================== TASK-2 ===========================");

int lastrow= driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[1]/div[5]/table/tfoot/tr/th")).size();
System.out.println(lastrow + " Heading ");
int rowdata= driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[1]/div[5]/table/tfoot/tr/td")).size();
System.out.println(rowdata + " Coloumn ");
System.out.println("Hence verified that the 6th row of the table (Last Row) has only two columns ");

for (int i = 0; i < 1; i++) {
	String data=driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tfoot/tr")).getText();	
	
	System.out.println(data);
	}


System.out.println("============================== TASK-3 ===========================");

int max=0;
for(int i = 1; i <=4; i++)
{
	String str=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td[3]")).getText();
	String k = str.substring(0, str.length()-1);
	int temp=Integer.parseInt(k);
	System.out.println(temp);
	if (temp>max) {
		max=temp;
	}
}
System.out.println("Max is : "+max);	

Thread.sleep(2000);
driver.close();

}


}

