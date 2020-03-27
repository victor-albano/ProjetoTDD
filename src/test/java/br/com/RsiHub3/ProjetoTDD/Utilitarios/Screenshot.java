package br.com.RsiHub3.ProjetoTDD.Utilitarios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static String tirarPrint(WebDriver driver, String nomePrint) {
		TakesScreenshot tirarPrint = (TakesScreenshot) driver;
		File src = tirarPrint.getScreenshotAs(OutputType.FILE);
		String caminhoDoArquivo = System.getProperty("user.dir") + "/Screenshot/" + nomePrint + ".png";
		
		File destino = new File(caminhoDoArquivo);

		try {
			FileUtils.copyFile(src, destino);
		} catch (IOException e) {
			System.out.println(" O print falhou " + e.getMessage());
		}

		return caminhoDoArquivo;
}
}
