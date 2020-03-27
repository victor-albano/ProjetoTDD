package br.com.RsiHub3.ProjetoTDD.Utilitarios;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class SmartWaits {
	
	private WebDriver driver;
	
	
	public SmartWaits (WebDriver driver) {
		this.driver = driver;
	}
	
	public void esperarPaginaCarregar () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement validacao = driver.findElement(By.id("special_offer_items"));
		wait.until(ExpectedConditions.visibilityOf(validacao));
	}
}
