package com.amazontest.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	String url="http://demo.guru99.com/test/drag_drop.html";
	public WebDriver driver;
	
	@Test
	public void DragDropFunctionality() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "//Users//bpat12//Downloads//chromedriver");
		driver=new ChromeDriver();
		driver.get(url);
		System.out.println("Launching browser");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Element that needs to be Drag
		WebElement from=driver.findElement(By.xpath("//*[@id='fourth']/a"));
		
		//Element on which need to drop
		WebElement to=driver.findElement(By.xpath("//*[@id='bank']/li"));
		
		Thread.sleep(2000);
		//Using Action class
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.dragAndDrop(from, to);
		
		
		
		driver.close();
		
	}

}
