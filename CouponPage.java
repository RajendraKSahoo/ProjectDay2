package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CouponPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CouponPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement for link Marketing
		@FindBy(xpath="//i[@class='ti-share']")
		WebElement marketingEle;
	
	//WebElement for link Coupons
		@FindBy(xpath="//a[contains(text(),'Coupons')]")
		WebElement couponEle;
	
	//WebElement for icon Add New
		@FindBy(xpath="//a[@title='Add New']")
		WebElement addnewEle;
	
	//WebElement for field Coupon Name
		@FindBy(xpath="//input[@name='name']")
		WebElement cnameEle;
	
	//WebElement for field Code
		@FindBy(xpath="//input[@name='code']")
		WebElement codeEle;
	
	//WebElement for field Type
		@FindBy(xpath="//select[@name='type']/option[1]")
		WebElement typeEle;
	
	//WebElement for field Discount
		@FindBy(xpath="//input[@name='discount']")
		WebElement discEle;
	
	//WebElement for field Minimum Amount
		@FindBy(xpath="//input[@name='min_amount']")
		WebElement amtEle;
	
	//WebElement for field Start Date
		@FindBy(xpath="//input[@name='date_start']")
		WebElement startdateEle;
	
	//WebElement for field End Date
		@FindBy(xpath="//input[@name='date_end']")
		WebElement enddateEle;
		
	//WebElement for field Uses per Coupon
		@FindBy(xpath="//input[@name='uses_per_coupon']")
		WebElement upcoupEle;
		
	//WebElement for field Uses per Customer
		@FindBy(xpath="//input[@name='uses_per_customer']")
		WebElement upcustEle;
		
	//WebElement for field Status
		@FindBy(xpath="//select[@name='status']/option[1]")
		WebElement statusEle;
	
	//WebElement for icon Save
		@FindBy(xpath="//button[@title='Save']")
		WebElement saveEle;
	
	public CouponPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLinkMarketing()
	{
		marketingEle.click();
	}
	
	public void clickOnLinkCoupons()
	{
		couponEle.click();
	}
	
	public void clickOnIconAddNew()
	{
		addnewEle.click();
	}
	
	public void enterCouponName(String couponname)
	{
		cnameEle.sendKeys(couponname);
	}
	
	public void enterCode(String code)
	{
		codeEle.sendKeys(code);
	}
	
	public void clickOnType()
	{
		typeEle.click();
	}
	
	public void enterDiscount(String discount)
	{
		discEle.sendKeys(discount);
		
	}
	
	public void enterAmount(String amount)
	{
		amtEle.sendKeys(amount);
		
	}
	
	public void enterStartDate(String startdate)
	{
		startdateEle.sendKeys(startdate);
		
	}
	
	public void enterEndDate(String enddate)
	{
		enddateEle.sendKeys(enddate);
		
	}
	
	public void enterUsesPerCoupon(String usespercoupon)
	{
		upcoupEle.sendKeys(usespercoupon);
		
	}
	
	public void enterUsesPerCustomer(String usespercustomer)
	{
		upcustEle.sendKeys(usespercustomer);
		
	}
	
	public void clickOnStatus()
	{
		statusEle.click();
	}
	
	public void clickOnIconSave()
	{
		saveEle.click();
	}

	
	public void validationOnRecord() throws FileNotFoundException, IOException
	{
		Properties p = new Properties();
		p.load(new FileInputStream("./TestData/magentodata.properties"));
	
		String pagesource = driver.getPageSource();
	
	if(pagesource.contains(p.getProperty("couponname"))) {
		System.out.println("The presence of added coupon is confirmed!");
	}
	else {
		System.out.println("The coupon is not added to the Coupon List");
	}
	
	}
}
