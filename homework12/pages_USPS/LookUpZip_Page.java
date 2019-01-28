package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class LookUpZip_Page extends Page {
    public LookUpZip_Page (){
        setUrl("https://tools.usps.com/go/ZipLookupAction_input");
    }

    @FindBy(xpath="//a[text()='Find by Address']")
    private WebElement findByAddress;

    public void clickFindByAddress(){
        click(findByAddress);
    }
}
