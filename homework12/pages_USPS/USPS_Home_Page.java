package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class USPS_Home_Page extends Page {
    public USPS_Home_Page () {
        setUrl("https://www.usps.com/");
    }

    @FindBy(xpath="//li[@class='qt-nav menuheader']")
    private WebElement quickTools;

    @FindBy(xpath="//a[@id='mail-ship-width']")
    private WebElement mailAndShip;

    @FindBy(xpath="//a[@class='menuitem'][contains(text(),'Postal Store')]")
    private WebElement postalStore;

    public QuickToolsDropDownMenu mouseOverQuickTools() {
        mouseOver(quickTools);
        return new QuickToolsDropDownMenu();
    }

    public MailAndShipDropDownMenu mouseOverMailAndShip() {
        mouseOver(mailAndShip);
        return new MailAndShipDropDownMenu();
    }

    public PostalStoreDropDownMenu mouseOverPostalStore() {
        mouseOver(postalStore);
        return new PostalStoreDropDownMenu();
    }

}
