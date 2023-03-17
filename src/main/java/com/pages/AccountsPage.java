package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageHeader() {
		return driver.findElement(By.xpath("//h1[text()='How much could I borrow?']")).getText();
	}
	
	public WebElement getLabel(String label)
	{
		return driver.findElement(By.xpath("//label[text()='"+label+"']//parent::div//input"));
	}

	
	
	public WebElement getOpt(String label,String op)
	{
		return driver.findElement(By.xpath("//label[contains(text(),'"+label+"')]//parent::div//label[contains(text(),'"+op+"')]"));
	}
	public WebElement getClickButton(String lbl)
	{
		return driver.findElement(By.xpath("//button[contains(text(),'"+lbl+"')]"));
	}
	
	public WebElement getEstimate()
	{
		return driver.findElement(By.id("borrowResultTextAmount"));
	}

}
