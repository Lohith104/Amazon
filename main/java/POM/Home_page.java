package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	public WebDriver driver;
	
	@FindBy(linkText =  "Electronics")
	private WebElement Electronics;
	
	@FindBy(linkText = "Apple")
	private WebElement apple;
	
	@FindBy(xpath = "//span[text()='Apple iPhone 13 Pro (256GB) - Graphite']")
	private WebElement a_phone;
	
	@FindBy(xpath = "(//div[@class='twisterTextDiv text']//p)[3]")
	private WebElement TB;
	
	@FindBy(xpath =  "//a[@aria-label='Cameras']")
	private WebElement button;
	
	public WebElement getButton() {
		return button;
	}

	public WebElement getTB() {
		return TB;
	}

	public WebElement getA_phone() {
		return a_phone;
	}

	public WebElement getApple() {
		return apple;
	}

	public void setApple(WebElement apple) {
		this.apple = apple;
	}

	@FindBy(xpath = "(//a[@class='nav-a nav-hasArrow'])[1]")
	private WebElement ele;

	public WebElement getEle() {
		return ele;
	}

	public Home_page(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getElectronics() {
		return Electronics;
	}
	
	


}
