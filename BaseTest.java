package com.ibm.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.ibm.pages.AdminPage;
import com.ibm.pages.BannerPage;
import com.ibm.pages.CouponPage;
import com.ibm.pages.LoginPage;
import com.ibm.utilities.PropertiesFileHandler;

import junit.framework.Assert;

public class BaseTest {
	
	@Test
	public void login() throws IOException, InterruptedException
	{
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String expectedTitle = data.get("expectedtitle");
		String couponname = data.get("couponname");
		String code = data.get("code");
		String discount = data.get("discount");
		String amount = data.get("amount");
		String startdate = data.get("startdate");
		String enddate = data.get("enddate");
		String usespercoupon = data.get("usespercoupon");
		String usespercustomer = data.get("usespercustomer");
		//String expectedcouponmessage = data.get("expectedcouponmessage");
		
						
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();
		
		AdminPage apage=new AdminPage(driver, wait);
		String actualTitle=apage.getCurrentTitle();
				
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test Passed");
			propFileHandler.setKeyAndValue(file, "TestResult", "Test Passed");
		}
		else
		{
			System.out.println("Test failed");
			propFileHandler.setKeyAndValue(file, "TestResult", "Test Failed");
		}
			
		/*BannerPage bpage=new BannerPage(driver, wait);
		bpage.addBanner();*/
		
		CouponPage coupon = new CouponPage(driver);
		coupon.clickOnLinkMarketing();
		coupon.clickOnLinkCoupons();
		coupon.clickOnIconAddNew();
		coupon.enterCode(code);
		coupon.clickOnType();
		coupon.enterDiscount(discount);
		coupon.enterAmount(amount);
		coupon.enterStartDate(startdate);
		coupon.enterEndDate(enddate);
		coupon.enterUsesPerCoupon(usespercoupon);
		coupon.enterUsesPerCustomer(usespercustomer);
		coupon.clickOnStatus();
		coupon.enterCouponName(couponname);
		coupon.clickOnIconSave();
		Thread.sleep(5000);
		coupon.validationOnRecord();
		
		//apage.clickOnLogOut();

		//driver.close();
	
	//excel data using dataprovider
	//run and check	
	//sends data in excel one by one
    /*@Test(dataProvider = "data")
    public void testcase2(String user, String pwd){
    		System.out.println(user);
    		System.out.println(pwd);
    }

    @DataProvider(name="data")
    public Object[][] data() throws IOException {
        return ExcelUtil.DataTable("./TestData/TestData.xlsx","LoginData");
    }*/

	}
}
