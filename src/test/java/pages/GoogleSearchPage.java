package automationFramework.pages;
import base.FrameworkBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GoogleSearchPage extends FrameworkBase{

    final private By googleSearchBar =By.cssSelector("[name=q]");
    final private By resultCountLocator = By.id("result-stats");
    private WebDriver driver;
   /*public GoogleSearchPage(WebDriver _driver){

         driver = _driver;
    }*/

    /**
     * Accepts google terms of use
     */
    public void acceptTermsOfUse(){
        try{
            //If terms of use displayed
            //Accepts
        	WebDriverWait wait = new WebDriverWait(driver , 5000); 
        	wait.until(driver -> driver.switchTo().frame(0)); 
    		WebElement agree = driver.findElement(By.id("introAgreeButton")); agree.click();
    		driver.switchTo().defaultContent();
        }catch (Exception ex){
            //When there are no terms of use displayed
            // DO nothing
        }
    }

    /**
     * Enter search criteria in google search bar
     * @param searchCriteria
     */
    public void enterSearchCriteria(String searchCriteria){
        System.out.println(String.format("Entering Search criteria %s", searchCriteria));
       setText(googleSearchBar, searchCriteria+ Keys.ENTER);
    }

    /**
     * Count search results
     * @return
     */
    public String countSearchResults(){
    //Search result pattern
    //About 6,900,000 results (0.55 seconds)
      return  select(resultCountLocator).getText().split(" ")[1];
  
    }

}
