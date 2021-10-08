package com.NurseUser.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.NurseUser.CommonPages.GoClinical_NurseUser_Menu;
import com.NurseUser.PagesData.NurseUser_LoginPageData;
import com.Utils.BasePages;

import jxl.read.biff.BiffException;

public class NurseUser_Records  extends BasePages {
	
	NurseUser_LoginPageData data = new NurseUser_LoginPageData();
	GoClinical_NurseUser_Menu MenuPage = new GoClinical_NurseUser_Menu();
	
	public void NurseUser_RecordsPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// Objects from Application
	// Records
	
		public static WebElement lnk_Records() {
			return driver.findElement(By.xpath("//li//a[@href='/records' and text()='Records']"));

		}
		
		public static WebElement readonly_RecordsHeader() {
			return driver.findElement(By.xpath("//div[@id='records_index']//h1[conatins(text(),'Records')]"));

		}
		
		public static WebElement readonly_LatestRecord() {
			return driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-hover']//td[text()='Demo-Study1']//..//td[text()='0004']//..//td[text()='Week 1']//..//td[text()='REVIEW']"));

		}		
		

		

		// Each Object Performance Method
		// Records
		
		public void ClickRecordsHeader() throws IOException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			clickOnLink(lnk_Records(), "Records ");
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
		
		
		
		
		// Actual Functional Method 

		public void Records(int row) throws IOException, InterruptedException, BiffException {
			
			
			ClickRecordsHeader();
			//ValidateRecordsHeader(row);
			//ValidateLatestRecord(row);
			
					
		}

}
