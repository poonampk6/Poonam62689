package Vtiger;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import BaseClass.BaseClass_Vtiger;
import FileUtility.ExcelUtil;
import JavaUtility.JavaUtil;
import POM_DWSVtiger.Home;
import POM_DWSVtiger.Organizations;

public class VTigerCreateOrg extends BaseClass_Vtiger{

	ExcelUtil eUtil = new ExcelUtil();
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		Home h = new Home(driver);
		h.organizations();
		int row = 0;
		Organizations org = new Organizations(driver);
		org.plusIcon();
		String orgName= eUtil.getData("Org", row++, 0);
		org.organizationName(orgName+JavaUtil.generateRandomNumber(1000));
		org.group();
		org.assignedto(eUtil.getData("Org", row++, 0));
		org.saveBtn();	
		assertTrue((org.getCreatedOrgText().getText()).contains(orgName));
	}
}
