package br.com.RsiHub3.ProjetoWebTDD.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExtraindoDadosExcel;

public class PaginaDeCadastro extends BasePage {

	public PaginaDeCadastro(WebDriver driver) {
		super(driver);
	}
	ExtraindoDadosExcel excel = new ExtraindoDadosExcel();
	
	public PaginaDeCadastro digitarUserName (String username) {
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(username);
		return this;
	}
	
	public PaginaDeCadastro digitarPasswordEConfirmacao (String password) {
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(password);
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(password);
		return this;
	}
	
	public PaginaDeCadastro digitarEmail (String email) {
		driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
		return this;
	}
	
	public PaginaDeCadastro digitarPrimeiroNome (String nome) {
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(nome);
		return this;
	}
	
	public PaginaDeCadastro digitarSobrenome (String sobrenome) {
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys(sobrenome);
		return this;
	}
	
	public PaginaDeCadastro digitarTelefone (String telefone) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(telefone);
		return this;
	}
	
	public PaginaDeCadastro selecionarComboBox () throws Exception {
		String pais = excel.getCountry();
		new Select(driver.findElement(By.name("countryListboxRegisterPage"))).selectByVisibleText(pais);
		return this;
	}
	
	public PaginaDeCadastro digitarCidade (String cidade) {
		driver.findElement(By.name("cityRegisterPage")).sendKeys(cidade);
		return this;
	}
	
	public PaginaDeCadastro digitarEndereco (String endereco) {
		driver.findElement(By.name("addressRegisterPage")).sendKeys(endereco);
		return this;
	}
	
	public PaginaDeCadastro digitarEstado (String estado) {
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(estado);
		return this;
	}
	
	public PaginaDeCadastro digitarCep (String cep) {
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(cep);
		return this;
	}
	
	public PaginaDeCadastro aceitarTermosDeUso () {
		driver.findElement(By.name("i_agree")).click();
		return this;
	}
	
	public PaginaInicial confirmarCadastro () {
		driver.findElement(By.id("register_btnundefined")).click();
		return new PaginaInicial(driver);
	}
	
	public String mensagemCadastroSemSucesso () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(50, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement validacao = driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "User name already exists"));
		return driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]")).getText();
	}
}
