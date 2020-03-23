package br.com.RsiHub3.ProjetoWebTDD.Testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TestePesquisaLupa {

private WebDriver driver;
	
	@Before
	public void SetUp () {
		driver = GerenciandoChrome.AbrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@After
	public void tearDown () {
		GerenciandoChrome.FecharChrome();
	}
	
	@Test
	public void PesquisaLupaCOMSucesso () {
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", new PaginaInicial(driver).PesquisaLupaMouse("Mouse").SelecionandoMouseEValidando());
	}
	
	@Test
	public void PesquisaLupaSEMSucesso () {
		assertEquals("No results for \"Produto\"", new PaginaInicial(driver).PesquisaLupaMouse("Produto").MensagemProdutoNaoEncontrado());
	}
}
