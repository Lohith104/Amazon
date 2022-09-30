package com.Amazon.Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.Regular_methods;
import SDP.SDP;

public class Amazon_Automation extends Regular_methods {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = Browser_launch("chromedriver");
		SDP sdp= new SDP(driver);
		
		
		get_app("https://www.amazon.in/");
		clickelement(sdp.getHm().getElectronics());
		List<WebElement> elements = driver.findElements(By.xpath("(//a[@class='a-color-base a-link-normal']//span)"));
		int count =0;
		for (WebElement webElement : elements) {
			
			String string = webElement.getText();
			System.out.println(string);
			count++;
		}
		System.out.println(count);
		
		Actions("movetoelement", sdp.getHm().getEle());
		//Actions(value, null)
		List<WebElement> list = driver.findElements(By.xpath("//body[1]/div[1]/header[1]/div[1]/div[3]/div[13]/div[2]/div[1]/div[2]/ul[1]/li"));
		
		for (WebElement webElement : list) {
			String text = webElement.getText();
			System.out.println(text);
		}
		
		clickelement(sdp.getHm().getApple());
		clickelement(sdp.getHm().getA_phone());
		Thread.sleep(2000);
		//WebElement element = driver.findElement(By.id("productTitle"));
		//waituntilElementVisibility(element);
		//JavascriptExecutor js= (JavascriptExecutor)driver;		
       // js.executeScript("arguments[0].scrollIntoView();",sdp.getHm().getTB());
		Thread.sleep(5000);
		Actions("movetoelement", sdp.getHm().getButton());
		
		
		
		
		
		
	
		 
		
		
		
		
	}

}
