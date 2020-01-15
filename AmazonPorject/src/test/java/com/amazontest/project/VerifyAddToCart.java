package com.amazontest.project;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyAddToCart {
	
	public WebDriver driver;
	String url="http://amazon.com";
	String search="Running Shoe";	
			
	@Test
	
	
	public void Setup() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "//Users//bpat12//Downloads//chromedriver");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("shoes");
		//driver.findElement(By.xpath("input[@type='text']")).sendKeys("shoes");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		//driver.findElement(By.xpath("//*[contains(text(),'Shoe')]")).click();
		
		List<WebElement> items= driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		//String abc= driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
		System.out.println("Number of elements:" + items.size());
		
		items.get(5).click();
			
		
		/*for(WebElement i:items) {
			if(i.getText().contains("Shoe"))
			{
				i.click();
				break;
			}
			break;
		}*/
		
		//driver.findElement(By.xpath("//select[@name='dropdown_selected_size_name']")).click();
		Select dropdwn = new Select(driver.findElement(By.xpath("//select[@name='dropdown_selected_size_name']")));
		dropdwn.selectByVisibleText("7");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("add-to-cart-button")).click();
        String cart=driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
        System.out.println("Total number if items in cart"+cart);
        
    	Thread.sleep(2000);
       // int qty=Integer.parseInt(cart);
       
        Assert.assertEquals(cart, "1");
        
    	
       /* if(qty==1)
        {
        	System.out.println("item is added to cart");
        }
        else
        {
        	System.out.println("item is not added");
        }*/
		
	}
	@Test
	public void endSession() {
		driver.quit();
	}

}
