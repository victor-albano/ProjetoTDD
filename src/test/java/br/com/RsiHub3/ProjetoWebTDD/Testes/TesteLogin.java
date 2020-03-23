package br.com.RsiHub3.ProjetoWebTDD.Testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TesteLogin {

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
	public void TesteLoginSEMSucesso () throws Exception {
		assertEquals("Incorrect user name or password.", new PaginaInicial(driver).preencherLogin(2, 2).esperarPorMensagemDeValidacao());
	}
	
	@Test
	public void LoginCOMSucesso () throws Exception {
		assertEquals("Roger", new PaginaInicial(driver).preencherLogin(1, 1).validacaoLoginEfetuado());
	}
}
