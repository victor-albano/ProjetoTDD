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

import br.com.RsiHub3.ProjetoTDD.Excel.Constant;
import br.com.RsiHub3.ProjetoTDD.Excel.ExcelUtils;

public class PaginaInicial extends BasePage{

	public PaginaInicial(WebDriver driver) {
		super(driver);
	}
	
	public PaginaInicial PreencherLogin (int linha , int linhaSenha) throws Exception {
		ClicarJanelaDeLogin();
		pegarUsuarioExcel(linha);
		pegarSenhaExcel(linhaSenha);
		ClicarSignIn();
		return this;
	}
	
	public String EsperarPorMensagemDeValidacao () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password."));
		return driver.findElement(By.id("signInResultMessage")).getText();
	}
	
	public PaginaPesquisaMouse PesquisaLupaMouse (String mouse) {
		ClicarLupa();
		DigitarPesquisa(mouse);
		ClicarEnterNaPesquisa();
		new PaginaPesquisaMouse(driver).ClicarNoProduto();
		return new PaginaPesquisaMouse (driver);
	}
	

	public PaginaPesquisaMouse PesquisaTelaInicialMouse () {
		ClicarNoIconeMouseTelaInicial();
		return new PaginaPesquisaMouse(driver);
	}
	
	
	public String ValidacaoLoginEfetuado () {
		return driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).getText();
	}
	
	
	public PaginaDeCadastro ClicarCreateNewAccount () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(20000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"))));
		ClicarBotaoCreateNewAccount();
		return new PaginaDeCadastro (driver);
	}
	
	
	//Estrutural
	
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
	
	public PaginaInicial ClicarJanelaDeLogin () {
		driver.findElement(By.id("menuUser")).click();
		return this;
	}
	
	public PaginaInicial ClicarSignIn () {
		driver.findElement(By.id("sign_in_btnundefined")).click();
		return this;
	}
	
	public PaginaInicial ClicarLupa () {
		driver.findElement(By.id("menuSearch")).click();
		return this;
	}
	
	public PaginaInicial DigitarPesquisa (String mouse) {
		driver.findElement(By.id("autoComplete")).sendKeys(mouse);
		return this;
	}
	
	public PaginaPesquisaMouse ClicarEnterNaPesquisa () {
		driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);
		return new PaginaPesquisaMouse(driver);
	}
	
	public PaginaPesquisaMouse ClicarNoIconeMouseTelaInicial () {
		driver.findElement(By.id("miceTxt")).click();
		return new PaginaPesquisaMouse(driver);
	}
	
	public PaginaDeCadastro ClicarBotaoCreateNewAccount () {
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();
//		Actions actions = new Actions(driver);
//		actions.click(driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"))).click().perform();
		return new PaginaDeCadastro(driver);
	}
	
	public PaginaInicial pegarUsuarioExcel (int linha) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Planilha1");
		//ExcelUtils.getCellData(linha, 0);
		driver.findElement(By.name("username")).sendKeys(ExcelUtils.getCellData(linha, 0));
		return this;
	}
	
	public PaginaInicial pegarSenhaExcel (int linhaSenha ) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Planilha1");
		driver.findElement(By.name("password")).sendKeys(ExcelUtils.getCellData(linhaSenha, 1));
		return this;
	}
}
