package org.hcl.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hcl.base.CreateDriver;
import org.hcl.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_Login_ValidCredentials extends CreateDriver{
	
	@Test(dataProvider="dp2")
	public void loginWithValidCredentials(String a, String b)
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(a);
		login.enterPassword(b);
	}
	
	@DataProvider(name="dp1")
	public String[][] testData()
	{
		String [][] data = {{"uname1","pass1"},
				            {"uname2","pass2"},
				            {"uname3","pass3"}};
		return data;
	}

	
	@DataProvider(name="dp2")
	public String[][] testDataExcel() throws IOException
	{
		FileInputStream f = new FileInputStream("E:\\FrameWork.xlsx");
		XSSFWorkbook wk = new XSSFWorkbook(f);
		XSSFSheet sh = wk.getSheetAt(0);
		int r= sh.getPhysicalNumberOfRows();
		String [][] data = new String[r][2];
		for(int i=0;i<r;i++)
		{
			XSSFRow r1 = sh.getRow(i);
			XSSFCell u = r1.getCell(0);
			XSSFCell p = r1.getCell(1);
			data[i][0] = u.getStringCellValue();
			data[i][1] = p.getStringCellValue();
		
		}
		return data;
	}
}
