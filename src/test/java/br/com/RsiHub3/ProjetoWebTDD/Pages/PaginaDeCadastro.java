package br.com.RsiHub3.ProjetoWebTDD.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PaginaDeCadastro extends BasePage{

	public PaginaDeCadastro(WebDriver driver) {
		super(driver);
	}
	
	//Funcional
	public PaginaInicial fazerCadastro (String username, String password, String email, String nome, String sobrenome,
			String telefone, String pais, String cidade, String endereco, String estado, String cep ) {
		digitarUserName(username);
		digitarPasswordEConfirmacao(password);
		digitarEmail(email);
		digitarPrimeiroNome(nome);
		digitarSobrenome(sobrenome);
		digitarTelefone(telefone);
		selecionarComboBox(pais);
		digitarCidade(cidade);
		digitarEndereco(endereco);
		digitarEstado(estado);
		digitarCep(cep);
		aceitarTermosDeUso();
		confirmarCadastro();
		return new PaginaInicial(driver);
	}
	
	public PaginaDeCadastro fazerCadastroSemSucesso (String username, String password, String email, String nome, String sobrenome,
			String telefone, String pais, String cidade, String endereco, String estado, String cep ) {
		digitarUserName(username);
		digitarPasswordEConfirmacao(password);
		digitarEmail(email);
		digitarPrimeiroNome(nome);
		digitarSobrenome(sobrenome);
		digitarTelefone(telefone);
		selecionarComboBox(pais);
		digitarCidade(cidade);
		digitarEndereco(endereco);
		digitarEstado(estado);
		digitarCep(cep);
		aceitarTermosDeUso();
		confirmarCadastro();
		return this;
	}
	
	//Estrutural
	
	private PaginaDeCadastro digitarUserName (String username) {
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(username);
		return this;
	}
	
	private PaginaDeCadastro digitarPasswordEConfirmacao (String password) {
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(password);
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(password);
		return this;
	}
	
	private PaginaDeCadastro digitarEmail (String email) {
		driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
		return this;
	}
	
	private PaginaDeCadastro digitarPrimeiroNome (String nome) {
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(nome);
		return this;
	}
	
	private PaginaDeCadastro digitarSobrenome (String sobrenome) {
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Fagundes Vasconcelos");
		return this;
	}
	
	private PaginaDeCadastro digitarTelefone (String telefone) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11987654321");
		return this;
	}
	
	private PaginaDeCadastro selecionarComboBox (String pais) {
		new Select(driver.findElement(By.name("countryListboxRegisterPage"))).selectByVisibleText(pais);
		return this;
	}
	
	private PaginaDeCadastro digitarCidade (String cidade) {
		driver.findElement(By.name("cityRegisterPage")).sendKeys(cidade);
		return this;
	}
	
	private PaginaDeCadastro digitarEndereco (String endereco) {
		driver.findElement(By.name("addressRegisterPage")).sendKeys(endereco);
		return this;
	}
	
	private PaginaDeCadastro digitarEstado (String estado) {
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(estado);
		return this;
	}
	
	private PaginaDeCadastro digitarCep (String cep) {
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(cep);
		return this;
	}
	
	private PaginaDeCadastro aceitarTermosDeUso () {
		driver.findElement(By.name("i_agree")).click();
		return this;
	}
	
	private PaginaInicial confirmarCadastro () {
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
