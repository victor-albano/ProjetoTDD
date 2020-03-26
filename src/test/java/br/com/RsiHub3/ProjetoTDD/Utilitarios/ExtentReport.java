package br.com.RsiHub3.ProjetoTDD.Utilitarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void configurandoReport(String nomeDoReport) {
		
		htmlReporter = new ExtentHtmlReporter("src/test/resources/Report/" + nomeDoReport + ".html");
		
		htmlReporter.config().setDocumentTitle("Report");
		htmlReporter.config().setReportName("Report");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
	}
	
	public static ExtentTest IniciandoReportTeste(String nomeTeste) {
		test = extent.createTest(nomeTeste);
		return test;
	}
	
	public static void relatorioDeTestes (ExtentTest teste, ITestResult result, WebDriver driver) throws IOException {
		test.addScreenCaptureFromPath(Screenshot.tirarPrint(driver, result.getName()));
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Caso de teste FALHOU: " + result.getName());
			test.log(Status.FAIL, "Caso de teste FALHOU: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste SKIPPED: " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Caso de teste PASSOU: " + result.getName());
		}
	}
	
	public static void fecharReport () {
		extent.flush();
	}
}
