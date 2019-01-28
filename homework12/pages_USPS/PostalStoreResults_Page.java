package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class PostalStoreResults_Page extends Page {

    @FindBy(xpath="//div[@class='breadcrumb-cartridge']")
    private WebElement keyword;

    @FindBy(xpath="//div[@class='no-product']")
    private WebElement noProduct;

    public Boolean getNoResults (){
        waitForVisible(keyword);
        return noProduct.isDisplayed();
    }

}
