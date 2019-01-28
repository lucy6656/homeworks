package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class LookUpZipResult_Page extends Page {

    @FindBy(xpath = "//div[@id='zipByAddressDiv']")
    private WebElement results;

    public String getResults(){
        waitForVisible(results);
        return results.getText();
    }
}
