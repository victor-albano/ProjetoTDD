package br.com.RsiHub3.ProjetoWebTDD.Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaDeCadastro;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class Testes {
	
	private WebDriver driver;

	@Before
	public void SetUp () {
		driver = GerenciandoChrome.AbrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void LoginCOMSucesso () throws Exception {
		assertEquals("Roger", new PaginaInicial(driver).PreencherLogin(1, 1).ValidacaoLoginEfetuado());
	}
	
	@Test
	public void TesteLoginSEMSucesso () throws Exception {
		assertEquals("Incorrect user name or password.", new PaginaInicial(driver).PreencherLogin(2, 2).EsperarPorMensagemDeValidacao());
	}
	
	@Test
	public void PesquisaLupaCOMSucesso () {
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", new PaginaInicial(driver).PesquisaLupaMouse("Mouse").SelecionandoMouseEValidando());
	}
	
	@Test
	public void PesquisaLupaSEMSucesso () {
		assertEquals("No results for \"Produto\"", new PaginaInicial(driver).PesquisaLupaMouse("Produto").MensagemProdutoNaoEncontrado());
	}
	
	@Test
	public void PesquisaPelaTelaInicialCOMSucesso () {
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", new PaginaInicial(driver).PesquisaTelaInicialMouse().SelecionandoMouseEValidando());
	}
	
	@Test
	public void PesquisaPelaTelaInicialSEMSucesso () {
		assertFalse(new PaginaInicial(driver).pesquisaListaTelaInicial(new PaginaInicial(driver).listaProdutosTelaInicial(), "TV"));
	}
	
	//@Test
	public void PreencherCadastroCOMSucesso () throws InterruptedException {
		new PaginaInicial(driver).ClicarJanelaDeLogin().ClicarCreateNewAccount()
		.FazerCadastro("Victor_v17", "Abc4", "victor.v17@gmail.com", "Victor", "Albano",
				"11995654321", "Brazil", "Santo André", "Rua natal", "SP", "09030000");
		assertEquals("Victor_v17", new PaginaInicial(driver).ValidacaoLoginEfetuado());
	}
	
	@Test
	public void PreencherCadastroSEMSucesso () {
		new PaginaInicial(driver).ClicarJanelaDeLogin().ClicarCreateNewAccount()
		.FazerCadastroSemSucesso("rodrigo", "Abc4", "rodrigo1@gmail.com", "Rodrigo", "Morais",
				"11990909898", "Brazil", "Santo André", "Rua natal", "SP", "09030000");
		assertEquals("User name already exists", new PaginaDeCadastro(driver).MensagemCadastroSemSucesso());
	}
	
	@After
	public void tearDown () {
		GerenciandoChrome.FecharChrome();
	}
}
