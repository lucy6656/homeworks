package pages_USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class Calculate_Page extends Page {

    @FindBy(xpath="//input[@id='quantity-0']")
    private WebElement quantity;

    @FindBy(xpath="//input[@value='Calculate']")
    private WebElement calculateButton;

    @FindBy(xpath="//div[@id='total']")
    private WebElement price;

    public void setQuantity(String value){
        giveValue(quantity, value);
    }

    public void calculate (){
        click(calculateButton);
    }

    public String getPrice (){
        return price.getText();
    }
}
