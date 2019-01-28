package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages_USPS.*;

import static org.assertj.core.api.Assertions.assertThat;

public class USPSsteps_POM {
    @Given("^I go to usps page object$")
    public void iGoToUspsPageObject() {
        new USPS_Home_Page().open();
    }

    @When("^I go to Lookup ZIP page object by address$")
    public void iGoToLookupZIPPageObjectByAddress() {
       USPS_Home_Page page = new USPS_Home_Page();
        MailAndShipDropDownMenu drop = page.mouseOverMailAndShip();
        drop.clickLookUpZip();
        new LookUpZip_Page().clickFindByAddress();
    }

    @And("^I fill out \"([^\"]*)\" street, \"([^\"]*)\" city, \"([^\"]*)\" state page object$")
    public void iFillOutStreetCityStatePageObject(String street, String city, String state) throws Throwable {
        LookUpZipForm_Page zipForm = new LookUpZipForm_Page();
        zipForm.fillStreet(street);
        zipForm.fillCity(city);
        zipForm.fillState(state);
        zipForm.submitForm();
    }

    @Then("^I validate \"([^\"]*)\" zip code exists in the result page object$")
    public void iValidateZipCodeExistsInTheResultPageObject(String zip) throws Throwable {
        LookUpZipResult_Page results = new LookUpZipResult_Page();
        assertThat(results.getResults()).contains(zip);
    }

    @When("^I go to Calculate Price page object$")
    public void iGoToCalculatePricePageObject() {
        USPS_Home_Page page = new USPS_Home_Page();
        QuickToolsDropDownMenu drop = page.mouseOverQuickTools();
        drop.clickCalculatePrice();
    }

    @And("^I select \"([^\"]*)\" with \"([^\"]*)\" shape And I define \"([^\"]*)\" quantity page object$")
    public void iSelectWithShapeAndIDefineQuantityPageObject(String country, String shape, String quantity) throws Throwable {
        CalculatePrice_Page calculateForm = new CalculatePrice_Page();
        calculateForm.setCountry(country);
        calculateForm.setShape(shape);
        Calculate_Page calculate =  new Calculate_Page();
        calculate.setQuantity(quantity);
    }

    @Then("^I calculate the price and validate cost is \"([^\"]*)\" page object$")
    public void iCalculateThePriceAndValidateCostIsPageObject(String price) throws Throwable {
        Calculate_Page calculate =  new Calculate_Page();
        calculate.calculate();
        assertThat(calculate.getPrice()).contains(price);
    }

    @When("^I go to Postal Store tab$")
    public void iGoToPostalStoreTab() {
        new USPS_Home_Page().mouseOverPostalStore();
    }

    @And("^I enter \"([^\"]*)\" into store search page object$")
    public void iEnterIntoStoreSearchPageObject(String keyword) throws Throwable {
        PostalStoreDropDownMenu postalMenu = new USPS_Home_Page().mouseOverPostalStore();
        postalMenu.enterKeyword(keyword);
        postalMenu.clickSearch();
    }

    @Then("^I search and validate no products found page object$")
    public void iSearchAndValidateNoProductsFoundPageObject() throws Throwable{
//        PostalStoreDropDownMenu postalMenu = new USPS_Home_Page().mouseOverPostalStore();
//        postalMenu.clickSearch();
        PostalStoreResults_Page results = new PostalStoreResults_Page();
        assertThat(results.getNoResults()).isTrue();
    }
}
