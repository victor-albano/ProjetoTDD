package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.RsiHub3.ProjetoTDD.Report.ExtentReport;
import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TesteLogin {
	private WebDriver driver;
	private ExtentTest test;
	
	@BeforeTest
	public void setUpReport () {
		ExtentReport.configurandoReport();
	}
	
	@BeforeMethod
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	
	@Test
	public void TesteLoginSEMSucesso () throws Exception{
		AssertJUnit.assertEquals("Incorrect user name or password.", new PaginaInicial(driver).preencherLogin(2, 2).esperarPorMensagemDeValidacao());
		test = ExtentReport.IniciandoReportTeste("TesteLoginSEMSucesso");
	}
	
	@Test
	public void LoginCOMSucesso () throws Exception {
		AssertJUnit.assertEquals("Roger", new PaginaInicial(driver).preencherLogin(1, 1).validacaoLoginEfetuado());
		test = ExtentReport.IniciandoReportTeste("TesteLoginCOMSucesso");
	}
	
	@AfterMethod
	public void tearDown (ITestResult result) throws IOException {
		ExtentReport.relatorioDeTestes(test, result, driver);
		GerenciandoChrome.fecharChrome();
	}
	
	@AfterTest
	public void tearDownReport () {
		ExtentReport.fecharReport();
	}
}
