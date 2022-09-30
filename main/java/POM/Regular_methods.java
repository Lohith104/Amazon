package POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Regular_methods {
	public static WebDriver driver;
	

	public static String value;
	//1
	public static WebDriver Browser_launch(String drivername) {
		
		if (drivername.equalsIgnoreCase("ChromeDriver")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lohith\\git\\Adactin_cucumber\\AdactinCucumber_new\\Driver\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if (drivername.equalsIgnoreCase("safari")) {
		System.setProperty("webdriver.chrome.driver", "webdriver.chrome.driver")	;
		driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		return driver;
			
	}
	//2
	public static void get_app(String appname) {
		driver.get(appname);
	}
	//3
	public static void Sendkeys(String text,WebElement element ) {
		element.sendKeys(text);
	}
	//4
	public static void clickelement(WebElement element) {
      element.click();
	}
	//5
	public static void scrollup_down(String Scroll,String point) {	
		JavascriptExecutor s=(JavascriptExecutor)driver;
	if (Scroll.equalsIgnoreCase("Up")) {
		s.executeScript(point);
	}
	else if (Scroll.equalsIgnoreCase("Down")) {
		s.executeScript(point);}	
		}
	public static void radiobutton(WebElement element) {
		element.click();
	}
	//6
	public static void enabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}
	//7
	public static void displayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}
	//8
	public static void selected(WebElement element) {
  boolean selected = element.isSelected();
  System.out.println(selected);
	}
	//9
	public static void currenturl() {
		System.out.println(driver.getCurrentUrl());
	}
	//10
	public static  void text(WebElement element) {
		String textst = element.getText();
		System.out.println(textst);
	}
	//11
	public static void attribute(WebElement element) {
		String attribute = element.getAttribute("id");
System.out.println(attribute);
	}
	//12
	public static  void title() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	//13
	public static void navigate(String navi) {
		 if (navi.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}
		else if (navi.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
		else if (navi.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();}}
	//14
	public static void navigateto(String url) {
		driver.navigate().to(url);
	}
	//15
	public static void multiple(WebElement element) {
		Select l=new Select(element);
            boolean b = l.isMultiple();
            System.out.println(b);
	}
	//16
	public static void dropdown(WebElement element,String by,String value) {
		Select s=new Select(element);
			if (by.equalsIgnoreCase("selectbyvalue")) {
				s.selectByValue(value);}
			else if (by.equalsIgnoreCase("selectbyvisibletext")) {
				s.selectByVisibleText(value);
			}
			else if (by.equalsIgnoreCase("selectbyindex")) {
				int option=Integer.parseInt(value);
			s.selectByIndex(option);	
			}	}
	//17
	public static void alloptions(WebElement element) {
		Select h=new Select(element);
List<WebElement> list = h.getOptions();
for (WebElement all : list) {
	String text = all.getText();
	System.out.println(text);
}
	}
	//18
	public static void firstselect(WebElement element) {
		Select l=new Select(element);
		WebElement option = l.getFirstSelectedOption();
		System.out.println(option.getText());}
	//19
	public static void allselected(WebElement element) {
		Select j=new Select(element);
List<WebElement> list = j.getAllSelectedOptions();
for (WebElement allselect : list) {
	String text = allselect.getText();
	System.out.println(text);}
}
	//20
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot f =(TakesScreenshot)driver;
		File src=f.getScreenshotAs(OutputType.FILE);
		File des=new File(filename);
		org.openqa.selenium.io.FileHandler.copy(src, des);
	}
	//21
	public static void Wait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);}
	//22
	public static void alert(WebElement element,String type,String text) {
		element.click();
		Alert alert = driver.switchTo().alert();
		if (type.equalsIgnoreCase("simplealert")) {
			alert.accept();
		}
		else if (type.equalsIgnoreCase("confrimalert")){
			alert.dismiss();
		}
		else if (type.equalsIgnoreCase("Promptalert")) {
			alert.sendKeys(text);
			alert.accept();	}}
	//23
	public static void Actions(String type,WebElement element) {
		Actions act =new Actions(driver);
		if (type.equalsIgnoreCase("Click")) {
			act.click(element).perform();
		}
		//else if (type.equalsIgnoreCase("Clickandhold")) {
			//act.clickAndHold(element).moveToElement(element1).perform();
//}
		else if (type.equalsIgnoreCase("contextclick")) {
act.contextClick(element).perform();
	}
		else if (type.equalsIgnoreCase("doubleclick")) {
	act.doubleClick(element).perform();
}
		else if (type.equalsIgnoreCase("movetoelement")) {
			act.moveToElement(element).perform();
		}}
	//24
	public static void draganddrop(WebElement element,WebElement element1) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element1).perform();}
	//25
	public static void Robotclass() throws AWTException {
		Robot robot=new Robot();
		for (int i = 0; i <=0; i++) {
			int a=i;
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	//26
	public static void windowhandles() {
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> list = handles.iterator();
		while (list.hasNext()) {
			String next1 = list.next();
			if (!handle.equals(next1)) {
				String title = driver.switchTo().window(next1).getTitle();
				System.out.println(title);}	
}}
	//27
	public static void frames(String type,WebElement element) {
		if (type.equalsIgnoreCase("element")) {
			driver.switchTo().frame(element);
		}
		else if (type.equalsIgnoreCase("index")) {
			//driver.switchTo().frame(num);
		}
		else if (type.equalsIgnoreCase("id")) {
			//driver.switchTo().frame(id);
		}}
	//28
	public static void close() {
		driver.close();
	}
	//29
	public static void quit() {
		driver.quit();}
	
	public static String readData(String path,int sheet,int r,int c) throws IOException {
	File exe=new File(path);
	FileInputStream l=new FileInputStream(exe);
	Workbook wb=new XSSFWorkbook(l);
	Sheet sheetat = wb.getSheetAt(sheet);
	Row row = sheetat.getRow(r);
	Cell cell = row.getCell(c);
	CellType type = cell.getCellType();
	if (type.equals(CellType.STRING)) {
		  value= cell.getStringCellValue();
	}
	else if (type.equals(CellType.NUMERIC)) {
		
		double data = cell.getNumericCellValue();
		int value1=(int)data;
		 value = String.valueOf(data);
		
	}
	return value;

	}
	
	public static boolean elementDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
		return displayed;

	}
	
	public static void waituntilElementVisibility(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void waituntilpageload(String url) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.urlMatches(url));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		

	}

	
		

	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	


