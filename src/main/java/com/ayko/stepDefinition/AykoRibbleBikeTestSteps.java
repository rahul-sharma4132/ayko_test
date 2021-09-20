package com.ayko.stepDefinition;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ayko.driverSetup.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AykoRibbleBikeTestSteps {
	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> black_bikes;
	public static List<WebElement> white_bikes;
	public static List<WebElement> bike_sizes;
	public static String price;

	@Given("^URL for Ribble Bikes works$")
	public void url_check() throws Exception {
		driver = DriverManager.setupDriver("chrome");
		driver.get("https://www.ribblecycles.co.uk/");
		Thread.sleep(500);
	}

	@When("^User hover over the Road menu option$")
	public void road_hover() throws Exception {
		Thread.sleep(500);
		WebElement road_nav = driver.findElement(By.xpath("//ul[@id='nav']//a[@title='Road']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(road_nav);
		actions.build().perform();
		Thread.sleep(500);
	}

	@Then("^User verify the Endurance SL e option is available$")
	public void check_bike_text() throws Exception {
		Thread.sleep(500);
		WebElement bikes = driver.findElement(By.xpath(
				"//nav[@class='nav-main']//a[@title='Road']//following-sibling::div//a[contains(text(),'Endurance SL e')]"));
		Thread.sleep(500);
		Assert.assertTrue(bikes.getText().contains("Endurance SL e"));
	}

	@Given("^Endurance SL e option is available under Road menu option$")
	public void bike_text_value() throws Exception {
		driver.getCurrentUrl();
	}

	@When("^User click on the ndurance SL e submenu option$")
	public void page_navigation() throws Exception {
		Thread.sleep(500);
		WebElement road_nav = driver.findElement(By.xpath("//ul[@id='nav']//a[@title='Road']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(road_nav);
		actions.build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//nav[@class='nav-main']//a[@title='Road']//following-sibling::div//a[contains(text(),'Endurance SL e')]"))
				.click();
	}

	@Then("^User verify the Endurance SL e option is  visible$")
	public void page_navigation_check() throws Exception {
		Thread.sleep(500);
		String newURL = driver.getCurrentUrl();
		Assert.assertTrue(newURL.contains("ribble-endurance-sl-e"));
		Thread.sleep(500);
	}

	@Given("^User has navigated to Endurance SL e page$")
	public void navigate_bikePage() throws Exception {
		WebElement road_nav = driver.findElement(By.xpath("//ul[@id='nav']//a[@title='Road']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(road_nav);
		actions.build().perform();
		driver.findElement(By.xpath(
				"//nav[@class='nav-main']//a[@title='Road']//following-sibling::div//a[contains(text(),'Endurance SL e')]"))
				.click();
	}

	@When("^User has counted the number of black bikes$")
	public void count_black_bikes() throws Exception {
		black_bikes = driver.findElements(By.xpath(
				"//div[@class='col__group--flex col__group--flex--justify-content--start product__content shuffle product__wrapper']//div[@data-groups='[\"Anthracite\"]']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", black_bikes.get(0));
	}

	@And("^User clicks on White$")
	public void move_to_White() throws Exception {
		driver.findElement(By.xpath("//div[@data-group='White']")).click();
	}

	@Then("^Count should change$")
	public void bike_count_check() throws Exception {
		Thread.sleep(500);
		white_bikes = driver.findElements(By.xpath(
				"//div[@class='col__group--flex col__group--flex--justify-content--start product__content shuffle product__wrapper']//div[@data-groups='[\"White\"]']"));
		Thread.sleep(500);
		Assert.assertTrue(black_bikes.size() != white_bikes.size());
	}

	@When("^User clicks on Build your bike$")
	public void navigate_to_buildBike() throws Exception {
		driver.findElement(By.xpath("//a[@data-id='bikebuilder_button']")).click();
		Thread.sleep(500);
	}

	@Then("^Build Your Bike webpage should appear$")
	public void check_buildPage_navigation() throws Exception {
		String url = driver.getCurrentUrl();
		Thread.sleep(500);
		Assert.assertTrue(url.contains("ribble-endurance-sl-e/build/"));
	}

	@And("^User checks the size available$")
	public void count_size() throws Exception {
		bike_sizes = driver.findElements(By.xpath("//*[contains(text(),'Select Size')]"));
	}

	@Then("^User should be able to see all sizes$")
	public void check_count_size() throws Exception {
		Assert.assertTrue(bike_sizes.size() == 5);
	}

	@And("^User Selects Medium Size Bike$")
	public void select_size() throws Exception {
		Thread.sleep(500);
		WebElement size_medium = driver.findElement(By.xpath("//div[@class='selectable__name' and contains(text(),'Medium')]/parent::div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", size_medium);
		Thread.sleep(500);
	}

	@Then("^User should be able to see the Customize button$")
	public void check_customize_button() throws Exception {
		Thread.sleep(500);
		String s = driver.findElement(By.xpath("//button[@data-cy='button_customise']")).getAttribute("data-cy");
		Assert.assertTrue(s.contains("customise"));
	}

	@Then("^User should be able to see the Checkout button$")
	public void check_checkout_button() throws Exception {
		Thread.sleep(500);
		String s = driver.findElement(By.xpath("//button[@data-cy='button_review']")).getAttribute("data-cy");
		Assert.assertTrue(s.contains("review"));
	}

	@And("^User Clicks on Review and Buy$")
	public void review_buy() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@data-cy='button_review']")).click();
		Thread.sleep(500);
	}

	@And("^User Clicks on Buy This Build$")
	public void buy_build() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='addToBasket']")).click();
		Thread.sleep(500);
	}

	@Then("^User should be able to see the item in the card$")
	public void cart() throws Exception {
		Thread.sleep(500);
		String s = driver.findElement(By.xpath("//a[contains(text(),'Ribble Endurance SL e')]")).getText();
		Assert.assertTrue(s.contains("Endurance"));
		Thread.sleep(500);
	}

	@And("^User Clicks on Customize Bike button$")
	public void customize_bike() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@data-cy='button_customise']")).click();
		Thread.sleep(500);
	}

	@And("^User Clicks on Frame button$")
	public void change_frame() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@data-cy='Frame']")).click();
		Thread.sleep(500);
	}

	@And("^User changes size to Large$")
	public void change_frame_size() throws Exception {
		Thread.sleep(500);
		WebElement frame_size = driver.findElement(By.xpath("//div[@class='selectable__name' and contains(text(),'Large')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", frame_size);
		Thread.sleep(500);
	}

	@And("^User Clicks on Style button$")
	public void change_style() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@data-cy='Style']")).click();
		Thread.sleep(500);
	}

	@And("^User Selects on Purple Blue style$")
	public void change_bike_style() throws Exception {
		Thread.sleep(500);
		WebElement bike_purple = driver.findElement(By.xpath("//div[@data-id='option_id_903051']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", bike_purple);
		js.executeScript("arguments[0].click()", bike_purple);
		Thread.sleep(500);
	}

	@And("^User Clicks on Group Set$")
	public void change_groupset() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@data-cy='Groupset']")).click();
		Thread.sleep(500);

	}

	@And("^User Selects Shimano Ultegra Disc Groupset$")
	public void change_disc_groupset() throws Exception {
		Thread.sleep(500);
		WebElement shimano_disc = driver.findElement(By.xpath("//div[@data-id='option_id_777790']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", shimano_disc);
		js.executeScript("arguments[0].click()", shimano_disc);
		Thread.sleep(500);
	}

	@And("^User Clicks on GPS Mount$")
	public void change_gps() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@data-cy='GPS Mounts']")).click();
		Thread.sleep(500);
	}

	@And("^User Selects GPS Mount with Garmin Fitment$")
	public void change_gps_mount() throws Exception {
		Thread.sleep(500);
		WebElement gps_mounted = driver.findElement(By.xpath("//div[@data-id='option_id_777925']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", gps_mounted);
		js.executeScript("arguments[0].click()", gps_mounted);
		Thread.sleep(500);
	}

	@And("^User notes to price$")
	public void capture_Price() throws Exception {
		Thread.sleep(500);
		price = driver.findElement(By.xpath("//tr[@class='grand-total']//span")).getText();
		Thread.sleep(500);
	}

	@And("^User Clicks on HomePage$")
	public void navigate_homePage() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@class='header-logo']	")).click();
		Thread.sleep(500);
	}

	@And("^User navigates to Cart from Cart button$")
	public void navigate_cartPage() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='header__top wrap']//div[@class='header-cart']")).click();
		Thread.sleep(500);
	}

	@Then("^The price should remain the same$")
	public void check_price() throws Exception {
		Thread.sleep(500);
		String new_price = driver.findElement(By.xpath("//tr[@class='grand-total']//span")).getText();
		Assert.assertTrue(price.contains(new_price));
		Thread.sleep(500);
	}
	
	@When("^User hover over accessories in nav section$")
	public void parts_hover() throws Exception{
		Thread.sleep(500);
		WebElement road_nav = driver.findElement(By.xpath("//ul[@id='nav']//a[@title='Accessories']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(road_nav);
		actions.build().perform();
		Thread.sleep(500);
	}
	
	@And("^User clicks on Frameset$")
	public void frameset_click() throws Exception{
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[contains(text(),'Framesets ')])")).click();
		Thread.sleep(500);
	}
	
	@And("^User selects Price - Low to High$")
	public void price_sort() throws Exception{
		Thread.sleep(500);
		WebElement sort_select = driver.findElement(By.xpath("//div[@class='category-products']//div[@class='toolbar-top clearfix']//div[@class=\"sorter\"]//div[@class='sort-by']//div[@class='input-box']//select"));
		sort_select.click();
		Select select = new Select(sort_select);
		select.selectByVisibleText("Price: Low to High");
		Thread.sleep(500);
	}
	
	@Then("^The price should be in acscending order$")
	public void check_priceOrder() throws Exception{
		boolean result = false;
		List<WebElement> price_list = driver.findElements(By.xpath("//div[@class='price-box']//span[@class='price notranslate']"));
		for(int i = 0; i < price_list.size(); i++) {
			String price1 = price_list.get(i).getText();
			double x = string_to_num(price1);
			String price2 = price_list.get(i+1).getText();
			double y = string_to_num(price2);
			Assert.assertTrue(y>=x);
		}
	}
	
	public static double string_to_num(String number) {
		double num = 0;
		number = number.substring(1);
		if(number.contains(",")) {
			number.replace(",", "");
		}
		num = Float.parseFloat(number);
		return num;
	}

	@And("^User shuts down the browser$")
	public void terminate_case() throws Exception {
		DriverManager.tearDownDriver();
	}

}
