package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExtentReport;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaDeCadastro;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TesteCadastro {
  
	private WebDriver driver;
	private ExtentTest test;
	private String nomeDoTeste;
	
	@BeforeSuite
	public void setUpReport () {
		ExtentReport.configurandoReport("Cadastro");
	}
	
	@BeforeMethod
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void PreencherCadastroCOMSucesso () throws Exception {
		nomeDoTeste = "Cenario POSITIVO";
		new PaginaInicial(driver).clicarJanelaDeLogin().clicarCreateNewAccount().fazerCadastro();
		assertEquals("VictorAlbanoV17", new PaginaInicial(driver).validacaoLoginEfetuado());
	}
	
	@Test
	public void PreencherCadastroSEMSucesso () throws Exception {
		nomeDoTeste = "Cenario NEGATIVO";
		new PaginaInicial(driver).clicarJanelaDeLogin().clicarCreateNewAccount().fazerCadastroSemSucesso();
		assertEquals("User name already exists", new PaginaDeCadastro(driver).mensagemCadastroSemSucesso());
	}
	
	@AfterMethod
	public void tearDown (ITestResult result) throws IOException {
		test = ExtentReport.IniciandoReportTeste(nomeDoTeste);
		ExtentReport.relatorioDeTestes(test, result, driver);
		GerenciandoChrome.fecharChrome();
	}
	
	@AfterSuite
	public void tearDownReport () {
		ExtentReport.fecharReport();
	}
}
