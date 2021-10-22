package automationFramework;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.FrameworkBase;
import org.openqa.selenium.chrome.ChromeDriver;
import automationFramework.pages.GoogleSearchPage;
import static org.junit.Assert.*;

public class googleStep extends FrameworkBase {
  

	public googleStep() {
		super();
		// TODO Auto-generated constructor stub
	}

    private GoogleSearchPage page;
    
 
    @Before
    public void setUp()  {
  
        page = new GoogleSearchPage();
    	getDriver();
    }

    @After
    public void teardown(){
      /*  System.out.println("Closing chrome Session");
        if(driver!=null){
            driver.quit();
            System.out.println(" Chrome session closed.");
        }*/
    }
    @Given("I reach google home page")
    public void i_reach_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://google.com");
        page.acceptTermsOfUse();

    }


    @When("I enter valid search criteria {string}")
    public void i_enter_valid_search_criteria(String searchCriteria) {
        page.enterSearchCriteria(searchCriteria);
    }

    @Then("The result page displayed at least one result")
    public void the_result_page_displayed_at_least_one_result() {
        // Write code here that turns the phrase above into concrete actions
       
        assertFalse(page.countSearchResults().isEmpty());
    }

}
