package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TesteLoginNG {
	
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
	public void TesteLoginSEMSucesso () throws Exception {
		assertEquals("Incorrect user name or password.", new PaginaInicial(driver).preencherLogin(2, 2).esperarPorMensagemDeValidacao());
	}
	
	@Test
	public void LoginCOMSucesso () throws Exception {
		assertEquals("Roger", new PaginaInicial(driver).preencherLogin(1, 1).validacaoLoginEfetuado());
	}
}
