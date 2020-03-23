package br.com.RsiHub3.ProjetoWebTDD.Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TestePesquisaTelaInicial {

private WebDriver driver;
	
	@Before
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@After
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
