package SDP;

import org.openqa.selenium.WebDriver;

import POM.Home_page;

public class SDP {
	public WebDriver driver;
	
	
	private Home_page Hm;


	public SDP(WebDriver driver2) {
		this.driver=driver2;
	}


	public Home_page getHm() {
		Hm=new Home_page(driver);
		return Hm;
	}
	
	
	

}
