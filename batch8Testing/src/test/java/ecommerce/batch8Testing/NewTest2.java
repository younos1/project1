package ecommerce.batch8Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;
public class NewTest2 {
	 static WebDriver driver;
  @BeforeMethod
 // @Parameters({"selectedbrowser"})
  public void beforeMethod(String selectedbrowser) throws InterruptedException, IOException {
	 System.out.println("this is before test");
	 
	 String brow=selectedbrowser;
	 if(brow.contains("chrome")) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\youno\\eclipse-workspace\\training\\src\\Drivers\\chromedriver.exe");
	 driver=new ChromeDriver(); 
	 }
	 else if(brow.contains("firefox")) {
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\youno\\eclipse-workspace\\training\\src\\Drivers\\geckodriver.exe");
	  driver=new FirefoxDriver(); 
	 }
	 else {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\youno\\eclipse-workspace\\training\\src\\Drivers\\msedgedriver.exe");
	  driver=new EdgeDriver(); 
	 }
	  
	  
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		shots_withCurrent_Date() ;
		Thread.sleep(5000);
  }
  
 @Test
 public void Test1() throws InterruptedException, IOException {
	 System.out.println("this is test");
	 HomeAmazon ob=new HomeAmazon(driver);
	 ob.enteremail("abc@yahpp.com");
	 shots_withCurrent_Date() ;
	 Thread.sleep(5000);
	 ob.enterpass("123");
	 shots_withCurrent_Date() ;
	 
	//  HomeAmazon ob=new HomeAmazon(driver);
	//  ob.bestSellersClick();
	  
	 // Thread.sleep(5000);
 }
 //@Test
// public void Test2() throws InterruptedException, IOException {
//	 System.out.println("this is test");
//	 HomeAmazon ob=new HomeAmazon(driver);
//	 ob.enteremail("def@yahpp.com");
//	 Thread.sleep(5000);
//	 ob.enterpass("456");
//	 shots();
 //}

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  System.out.println("this is after test");
	  Thread.sleep(5000);
	  driver.close();
  }
 public void shots() throws IOException {
	  File cap = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(cap, new File("C:\\Users\\youno\\eclipse-workspace\\batch8Testing\\screenshots\\1.png"));
 
} 
 public void shots_withArgs(String filename) throws IOException {
	  File cap = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(cap, new File("C:\\Users\\youno\\eclipse-workspace\\batch8Testing\\screenshots\\"+filename+".png"));
 
}
 public void shots_withCurrent_Date() throws IOException {
	 Date dt=new Date();
	String filename= dt.toString().replace(" ", "_").replace(" ","_" );
	 File cap = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(cap, new File("C:\\Users\\youno\\eclipse-workspace\\batch8Testing\\screenshots\\"+filename+".png"));
 }
} 