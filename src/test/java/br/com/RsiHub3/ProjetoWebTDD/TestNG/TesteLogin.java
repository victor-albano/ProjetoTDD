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

import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExtentReport;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExtraindoDadosExcel;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.DriverFactory;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.SmartWaits;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TesteLogin {
	
	private WebDriver driver;
	private ExtentTest test;
	private String nomeDoTeste;
	private ExtraindoDadosExcel excel = new ExtraindoDadosExcel();
	
	@BeforeSuite
	public void setUpReport () {
		ExtentReport.configurandoReport("Login");
	}
	
	@BeforeMethod
	public void SetUp () {
		driver = DriverFactory.abrirChrome("http://advantageonlineshopping.com/#/");
		new SmartWaits(driver).esperarPaginaCarregar();
	}
	
	@Test
	public void TesteLoginSEMSucesso () throws Exception{
		nomeDoTeste = "Cenario NEGATIVO";
			String mensagem = new PaginaInicial(driver)
			.clicarJanelaDeLogin()
			.digitarLogin(excel.getUsuarioInvalidoExcel())
			.digitarSenha(excel.getSenhaInvalidaExcel())
			.clicarSignIn()
			.esperarPorMensagemDeValidacao();
		assertEquals("Incorrect user name or password.", mensagem);
	}
	
	@Test
	public void LoginCOMSucesso () throws Exception {
		nomeDoTeste = "Cenario POSITIVO";
		String mensagem = new PaginaInicial(driver)
			.clicarJanelaDeLogin()
			.digitarLogin(excel.getUsuarioValidoExcel())
			.digitarSenha(excel.getSenhaValidaExcel())
			.clicarSignIn()
			.validacaoLoginEfetuado();
		assertEquals("Victor", mensagem);
	}
	
	@AfterMethod
	public void tearDown (ITestResult result) throws IOException {
		test = ExtentReport.IniciandoReportTeste(nomeDoTeste);
		ExtentReport.relatorioDeTestes(test, result, driver);
		DriverFactory.fecharChrome();
	}
	
	@AfterSuite
	public void tearDownReport () {
		ExtentReport.fecharReport();
	}
}
