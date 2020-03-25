package br.com.RsiHub3.ProjetoWebTDD.TestNG;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaDeCadastro;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TestCadastroNG {
  
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
	public void PreencherCadastroCOMSucesso () throws InterruptedException {
		new PaginaInicial(driver).clicarJanelaDeLogin().clicarCreateNewAccount()
		.fazerCadastro("VictorV17", "Abc4", "victorV17@gmail.com", "Victor", "Albano",
				"11953459777", "Brazil", "Santo André", "Rua natal", "SP", "09030000");
		assertEquals("VictorV17", new PaginaInicial(driver).validacaoLoginEfetuado());
	}
	
	@Test
	public void PreencherCadastroSEMSucesso () {
		new PaginaInicial(driver).clicarJanelaDeLogin().clicarCreateNewAccount()
		.fazerCadastroSemSucesso("rodrigo", "Abc4", "rodrigo1@gmail.com", "Rodrigo", "Morais",
				"11990909898", "Brazil", "Santo André", "Rua natal", "SP", "09030000");
		assertEquals("User name already exists", new PaginaDeCadastro(driver).mensagemCadastroSemSucesso());
	}
	
}
