package br.com.RsiHub3.ProjetoTDD.Utilitarios;


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

public class DriverFactory {

	private static WebDriver driver;
	
	public static WebDriver abrirChrome (String link) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeWebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(link);
		return driver;
	}
	
	public static void fecharChrome () {
			driver.quit();
	}
}