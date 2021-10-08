package com.AdminUser.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AdminUser.CommonPages.GoClinical_AdminUser_Menu;
import com.AdminUser.PagesData.AdminUser_LoginPageData;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;

import jxl.read.biff.BiffException;

public class AdminUser_Records extends BasePages {
	

	AdminUser_LoginPageData data = new AdminUser_LoginPageData();
	GoClinical_AdminUser_Menu MenuPage = new GoClinical_AdminUser_Menu();
	
	
	public void AdminUser_Home() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebElement lnk_Records() {
		return driver.findElement(By.xpath("//li//a[@href='/records' and text()='Records']"));

	}
	
	public static WebElement readonly_RecordsHeader() {
		return driver.findElement(By.xpath("//div[@id='records_index']//h1[conatins(text(),'Records')]"));

	}
	
	public static WebElement readonly_LatestRecord() {
		return driver.findElement(By.xpath("//td[text()='Demo-Study1']//..//td[text()='0004']//..//td[text()='Week 1']//..//td[text()='REVIEW']//..//td//a[contains(@href,'/records/') and text()='View']"));

	}	
	
	public static WebElement Lnk_ViewLatestRecord() {
		return driver.findElement(By.xpath("//td[text()='Demo-Study1']//..//td[text()='0004']//..//td[text()='Week 1']//..//td[text()='REVIEW']//..//td//a[contains(@href,'/records/') and text()='View']"));

	}
	
	public static WebElement txt_Password() {
		return driver.findElement(By.xpath("//input[@id='password' and @type='password']"));

	}
	
	public WebElement btn_SendToStudySite() {
		return driver.findElement(By.xpath("//input[@value='Send to Study Site' and @type='submit']"));

	}
	
	public static WebElement readonly_BloodPressure_Systolic_mm_Hg() {
		return driver.findElement(By.xpath("//h2[text()='Vital Signs']//..//td[contains(text(),'Blood Pressure (Systolic mm Hg)')]//..//td[contains(text(),'140')]"));

	}
	
	public static WebElement readonly_BloodPressure_Diastolic_mm_Hg() {
		return driver.findElement(By.xpath("//h2[text()='Vital Signs']//..//td[contains(text(),'Blood Pressure (Diastolic mm Hg)')]//..//td[contains(text(),'90')]"));

	}
	
	public static WebElement readonly_HeartRate() {
		return driver.findElement(By.xpath("//h2[text()='Vital Signs']//..//td[contains(text(),'Heart Rate')]//..//td[contains(text(),'190')]"));

	}
	

	

	// Each Object Performance Method
	// Records
	
	public void ClickRecordsHeader() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		clickOnLink(lnk_Records(), "Records ");
	}
	
	public void ClickViewLatestRecord() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		clickOnLink(Lnk_ViewLatestRecord(), "View");
	}
	
	public void EnterPassword(int row) throws IOException {
		enterText(txt_Password(), "Password", LaunchBrowser.TestSettingsObjects.getProperty("AdminUserPassword"));
	}
	
	public void ClickSendToStudySite() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		clickOnButton(btn_SendToStudySite(), "Send to Study Site");
	}
	
		
	// Each Object Performance Method
		// Verification Section

	public void ValidateRecordsHeader(int row) throws IOException {
		String ExpectedRecordsHeader = data.Getdata("Expected Records Header", row).trim();
		verifyTextEqualwithAttributeValue(readonly_RecordsHeader(), ExpectedRecordsHeader,
				"Validate Records Header");

	}
	
	public void ValidateLatestRecord(int row) throws IOException {
		String ExpectedLatestRecord = data.Getdata("Expected Latest Record", row).trim();
		verifyTextEqualwithAttributeValue(readonly_LatestRecord(), ExpectedLatestRecord,
				"Validate latest Record");

	}
	
	public void ValidateBloodPressureSystolic(int row) throws IOException {
		String ExpectedBPSystolic = data.Getdata("Expected Blood Pressure Systolic", row).trim();
		verifyTextEqualwithAttributeValue(readonly_BloodPressure_Systolic_mm_Hg(), ExpectedBPSystolic,
				"Validate Blood Pressure Systolic Value");

	}
	
	public void ValidateBloodPressureDiastolic(int row) throws IOException {
		String ExpectedBPDiastolic = data.Getdata("Expected Blood Pressure Diastolic", row).trim();
		verifyTextEqualwithAttributeValue(readonly_BloodPressure_Diastolic_mm_Hg(), ExpectedBPDiastolic,
				"Validate Blood Pressure Diastolic Value");

	}
	
	public void ValidateHeartRate(int row) throws IOException {
		String ExpectedHeartRate = data.Getdata("Expected Heart Rate", row).trim();
		verifyTextEqualwithAttributeValue(readonly_HeartRate(), ExpectedHeartRate,
				"Validate Heart Rate Value");

	}
	
	
	
	// Actual Functional Method 

	public void Records(int row) throws IOException, InterruptedException, BiffException {
		
		
		ClickRecordsHeader();
		//ValidateRecordsHeader(row);
		//ValidateLatestRecord(row);
		ClickViewLatestRecord();
		//ValidateBloodPressureSystolic(row);
		//ValidateBloodPressureDiastolic(row);
		//ValidateHeartRate(row);
				
	}

}
