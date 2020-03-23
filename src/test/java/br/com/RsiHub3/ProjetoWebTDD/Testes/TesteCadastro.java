package br.com.RsiHub3.ProjetoWebTDD.Testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.RsiHub3.ProjetoTDD.Suporte.GerenciandoChrome;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaDeCadastro;
import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class TesteCadastro {
	
	private WebDriver driver;

	@Before
	public void SetUp () {
		driver = GerenciandoChrome.abrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@After
	public void tearDown () {
		GerenciandoChrome.fecharChrome();
	}
		
	//@Test
	public void PreencherCadastroCOMSucesso () throws InterruptedException {
		new PaginaInicial(driver).clicarJanelaDeLogin().clicarCreateNewAccount()
		.fazerCadastro("Victor_v17", "Abc4", "victor_v17@gmail.com", "Victor", "Albano",
				"11916273849", "Brazil", "Santo André", "Rua natal", "SP", "09030000");
		assertEquals("Victor_v17", new PaginaInicial(driver).validacaoLoginEfetuado());
	}
	
	@Test
	public void PreencherCadastroSEMSucesso () {
		new PaginaInicial(driver).clicarJanelaDeLogin().clicarCreateNewAccount()
		.fazerCadastroSemSucesso("rodrigo", "Abc4", "rodrigo1@gmail.com", "Rodrigo", "Morais",
				"11990909898", "Brazil", "Santo André", "Rua natal", "SP", "09030000");
		assertEquals("User name already exists", new PaginaDeCadastro(driver).mensagemCadastroSemSucesso());
	}
}
