package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TestePesquisaTelaInicialNG {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@AfterMethod
	public void tearDown () {
		GerenciandoChrome.fecharChrome();
	}
	
	@Test
	public void PesquisaPelaTelaInicialCOMSucesso () {
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", new PaginaInicial(driver).pesquisaTelaInicialMouse().selecionandoMouseEValidando());
	}
	
	@Test
	public void PesquisaPelaTelaInicialSEMSucesso () {
		assertFalse(new PaginaInicial(driver).pesquisaListaTelaInicial(new PaginaInicial(driver).listaProdutosTelaInicial(), "TV"));
	}
}
