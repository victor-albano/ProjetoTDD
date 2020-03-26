package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.RsiHub3.ProjetoTDD.Utilitarios.ExtentReport;
import br.com.RsiHub3.ProjetoTDD.Utilitarios.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TestePesquisaTelaInicial {
	
	private WebDriver driver;
	private ExtentTest test;
	private String nomeDoTeste;
	
	@BeforeSuite
	public void setUpReport () {
		ExtentReport.configurandoReport("PesquisaTelaInicial");
	}
	
	@BeforeMethod
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void PesquisaPelaTelaInicialCOMSucesso () {
		nomeDoTeste = "Cenario POSITIVO";
		String mensagemValidacao = new PaginaInicial(driver).pesquisaTelaInicialMouse().selecionandoMouseEValidando();
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", mensagemValidacao);
	}
	
	@Test
	public void PesquisaPelaTelaInicialSEMSucesso () {
		nomeDoTeste = "Cenario NEGATIVO";
		assertFalse(new PaginaInicial(driver).pesquisaListaTelaInicial(new PaginaInicial(driver).listaProdutosTelaInicial(), "TV"));
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
