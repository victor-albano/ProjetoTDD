package br.com.RsiHub3.ProjetoTDD.Suporte;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GerenciandoChrome {

	private static WebDriver driver;
	
	public static WebDriver AbrirPaginaInicial (String link) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeWebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(link);
		return driver;
	}
	
	public static void FecharChrome () {
		driver.quit();
	}
}
