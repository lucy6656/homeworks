package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class QuickToolsDropDownMenu extends Page {

    @FindBy(xpath="//a//*[contains(text(),'Calculate')]")
    private WebElement calculatePrice;

    public void clickCalculatePrice(){click(calculatePrice);}

}
