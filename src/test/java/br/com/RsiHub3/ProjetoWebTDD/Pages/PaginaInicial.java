package br.com.RsiHub3.ProjetoWebTDD.Pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import br.com.RsiHub3.ProjetoTDD.Utilitarios.Constant;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExcelUtils;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExtraindoDadosExcel;

public class PaginaInicial extends BasePage{

	public PaginaInicial(WebDriver driver) {
		super(driver);
	}
	
	ExtraindoDadosExcel excel = new ExtraindoDadosExcel();
	
	public String validacaoLoginEfetuado () {
		return driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).getText();
	}
	
	public PaginaInicial digitarLogin (String login) {
		driver.findElement(By.name("username")).sendKeys(login);
		return this;
	}
	
	public PaginaInicial digitarSenha (String senha) {
		driver.findElement(By.name("password")).sendKeys(senha);
		return this;
	}
	
	public boolean pesquisaListaTelaInicial (List<WebElement> listaProdutos, String nomeDoProduto) {
		
		for (WebElement webElement : listaProdutos) {
			if (webElement.getText().contains(nomeDoProduto)) {
				return true;
			}
		}
		return false;
	}
	
	public List<WebElement> listaProdutosTelaInicial () {
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='shop_now roboto-bold ng-binding']"));
		return elements;
	}
	
	public PaginaInicial clicarJanelaDeLogin () {
		driver.findElement(By.id("menuUser")).click();
		return this;
	}
	
	public PaginaInicial clicarSignIn () {
		driver.findElement(By.id("sign_in_btnundefined")).click();
		return this;
	}
	
	public PaginaInicial clicarLupa () {
		driver.findElement(By.id("menuSearch")).click();
		return this;
	}
	
	public PaginaInicial pesquisarMouse () {
		driver.findElement(By.id("autoComplete")).sendKeys("Mouse");
		return this;
	}
	
	public PaginaInicial pesquisarProdutoInvalido () {
		driver.findElement(By.id("autoComplete")).sendKeys("Produto");
		return this;
	}
	
	public PaginaPesquisaMouse clicarEnterNaPesquisa () {
		driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);
		return new PaginaPesquisaMouse(driver);
	}
	
	public PaginaPesquisaMouse clicarNoIconeMouseTelaInicial () {
		driver.findElement(By.id("miceTxt")).click();
		return new PaginaPesquisaMouse(driver);
	}
	
	public PaginaDeCadastro clicarCreateNewAccount () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(20000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"))));
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();
		return new PaginaDeCadastro (driver);
	}
	
	public String esperarPorMensagemDeValidacao () {
		clicarSignIn();
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password."));
		return driver.findElement(By.id("signInResultMessage")).getText();
	}
}
