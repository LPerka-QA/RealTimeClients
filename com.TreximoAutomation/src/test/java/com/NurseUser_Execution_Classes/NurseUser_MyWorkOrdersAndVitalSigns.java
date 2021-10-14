package com.NurseUser_Execution_Classes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AdminUser.CommonPages.GoClinical_AdminUser_NewWorkOrder;
import com.AdminUser.PagesData.AdminUser_LoginPageData;
import com.NurseUser.CommonPages.GoClinical_NurseUser_MyWorkOrders;
import com.NurseUser.PagesData.NurseUser_LoginPageData;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;
import com.aventstack.extentreports.Status;

import jxl.read.biff.BiffException;

public class NurseUser_MyWorkOrdersAndVitalSigns {
	
	private static String HTMLReportPAth = null;
	private static String CurrentPageTestCaseName = null;
	private static String ExcelSheetPath = null;
	private static String Excel_SheetName = null;
	private static String WritePath = null;
	/*private static String ExcelSheetPath1 = null;
	private static String Excel_SheetName1 = null;
	private static String WritePath1 = null;*/
	private static BasePages ReportingPages = null;
	private static NurseUser_LoginPageData NurseUserMyWorkOrders = null;
	private static AdminUser_LoginPageData AdminUserNewWorkOrder = null;
	
	
	//This method used to add a time stamp to name of HTML report
	public static String DateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy hh_mm_ss");
		String timeStamp = df.format(date);
		return timeStamp;
	}
		
		@BeforeTest
		public void TestSetup() throws IOException, BiffException {
			
			
			
			String Name = "Nurse My Work Records Vital Signs";
			String timeStamp = DateTime();
			String ReportName = Name+"_"+ timeStamp+".html";
						
									HTMLReportPAth = System.getProperty("user.dir") + "\\Resources\\Reports\\Daily Execution\\"+ReportName;
								CurrentPageTestCaseName = "Nurse User My Work Orders And Vital Signs";
								ExcelSheetPath = System.getProperty("user.dir") + "\\Resources\\TestData\\MyWorkOrders_VitalAndSigns_TestData.xls";
								Excel_SheetName = "My Work Orders";
								ReportingPages = new BasePages(HTMLReportPAth, CurrentPageTestCaseName);
								WritePath = System.getProperty("user.dir") + "\\Resources\\TestData\\MyWorkOrders_VitalAndSigns_TestData.xls";
								NurseUserMyWorkOrders = new NurseUser_LoginPageData(ExcelSheetPath, Excel_SheetName, WritePath);

								BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
								NurseUserMyWorkOrders.ClearExistingStatus();			
			
								LaunchBrowser.LaunchBrowserapp();
		}

		@Test
		public void LaunchGoClinicalAPP() throws IOException, InterruptedException, BiffException {
			for (int row = 1; row < NurseUserMyWorkOrders.GetRows(); row++) {
				if (NurseUserMyWorkOrders.Getdata("Blood Pressure Systolic mm Hg", row).trim().length() > 2) {
					try {

								NurseUserMyWorkOrders.setData("Execution Status", row, "Started");
						
								GoClinical_NurseUser_MyWorkOrders.NurseUser_Login(row);
								GoClinical_NurseUser_MyWorkOrders.MyWorkOrders_VitalSigns(row);
								GoClinical_NurseUser_MyWorkOrders.Records(row);
								GoClinical_NurseUser_MyWorkOrders.GoCliniCal_NurseUser_Menu_ClickLogout();
			
								NurseUserMyWorkOrders.setData("Nurse User Execution Status", row, "Executed");
						}
					catch (Exception e) {
								System.out.println("In Catch Main");
								BasePages.ResultsLog.logger.log(Status.FAIL, e.toString() + " Row " + row);
								NurseUserMyWorkOrders.setData("Nurse User Error", row, e.toString());
					try {

							
						}
					catch (Exception e1) {
								BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
								BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e1.toString());
								NurseUserMyWorkOrders.setData("Nurse User Error", row, e1.toString());

						}
						
								NurseUserMyWorkOrders.setData("Nurse User Execution Status", row, "Row Execution Not Completed");

					}
				}
			}
			
		}

		@AfterTest
		public void CloseTest()  throws IOException {
								//close Browser
								ReportingPages.CloseBrowser();
		}

}
