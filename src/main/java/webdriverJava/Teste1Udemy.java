package webdriverJava;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Teste1Udemy {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/victor.albano/eclipse-workspace/webdriverJava/chromedriver.exe");
		
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		driver.get("http://www.juliodelima.com.br/taskit/");
		
		driver.findElement(By.linkText("Sign in")).click();
		
		WebElement formularioSignInBox = driver.findElement(By.id("signinbox"));
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		
		driver.findElement(By.linkText("SIGN IN")).click();
		
		driver.findElement(By.className("me")).click();;
		
		driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}
	
	@Test
	public void testLoginTaskIt() {
		
		driver.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		WebElement popupAddMoreData = driver.findElement(By.id("addmoredata"));
		
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");
		
		popupAddMoreData.findElement(By.name("contact")).sendKeys("11987654321");
		
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		
		WebElement mensagemPop = driver.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		
		assertEquals("Your contact has been added!", mensagem);
		
	}
	//@Test
	public void removerUmContatoDeUmUsuario () {
		
		//Clicar no elemento pelo seu xpath span[text()="37463782"]/following-sibling::a
		driver.findElement(By.xpath("//span[text()=\"+5551984003422\"]/following-sibling::a")).click();
		//Confirmar a janela javascript
		driver.switchTo().alert().accept();
		//Validar que a mensagem apresentada foi Rest in peace, dear phone!
		WebElement mensagemPop = driver.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);
		
//		Screenshot.tirar(driver, "C:\\Users\\victor.albano\\Documents\\Victor\\TesteAutomatizado\\Screenshots\\" + Generator.dataHoraParaArquivo() + "removerUmContatoDeUmUsuario.png");
		//Aguardar ate 10 segundos para que a janela desapareça
		WebDriverWait aguardar = new WebDriverWait(driver, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		//Clicar no link com texto "Logout"
		driver.findElement(By.linkText("Logout")).click();
	}

	
	@After
	public void tearDown() {
		//driver.quit();
	}
}
