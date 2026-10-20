package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.FileUploadUtility;
import Utility.PageUtility;
import constants.Constant;

public class SubCategory {
	public WebDriver driver;

	public SubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "cat_id")
	WebElement categoryDropDown;
	@FindBy(id = "subcategory")
	WebElement subCategoryfield;
	@FindBy(id = "main_img")
	WebElement imageChoose;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertSaveSuccess;

	public SubCategory createNewCategory() {
		newButton.click();
		return this;
	}

	public SubCategory Selcategory() {
		categoryDropDown.click();
		PageUtility page = new PageUtility();
		page.selectByIndex(categoryDropDown, 2);
		return this;

	}

	public SubCategory enterdataSubcategory(String subcategory1) {

		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", subCategoryfield);

		subCategoryfield.sendKeys(subcategory1);
		return this;
	}

	public SubCategory subcategoryclick() {
		imageChoose.click();
		return this;
	}

	public SubCategory uploadimage() throws AWTException {
		String image2 = Constant.SUBCATEGORYIMAGEPATH;

		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0,1000)");
		FileUploadUtility image = new FileUploadUtility();
		image.sendKeysProfileUpload(imageChoose, image2);
		return this;
	}

	public SubCategory savedetails() {

		saveButton.click();
		return this;
	}

	public boolean isSavesuccess() {
		return alertSaveSuccess.isDisplayed();
	}

}
