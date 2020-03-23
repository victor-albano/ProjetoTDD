package webdriverJava;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteToolsQA {

		private WebDriver driver;
		
		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\victor.albano\\Documents\\Victor\\Selenium/chromedriver.exe");
			driver = new ChromeDriver ();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		}
		//@Test
		public void PrimeiroTesteToolsQA() {
			driver.get("http://shop.demoqa.com/");

			assertEquals("http://shop.demoqa.com/", driver.getCurrentUrl());
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getTitle().length());
			System.out.println(driver.getPageSource().length());
		}

		//@Test
		public void SegundoTesteToolsQA () {
		driver.get("https://demoqa.com/automation-practice-form/");
		
		driver.findElement(By.name("firstname")).sendKeys("Victor");
		driver.findElement(By.id("lastname")).sendKeys("Albano");
		driver.findElement(By.id("buttonwithclass")).click();
		
//		driver.findElement(By.partialLinkText("Partial")).click();
		//parei no tools qa find element
				
		}
		
		//@Test
		public void CheckBoxUm () {
			driver.get("https://demoqa.com/automation-practice-form/");
			List<WebElement> list = driver.findElements(By.name("sex"));
			boolean boo = false;
			boo = list.get(0).isSelected();
			if (boo == true) {
				list.get(1).click();
			}else {
				list.get(1).click();
			}
			driver.findElement(By.id("exp-2")).click();
			List<WebElement> segundaLista = driver.findElements(By.name("profession"));
			int iSize = segundaLista.size();
			for (int i = 0 ; i < iSize ; i++) {
				String valor = segundaLista.get(i).getAttribute("value");
				if (valor.equalsIgnoreCase("Automation Tester")) {
					segundaLista.get(i).click();
					break;
				}
			}
			driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
		}
		
		//@Test
		public void DropDownEMultipleSelect () {
			//Primeiro teste
			driver.get("https://demoqa.com/automation-practice-form/");
			driver.findElement(By.id("continents"));
			Select selecao = new Select(driver.findElement(By.id("continents")));
			selecao.selectByIndex(1);
			String resultado = selecao.getOptions().get(1).getText();
			assertEquals("Europe", resultado);
			
			//Segundo teste
			
			Select oSelect = new Select(driver.findElement(By.name("selenium_commands")));
			oSelect.selectByIndex(2);
			oSelect.selectByVisibleText("Wait Commands");
			List<WebElement> lista = oSelect.getOptions();
			int tamanho = lista.size();
			
			for (int i = 0 ; i < tamanho ; i++) {
				System.out.println(oSelect.getOptions().get(i).getText());
			}
			
		}
		//@Test
		public void TesteHTML () {
			//xpath estatico
			driver.get("https://demoqa.com/automation-practice-table/");
//			System.out.println(driver.findElement(By.xpath(
//					"//*[@id=\"content\"]/div[2]/table/tbody/tr[1]/td[2]")).getText());
//			driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr[1]/td[6]/a")).click();
//		
			//xpath dinamico
			int linha = 4;
			int coluna = 1;
			
			System.out.println(driver.findElement
			(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr["
			+ linha +"]/td[" + coluna + "]")).getText());
			
			for (coluna = 1; coluna <= 5 ; coluna++) {
				System.out.println(driver.findElement(By.xpath
						("//*[@id=\"content\"]/div[2]/table/tbody/tr[2]/td[" + coluna + "]")).getText());
			}
		}
		@Test
		public void Wait () {
			driver.get("https://demoqa.com/automation-practice-switch-windows-2/");
			
			driver.findElement(By.id("timingAlert")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
			myAlert.accept();
			
		}
		
		
		//@After
		public void tearDown() {
			driver.quit();				
			
		}
		
		
	}
