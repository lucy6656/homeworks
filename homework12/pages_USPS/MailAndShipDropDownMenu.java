package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class MailAndShipDropDownMenu extends Page {

    @FindBy(xpath="//li[@class='tool-zip']//a")
    private WebElement lookUpZip;

    public void clickLookUpZip(){click(lookUpZip);}
}
