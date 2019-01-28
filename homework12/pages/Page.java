package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public abstract class Page {
    private String url;

    public Page(){
        PageFactory.initElements(getDriver(), this);
    }

    public static void clickWithJS (WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) getDriver(); //extract the executor from the driver
        executor.executeScript("arguments[0].click();", element);
    }

    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(String url){
        return this.url;
    }

    public void open(){
        getDriver().get(url);
    }


    public void click(WebElement element){  // our own click method for the cases when click doesn't work, and we use js
        try {                               // need to convert all click methods to this one
            element.click();
        }
        catch (WebDriverException e){
            clickWithJS(element);
        }
    }

    public void giveValue(WebElement element, String value){
        waitForVisible(element); //optional, depends on the page
        element.sendKeys(value);
    }

    public void mouseOver(WebElement element){
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
    }

    public void waitForVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));

    }
}

