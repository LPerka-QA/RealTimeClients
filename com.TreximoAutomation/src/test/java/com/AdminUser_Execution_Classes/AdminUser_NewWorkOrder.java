package com.AdminUser_Execution_Classes;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.Status;
import com.AdminUser.CommonPages.GoClinical_AdminUser_NewWorkOrder;
import com.AdminUser.Pages.AdminUser_Login;
import com.AdminUser.Pages.AdminUser_Records;
import com.AdminUser.PagesData.AdminUser_LoginPageData;
import com.AdminUser.CommonPages.GoClinical_AdminUser_Menu;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;



public class AdminUser_NewWorkOrder {
	
	private static String HTMLReportPAth = null;
	private static String CurrentPageTestCaseName = null;
	private static String ExcelSheetPath = null;
	private static String Excel_SheetName = null;
	private static String WritePath = null;
	private static BasePages ReportingPages = null;
	private static AdminUser_LoginPageData AdminUserNewWorkOrder = null;
		
		@BeforeTest
		public void TestSetup() throws IOException, BiffException {
						
									HTMLReportPAth = System.getProperty("user.dir") + "\\Resources\\Reports\\Daily Execution\\AdminUserNewWorkOrder.html";
									CurrentPageTestCaseName = "Admin User New Work Orders";
									ExcelSheetPath = System.getProperty("user.dir") + "\\Resources\\TestData\\AdminUser_TestData.xls";
									Excel_SheetName = "New Work Orders";
									ReportingPages = new BasePages(HTMLReportPAth, CurrentPageTestCaseName);
									WritePath = System.getProperty("user.dir") + "\\Resources\\TestOutData\\AdminUser_TestOutData.xls";
									AdminUserNewWorkOrder = new AdminUser_LoginPageData(ExcelSheetPath, Excel_SheetName, ExcelSheetPath);

									BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
									AdminUserNewWorkOrder.ClearExistingStatus();
			
			LaunchBrowser.LaunchBrowserapp();
		}

		@Test
		public static void LaunchGoClinicalAPP() throws IOException, InterruptedException, BiffException, WriteException {
			for (int row = 1; row < AdminUserNewWorkOrder.GetRows(); row++) {
				if (AdminUserNewWorkOrder.Getdata("Patient ID", row).trim().length() > 2) {
					try {

												AdminUserNewWorkOrder.setData("Execution Status", row, "Started");
			
												GoClinical_AdminUser_NewWorkOrder.AdminUser_Login(row);
												GoClinical_AdminUser_NewWorkOrder.Create_NewWorkOrder(row);
												GoClinical_AdminUser_NewWorkOrder.GoCliniCal_AdminUser_Menu_ClickLogout();
			
												AdminUserNewWorkOrder.setData("Execution Status", row, "Executed");
						}
					catch (Exception e) {
												System.out.println("In Catch Main");
												BasePages.ResultsLog.logger.log(Status.FAIL, e.toString() + " Row " + row);
												
					try {

						}
					catch (Exception e1) {
												BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
												BasePages.ExecutionPageExceptionErrorCapture(
												CurrentPageTestCaseName + " Data Row Number, " + row, e1.toString());

						}

						
												AdminUserNewWorkOrder.setData("Execution Status", row, "Row Execution Not Completed");

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
