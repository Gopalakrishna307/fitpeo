package stepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Web_Drivers;

public class Revenue_StepDef {
	
	private WebDriver driver;
	
//	public Revenue_StepDef() {
//		this.driver =Web_Drivers.getDriver();
//	}

	
	@Given("Open the FitPeo HomePage")
	public void open_the_fit_peo_home_page() {
		driver=Web_Drivers.getDriver();
	   driver.get("https://www.fitpeo.com");
	}

	@When("Navigate to the Revenue Calculator page")
	public void navigate_to_the_revenue_calculator_page() {
	   WebElement revenueCal = driver.findElement(By.xpath("//a[@href='/revenue-calculator']"));
	   revenueCal.click();
	}

	@When("Adjust the slider to {int}")
	public void adjust_the_slider_to(Integer sliderValue) throws InterruptedException {
	    WebElement slider = driver.findElement(By.xpath("//span[@data-index='0']"));
	    Actions act=new Actions(driver); 
	    int xoffset = sliderValue;
	    act.dragAndDropBy(slider, xoffset, 0).perform();
	    
	    String slider_text_field = driver.findElement(By.xpath("//input[@id=':r0:']")).getText();
	    Thread.sleep(1000);
	    Assert.assertEquals(String.valueOf(sliderValue),slider_text_field);
	    
			
			
	}

	@When("Update the text field to {int}")
	public void update_the_text_field_to(Integer textFieldValue) {
		WebElement text_field = driver.findElement(By.xpath("//input[@id=':r0:']"));
		text_field.clear();
		text_field.sendKeys(String.valueOf(textFieldValue));
		
		WebElement slider = driver.findElement(By.xpath("//span[@data-index='0']"));
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.attributeToBe(slider, "560", String.valueOf(textFieldValue)));
	}

	@When("Select CPT codes CPT99091, CPT99453, CPT99454, CPT99474")
	public void select_cpt_codes_cpt99091_cpt99453_cpt99454_cpt99474() {
		  WebElement cpt99091 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")); 
		  WebElement cpt99453 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
		  WebElement cpt99454 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
		  WebElement cpt99474 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[7]"));
		//div[@class="MuiBox-root css-1eynrej"]//p[text()='CPT-99091']
		  if(!cpt99091.isSelected()) cpt99091.click();
		  if(!cpt99453.isSelected()) cpt99453.click();
		  if(!cpt99454.isSelected()) cpt99454.click();
		  if(!cpt99474.isSelected()) cpt99474.click();
	}
	
	

	@Then("The Total recurring reimbursement for all patients per month should be ${double}")
	public void the_total_recurring_reimbursement_for_all_patients_per_month_should_be_$(Double double1) {
	  String total_Reim_Text = driver.findElement(By.xpath("")).getText();
	  Assert.assertEquals("$110,700",total_Reim_Text);
	}
}
