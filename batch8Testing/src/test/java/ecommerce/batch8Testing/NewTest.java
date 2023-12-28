package ecommerce.batch8Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	 static WebDriver driver;
	 @BeforeTest
	  public void beforeTest() {
		  System.out.println("this is before test");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\youno\\eclipse-workspace\\training\\src\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.amazon.com");
			driver.manage().window().maximize();
	  }	
	
	
	@Test
  public void Test1() {
	  System.out.println("this is test");
	  
  }
	@Test
	  public void Test2() {
		  System.out.println("this is test");
		  
	  }
	
  
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  System.out.println("this is after test");
	  Thread.sleep(5000);
	  driver.close();
	  
  }

}
