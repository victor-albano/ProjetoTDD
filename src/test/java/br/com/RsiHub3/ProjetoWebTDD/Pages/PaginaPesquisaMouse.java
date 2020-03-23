package br.com.RsiHub3.ProjetoWebTDD.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaPesquisaMouse extends BasePage {
	
	public PaginaPesquisaMouse(WebDriver driver) {
		super(driver);
	}

	public String SelecionandoMouseEValidando () {
		driver.findElement(By.xpath("//a[contains(text(),'HP USB 3 Button Optical Mouse')]")).click();
		return driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']")).getText();
	}
	
	public String MensagemProdutoNaoEncontrado () {
		return driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")).getText();
	}
	
	public PaginaPesquisaMouse ClicarNoProduto() {
		driver.findElement(By.xpath("//div[@class='autoCompleteCover']//div//img")).click();
		return this;
	}
}
