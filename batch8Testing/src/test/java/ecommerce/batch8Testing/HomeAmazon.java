package ecommerce.batch8Testing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class HomeAmazon {
  public static WebDriver driver;
  
  
  @FindBy(xpath="(//*[contains(text(),'Best Sellers')])[1]") WebElement BestSellers;
  
  @FindBy(xpath = "(//*[contains(text(),'Amazon Basics')])[1]")WebElement AmazonBasics;
  @FindBy(xpath="(//*[contains(text(),'Connect with')])[1]")WebElement facebookActualText;
  @FindBy(xpath="//*[@name='email']") WebElement facebookemailfeild;
  @FindBy(xpath="//*[@name='pass']") WebElement facebookpassfeild;
  
  public HomeAmazon(WebDriver driver) {
	  HomeAmazon.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  
  
  public void enteremail(String email) {
	  facebookemailfeild.sendKeys(email);
  }
  public void enterpass(String pass) {
	  facebookpassfeild.sendKeys(pass);
  }
  
  
  public void bestSellersClick() {
	  BestSellers.click();
  }
  public void amazonBasicsClick() {
	  AmazonBasics.click();
  } 
  public void getFacebookActualTextComparison() {
	  String stringfacebookActaualText = facebookActualText.getText();
	// Assert.assertEquals(stringfacebookActaualText, "Connect with friends and the world99 around you on Facebook.");
	 
	  SoftAssert sf= new SoftAssert();
	 sf.assertEquals(stringfacebookActaualText, "Connect with friends and the world99 around you on Facebook.");
 System.out.println("this text is after failed assertion");
  //sf.assertAll();
  }
}
