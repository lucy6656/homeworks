package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.Page;

public class LookUpZipForm_Page extends Page {

    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement street;

    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement city;

    @FindBy(xpath = "//select[@id='tState']")
    private WebElement state;

    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement submit;

   public void fillStreet(String value){
       giveValue(street, value);
   }

    public void fillCity(String value){
        giveValue(city, value);
    }

    public void fillState(String value) {
        Select state = new Select(this.state);
        state.selectByValue(value);
    }

    public void submitForm (){
        click(submit);
    }
}
