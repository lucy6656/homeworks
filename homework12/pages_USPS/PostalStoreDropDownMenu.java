package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class PostalStoreDropDownMenu extends Page {

    @FindBy(xpath="//input[@id='global-header--search-track-store']")
    private WebElement store;

    @FindBy(xpath="//form[@role='search']//*[@value='Search']")
    private WebElement search;

    public void enterKeyword(String value) {
        giveValue(store, value);}

    public void clickSearch(){click(search);}
}
