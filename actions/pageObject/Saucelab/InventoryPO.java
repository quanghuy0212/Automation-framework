package pageObject.Saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.InventoryPageUI;

public class InventoryPO extends BasePage {
	WebDriver driver;

	public InventoryPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String itemText) {
		waitForElementCLickable(driver, InventoryPageUI.SORT_DROPDOWN);
		selectDropdownByText(driver, InventoryPageUI.SORT_DROPDOWN, itemText);
	}

	public boolean isProductNameSortAscending() {
		List<WebElement> productsNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productsNameElements) {
			productNameText.add(productName.getText());

		}
		
		System.out.println("Before sort:------------");
		for (String product : productNameText) {
			System.out.println(product);
			
		}
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		for (String product : productNameTextClone) {
			System.out.println(product);
		}
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productsNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productsNameElements) {
			productNameText.add(productName.getText());

		}
		
		System.out.println("Before sort:------------");
		for (String product : productNameText) {
			System.out.println(product);
			
		}
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}
	
	public boolean isProductPriceSortAscending() {
		List<WebElement> productsPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		List<Float> productNamePrice = new ArrayList<Float>();
		for (WebElement productPrice : productsPriceElements) {
			productNamePrice.add(Float.parseFloat(productPrice.getText().replace("$","")));

		}
		
		System.out.println("Before sort:------------");
		for (Float productPrice : productNamePrice) {
			System.out.println(productPrice);
			
		}
		List<Float> productPriceTextClone = new ArrayList<Float>(productNamePrice);
		Collections.sort(productPriceTextClone);
		for (Float productPrice : productPriceTextClone) {
			System.out.println(productPrice);
		}
		return productNamePrice.equals(productPriceTextClone);
	}
	
	public boolean isProductPriceSortDecsending() {
		List<WebElement> productsPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		List<Float> productNamePrice = new ArrayList<Float>();
		for (WebElement productPrice : productsPriceElements) {
			productNamePrice.add(Float.parseFloat(productPrice.getText().replace("$","")));

		}
		
		System.out.println("Before sort:------------");
		for (Float productPrice : productNamePrice) {
			System.out.println(productPrice);
			
		}
		List<Float> productPriceTextClone = new ArrayList<Float>(productNamePrice);
		Collections.sort(productPriceTextClone);
		Collections.reverse(productPriceTextClone);
		for (Float productPrice : productPriceTextClone) {
			System.out.println(productPrice);
		}
		return productNamePrice.equals(productPriceTextClone);
	}
}
