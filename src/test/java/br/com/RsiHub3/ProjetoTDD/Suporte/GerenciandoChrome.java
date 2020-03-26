package br.com.RsiHub3.ProjetoTDD.Suporte;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GerenciandoChrome {

	private static WebDriver driver;
	
	public static WebDriver abrirPaginaInicial (String link) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeWebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(link);
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement validacao = driver.findElement(By.id("special_offer_items"));
		wait.until(ExpectedConditions.visibilityOf(validacao));
		return driver;
	}
	
	public static void fecharChrome () {
		driver.quit();
	}
}
