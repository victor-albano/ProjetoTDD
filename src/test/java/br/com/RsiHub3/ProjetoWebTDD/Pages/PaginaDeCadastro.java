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
	public PaginaInicial FazerCadastro (String username, String password, String email, String nome, String sobrenome,
			String telefone, String pais, String cidade, String endereco, String estado, String cep ) {
		DigitarUserName(username);
		DigitarPasswordEConfirmacao(password);
		DigitarEmail(email);
		DigitarPrimeiroNome(nome);
		DigitarSobrenome(sobrenome);
		DigitarTelefone(telefone);
		SelecionarComboBox(pais);
		DigitarCidade(cidade);
		DigitarEndereco(endereco);
		DigitarEstado(estado);
		DigitarCep(cep);
		AceitarTermosDeUso();
		ConfirmarCadastro();
		return new PaginaInicial(driver);
	}
	
	public PaginaDeCadastro FazerCadastroSemSucesso (String username, String password, String email, String nome, String sobrenome,
			String telefone, String pais, String cidade, String endereco, String estado, String cep ) {
		DigitarUserName(username);
		DigitarPasswordEConfirmacao(password);
		DigitarEmail(email);
		DigitarPrimeiroNome(nome);
		DigitarSobrenome(sobrenome);
		DigitarTelefone(telefone);
		SelecionarComboBox(pais);
		DigitarCidade(cidade);
		DigitarEndereco(endereco);
		DigitarEstado(estado);
		DigitarCep(cep);
		AceitarTermosDeUso();
		ConfirmarCadastro();
		return this;
	}
	
	//Estrutural
	
	public PaginaDeCadastro DigitarUserName (String username) {
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(username);
		return this;
	}
	
	public PaginaDeCadastro DigitarPasswordEConfirmacao (String password) {
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(password);
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(password);
		return this;
	}
	
	public PaginaDeCadastro DigitarEmail (String email) {
		driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
		return this;
	}
	
	public PaginaDeCadastro DigitarPrimeiroNome (String nome) {
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(nome);
		return this;
	}
	
	public PaginaDeCadastro DigitarSobrenome (String sobrenome) {
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Fagundes Vasconcelos");
		return this;
	}
	
	public PaginaDeCadastro DigitarTelefone (String telefone) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11987654321");
		return this;
	}
	
	public PaginaDeCadastro SelecionarComboBox (String pais) {
		new Select(driver.findElement(By.name("countryListboxRegisterPage"))).selectByVisibleText(pais);
		return this;
	}
	
	public PaginaDeCadastro DigitarCidade (String cidade) {
		driver.findElement(By.name("cityRegisterPage")).sendKeys(cidade);
		return this;
	}
	
	public PaginaDeCadastro DigitarEndereco (String endereco) {
		driver.findElement(By.name("addressRegisterPage")).sendKeys(endereco);
		return this;
	}
	
	public PaginaDeCadastro DigitarEstado (String estado) {
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(estado);
		return this;
	}
	
	public PaginaDeCadastro DigitarCep (String cep) {
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(cep);
		return this;
	}
	
	public PaginaDeCadastro AceitarTermosDeUso () {
		driver.findElement(By.name("i_agree")).click();
		return this;
	}
	
	public PaginaInicial ConfirmarCadastro () {
		driver.findElement(By.id("register_btnundefined")).click();
		return new PaginaInicial(driver);
	}
	
	public String MensagemCadastroSemSucesso () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(50, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement validacao = driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "User name already exists"));
		return driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]")).getText();
	}

}
