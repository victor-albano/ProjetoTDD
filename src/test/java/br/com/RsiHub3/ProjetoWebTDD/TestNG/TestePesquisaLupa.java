package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaPesquisaMouse;

public class TestePesquisaLupa {
	
	private WebDriver driver;
	private ExtentTest test;
	private String nomeDoTeste;
	
	@BeforeSuite
	public void setUpReport () {
		ExtentReport.configurandoReport("PesquisaLupa");
	}
	
	@BeforeMethod
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void PesquisaLupaCOMSucesso () {
		nomeDoTeste = "Cenario POSITIVO";
		String mensagemValidacao = new PaginaInicial(driver).pesquisaLupaMouse("Mouse").selecionandoMouseEValidando();
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", mensagemValidacao);
	}
	
	@Test
	public void PesquisaLupaSEMSucesso () {
		nomeDoTeste = "Cenario NEGATIVO";
		String mensagemValidacao = new PaginaInicial(driver).pesquisaLupaMouse("Produto").mensagemProdutoNaoEncontrado();
		new PaginaPesquisaMouse(driver).EsperaParaPrint();
		assertEquals("No results for \"Produto\"", mensagemValidacao);
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
