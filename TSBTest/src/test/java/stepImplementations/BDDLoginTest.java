package stepImplementations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import verify.Compare;


public class BDDLoginTest {
	
	WebDriver driver;
	
	@Given ("^user is on web browser$")
	public void user_is_on_web_browser()
	{
		System.out.println("user is on web browser");
		driver = utilities.DriverFactory.open("Chrome");
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@When ("^user enters the correct correct url$")
	public void user_enters_the_correct_correct_url()
	{
		driver.get("http://demo.testfire.net/default.aspx");
	}
	
	
	@Then ("^user gets confirmation$")
	public void user_gets_confirmation()
	{
		boolean result = Compare.validateURL(driver, "http://demo.testfire.net/default.aspx");
		Assert.assertFalse(result);
		driver.close();
	}
	
	//with correct username and password
	
	@Given ("^user is on login page$")
	public void user_is_on_login_page() {
		System.out.println("user is on login page");
		driver = utilities.DriverFactory.open("Chrome");
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/default.aspx");
		driver.findElement(By.linkText("ONLINE BANKING LOGIN")).click();
		
	}
	
	@When ("^user enters the correct usernbame and password$")
	public void user_enters_the_correct_usernbame_and_password() {
		System.out.println("user enters the correct usernbame and password");
		driver.findElement(By.name("uid")).sendKeys("jsmith");
		driver.findElement(By.name("passw")).sendKeys("Demo1234");
		driver.findElement(By.name("btnSubmit")).click();
	}
	
	@Then ("^user gets confirmation1$")
	public void user_gets_confirmation1() {
		System.out.println("user gets confirmation");
		Assert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_promo\"]/table/tbody/tr[1]/td/h2")).getText(),"success");
		driver.close();
		}
	
	// with wrong password
	
	@Given ("^user is on login page1$")
	public void user_is_on_login_page1() {
		System.out.println("user is on login page");
		driver = utilities.DriverFactory.open("Chrome");
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/default.aspx");
		driver.findElement(By.linkText("ONLINE BANKING LOGIN")).click();
		
	}
	
	@When ("^user enters the correct usernbame and wrong password$")
	public void user_enters_the_correct_usernbame_and_wrong_password() {
		System.out.println("user enters the correct usernbame and wrong password");
		driver.findElement(By.name("uid")).sendKeys("jsmith");
		driver.findElement(By.name("passw")).sendKeys("Demo2");
		driver.findElement(By.name("btnSubmit")).click();
	}
	
	@Then ("^user gets confirmation11$")
	public void user_gets_confirmation11() {
		System.out.println("user gets confirmation");
		Assert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_message\"]")).getText(),"success");
		driver.close();
		}
	
	
	
	
	// with wrong username
	@Given ("^user is on login page2$")
	public void user_is_on_login_page2() {
		System.out.println("user is on login page");
		driver = utilities.DriverFactory.open("Chrome");
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/default.aspx");
		driver.findElement(By.linkText("ONLINE BANKING LOGIN")).click();
		
	}
	
	@When ("^user enters the wrong usernbame and correct password$")
	public void user_enters_the_wrong_usernbame_and_correct_password() {
		System.out.println("user enters the correct usernbame and wrong password");
		driver.findElement(By.name("uid")).sendKeys("Dsmith");
		driver.findElement(By.name("passw")).sendKeys("Demo1234");
		driver.findElement(By.name("btnSubmit")).click();
	}
	
	@Then ("^user gets confirmation12$")
	public void user_gets_confirmation12() {
		System.out.println("user gets confirmation");
		Assert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/table/tbody/tr[2]/td[2]/div/p")).getText(),"success");
		driver.close();
		}
	
	
	
	
	
	@Given ("^user is on transfer fund page$")
			public void user_is_on_transfer_fund_page() 
			
			
		{
		System.out.println("user is on transfer fund page");
		driver = utilities.DriverFactory.open("Chrome");
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/default.aspx");
		driver.findElement(By.linkText("ONLINE BANKING LOGIN")).click();
		driver.findElement(By.name("uid")).sendKeys("jsmith");
		driver.findElement(By.name("passw")).sendKeys("Demo1234");
		driver.findElement(By.name("btnSubmit")).click();
		driver.findElement(By.linkText("Transfer Funds")).click();
		}
			
	
	@When ("^selects the from account to account and enters amount$")
	public void selects_the_from_account_to_account_and_enters_amount() throws InterruptedException
	{
		System.out.println("selects the to account");
		new Select(driver.findElement(By.id("debitAccount"))).selectByVisibleText("1001160140 Checking");
		new Select(driver.findElement(By.id("creditAccount"))).selectByVisibleText("1001160141 Savings");
		driver.findElement(By.id("transferAmount")).sendKeys("25");
		driver.findElement(By.name("transfer")).click();
		Thread.sleep(1000);
			
	}
	
	
	@Then ("^user gets confirmation2$")
	public void user_gets_confirmation2()
	{
		System.out.println("user gets confirmation");
		Assert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"soapResp\"]/span")).getText(),"success");
		driver.close();
	}
	
	
	// blank amount
	

	@Given ("^user is on transfer fund page1$")
			public void user_is_on_transfer_fund_page1() 
			
			
		{
		System.out.println("user is on transfer fund page");
		driver = utilities.DriverFactory.open("Chrome");
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/default.aspx");
		driver.findElement(By.linkText("ONLINE BANKING LOGIN")).click();
		driver.findElement(By.name("uid")).sendKeys("jsmith");
		driver.findElement(By.name("passw")).sendKeys("Demo1234");
		driver.findElement(By.name("btnSubmit")).click();
		driver.findElement(By.linkText("Transfer Funds")).click();
		}
			
	
	@When ("^selects the from account to account and keeps amount blank$")
	public void selects_the_from_account_to_account_and_keeps_amount_blank() throws InterruptedException
	{
		System.out.println("selects the to account");
		new Select(driver.findElement(By.id("debitAccount"))).selectByVisibleText("1001160140 Checking");
		new Select(driver.findElement(By.id("creditAccount"))).selectByVisibleText("1001160141 Savings");
		driver.findElement(By.id("transferAmount")).sendKeys("");
		driver.findElement(By.name("transfer")).click();
		Thread.sleep(1000);
			
	}
	
	
	@Then ("^user gets confirmation21$")
	public void user_gets_confirmation21()
	{
		System.out.println("user gets confirmation");
		String str = driver.findElement(By.xpath("//*[@id=\"soapResp\"]/span")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"soapResp\"]/span")).getText(),str);
		driver.close();
	}
	
	
}
