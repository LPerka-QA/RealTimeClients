package com.AdminUser.CommonPages;

import java.io.IOException;

import com.AdminUser.Pages.AdminUser_Login;
import com.AdminUser.Pages.AdminUser_NewWorkOrder;
import com.AdminUser.Pages.AdminUser_Records;
import com.AdminUser.CommonPages.GoClinical_AdminUser_Menu;

import jxl.read.biff.BiffException;

public class GoClinical_AdminUser_NewWorkOrder {

	public static void AdminUser_Login(int row) throws IOException, InterruptedException {
		AdminUser_Login getPage_PageLogin = new AdminUser_Login();
		getPage_PageLogin.login(row);
	}

	public static void Create_NewWorkOrder(int row)
			throws Exception {
		AdminUser_NewWorkOrder getPage_PageLogin = new AdminUser_NewWorkOrder();
		getPage_PageLogin.WorkOrders_New(row);
	}
	
	public static void GoCliniCal_AdminUser_Menu_ClickLogout() throws IOException, InterruptedException {
		GoClinical_AdminUser_Menu getPage_PageLogout = new GoClinical_AdminUser_Menu();
		getPage_PageLogout.ClickWelcomUser();
		getPage_PageLogout.ClickLogout();
	}
	
}
