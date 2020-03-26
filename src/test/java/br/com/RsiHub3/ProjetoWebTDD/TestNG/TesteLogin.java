package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.RsiHub3.ProjetoTDD.Report.ExtentReport;
import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TesteLogin {
	private WebDriver driver;
	private ExtentTest test;
	private String nomeDoTeste;
	
	@BeforeSuite
	public void setUpReport () {
		ExtentReport.configurandoReport("Login");
	}
	
	@BeforeMethod
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void TesteLoginSEMSucesso () throws Exception{
		nomeDoTeste = "Cenario NEGATIVO";
		String mensagem = new PaginaInicial(driver).preencherLogin(2, 2).esperarPorMensagemDeValidacao();
		assertEquals("Incorrect user name or password.", mensagem);
	}
	
	@Test
	public void LoginCOMSucesso () throws Exception {
		nomeDoTeste = "Cenario POSITIVO";
		String mensagem = new PaginaInicial(driver).preencherLogin(1, 1).validacaoLoginEfetuado();
		assertEquals("Roger", mensagem);
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
