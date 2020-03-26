package br.com.RsiHub3.ProjetoWebTDD.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import br.com.RsiHub3.ProjetoTDD.Utilitarios.Constant;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExcelUtils;

public class PaginaDeCadastro extends BasePage{

	public PaginaDeCadastro(WebDriver driver) {
		super(driver);
	}
	
	//Funcional
	public PaginaInicial fazerCadastro () throws Exception {
		digitarUserName(getUserNameCorreto());
		digitarPasswordEConfirmacao(getSenha());
		digitarEmail(getEmailCorreto());
		digitarPrimeiroNome(getFirstName());
		digitarSobrenome(getLastName());
		digitarTelefone(getPhoneNumber());
		selecionarComboBox();
		digitarCidade(getCity());
		digitarEndereco(getAdress());
		digitarEstado(getState());
		digitarCep(getCep());
		aceitarTermosDeUso();
		confirmarCadastro();
		return new PaginaInicial(driver);
	}
	
	public PaginaDeCadastro fazerCadastroSemSucesso () throws Exception {
		digitarUserName(getUserNamErrado());
		digitarPasswordEConfirmacao(getSenha());
		digitarEmail(getEmailErrado());
		digitarPrimeiroNome(getFirstName());
		digitarSobrenome(getLastName());
		digitarTelefone(getPhoneNumber());
		selecionarComboBox();
		digitarCidade(getCity());
		digitarEndereco(getAdress());
		digitarEstado(getState());
		digitarCep(getCep());
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
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys(sobrenome);
		return this;
	}
	
	private PaginaDeCadastro digitarTelefone (String telefone) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(telefone);
		return this;
	}
	
	private PaginaDeCadastro selecionarComboBox () throws Exception {
		String pais = getCountry();
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
	
	private String getUserNameCorreto () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 0);
	}
	
	private String getSenha () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 1);
	}
	
	private String getEmailCorreto () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 2);
	}
	
	private String getFirstName () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 3);
	}
	
	private String getLastName () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 4);
	}
	
	private String getPhoneNumber () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 5);
	}
	
	private String getCountry () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 6);
	}
	
	private String getCity () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 7);
	}
	
	private String getAdress () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 8);
	}
	
	private String getState () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 9);
	}
	
	private String getCep () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 10);
	}
	
	private String getUserNamErrado () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(2, 0);
	}
	
	private String getEmailErrado () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(2, 2);
	}
	
	
	

}
