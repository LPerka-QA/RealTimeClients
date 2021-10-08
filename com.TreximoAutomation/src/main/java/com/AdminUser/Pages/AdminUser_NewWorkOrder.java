package com.AdminUser.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;
import com.aventstack.extentreports.Status;
import com.AdminUser.Pages.AdminUser_Login;
import com.AdminUser.Pages.AdminUser_Records;
import com.AdminUser.PagesData.AdminUser_LoginPageData;
import com.AdminUser.CommonPages.GoClinical_AdminUser_Menu;
import com.AdminUser.CommonPages.GoClinical_AdminUser_NewWorkOrder;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class AdminUser_NewWorkOrder extends BasePages {
	

	AdminUser_LoginPageData data = new AdminUser_LoginPageData();
	GoClinical_AdminUser_Menu MenuPage = new GoClinical_AdminUser_Menu();
	
	
	
	public void AdminUser_Home() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Objects from Application
// New Work Order
	
	public static WebElement dpd_Sponsor() {
		return driver.findElement(By.name("sponsor_id"));

	}

	public static WebElement dpd_Protocol() {
		return driver.findElement(By.xpath("//select[@id='work_order_protocol_id']"));

	}

	public static WebElement txt_PatientID() {
		return driver.findElement(By.xpath("//input[@id='work_order_patient_study_id' and @type='text']"));

	}

	public static WebElement dpd_Visit() {
		return driver.findElement(By.xpath("//select[@id='work_order_visit_id']"));

	}

	public static WebElement txt_SrvcePrvdrEmail_RVSP() {
		return driver.findElement(By.xpath("//input[@id='work_order[rvsp_email]' and @type='text']"));

	}

	public static WebElement dpd_SndRcrdTo_SiteCntct() {
		return driver.findElement(By.xpath("//select[@id='work_order_site_user_id']"));

	}

	public WebElement btn_CreateWorkOrder() {
		return driver.findElement(By.xpath("//div//input[@value='Create Work order' and @type='submit']"));

	}

	public static WebElement btn_Back() {
		return driver.findElement(By.xpath("//a[@href='/work_orders' and text()='Back']"));

	}

	public static WebElement readonly_WrkOrdrCrteSuccessMsg() {
		return driver.findElement(By.xpath("//div[@class='notice']//p[text()='Work order was successfully created.']"));

	}

	

	// Each Object Performance Method
	// New Work Order Info
	
	public void SelectSponsor(int row) throws IOException, InterruptedException {		
		String SponsorValue = data.Getdata("Sponsor", row);
		Thread.sleep(6000);
		//clickOnLink(dpd_Sponsor(), "Sponsor");
		Thread.sleep(6000);
		selectByText(dpd_Sponsor(), "Sponsor" , "PPG Auto Testing Sponsor");
		Thread.sleep(6000);
	}	

	public void SelectProtocol(int row) throws IOException, InterruptedException  {
		Thread.sleep(6000);
		String ProtocolValue = data.Getdata("Protocol", row).trim();
		selectByText(dpd_Protocol(), "Protocol", ProtocolValue);
	}	

	public void EnterPatientID(int row) throws IOException {
		String PatientIDValue = data.Getdata("Patient ID", row).trim();
		enterText(txt_PatientID(), "Patient ID", PatientIDValue);
	}

	public void SelectVisit(int row) throws IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String VisitValue = data.Getdata("Visit", row).trim();
		selectByText(dpd_Visit(), "Visit", VisitValue);
	}	
	
	public void EnterSrvcePrvdrEmail_RVSP(int row) throws IOException {
		String ServiceProviderEmail_RVSPValue = data.Getdata("Service Provider Email RVSP", row).trim();
		enterText(txt_SrvcePrvdrEmail_RVSP(), "Service Provider Email (RVSP)", ServiceProviderEmail_RVSPValue);
	}

	public void SelectSndRcrdTo_SiteCntct(int row) throws IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String SendRecordtoSiteContactValue = data.Getdata("Send Record to Site Contact", row).trim();
		selectByText(dpd_SndRcrdTo_SiteCntct(), "Send Record To (Site Contact)", SendRecordtoSiteContactValue);
	}
	
	// Each Object Performance Method
	// Submit Section
		
	public void ClickCreateWorkOrder() throws IOException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		clickOnButton(btn_CreateWorkOrder(), "Create Work order");
	}
	
	// Each Object Performance Method
		// Verification Section

	public void ValidateCrtWrkOrdrSuccessMsg(int row) throws IOException {
		String ExpectedCrtWrkOrdrSuccessMsg = data.Getdata("Expected Work Order Created Message", row).trim();
		verifyTextEqualwithAttributeValue(readonly_WrkOrdrCrteSuccessMsg(), ExpectedCrtWrkOrdrSuccessMsg,
				"Validate Create Work Order Success Message");

	}
	
	
	// Actual Functional Method 

	public void WorkOrders_New(int row) throws Exception {
		
		MenuPage.ClickWorkOrders();
		
		MenuPage.ClickWorkOrdersNew();
		
				SelectSponsor(row);
				Thread.sleep(6000);
				
				SelectProtocol(row);
				
				EnterPatientID(row);
				
				SelectVisit(row); 
				
				EnterSrvcePrvdrEmail_RVSP(row);
				
				SelectSndRcrdTo_SiteCntct(row);		
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				BasePages.scrollElementIntoView(btn_CreateWorkOrder());
				
				ClickCreateWorkOrder();
				
				//ValidateCrtWrkOrdrSuccessMsg(row);
				
	}

	

}
