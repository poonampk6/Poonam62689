package DWS;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import BaseClass.BaseClass_DWS;
import FileUtility.ExcelUtil;
import POM_DWSVtiger.Cart;
import POM_DWSVtiger.GiftCard;
import POM_DWSVtiger.HomePage;

public class DWSGiftCard extends BaseClass_DWS{

	ExcelUtil eUtil = new ExcelUtil();
	@Test
	public void giftCard() throws EncryptedDocumentException, IOException, InterruptedException
	{
		assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		
		HomePage hPage = new HomePage(driver);
		hPage.giftCard();
		
		int row = 0;
		
		GiftCard gCard = new GiftCard(driver);
		gCard.giftCard25();
		gCard.rName(eUtil.getData("DWS_G", row++, 0));
		Thread.sleep(2000);		
		
		gCard.rEmail(eUtil.getData("DWS_G", row++, 0));
		
		Thread.sleep(2000);		
		
		gCard.getSName().clear();
		
		gCard.sName(eUtil.getData("DWS_G", row++, 0));
		Thread.sleep(2000);		
		
		gCard.getSEmail().clear();
		Thread.sleep(2000);		
		
		gCard.sEmail(eUtil.getData("DWS_G", row++, 0));	
		Thread.sleep(2000);		
		
		gCard.giftMsg(eUtil.getData("DWS_G", row++, 0));
		Thread.sleep(2000);		
		
		gCard.giftQty(String.valueOf((int)Double.parseDouble(eUtil.getData("DWS_G", row++, 0))));
		Thread.sleep(2000);
		gCard.addToCart();
		
		hPage.cart();
		Thread.sleep(2000);		
		Cart c = new Cart(driver);
		assertTrue(c.getGiftCard25().isDisplayed(), "$25 product is not displayed in cart");
	}
}
