package pages_USPS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class CalculatePrice_Page extends Page {

    @FindBy(xpath="//select[@id='CountryID']")
    private WebElement countryList;

    @FindBy(xpath="//input[@id='option_1']")
    private WebElement postcard;

    public void setCountry(String value){
        WebElement country = countryList.findElement(By.xpath("//*[text()='"+value+"']"));
        click(country);
    }

    public void setShape(String value){
        switch (value){
            case "Postcard":
                click(postcard);
                break;
        }
    }

}
