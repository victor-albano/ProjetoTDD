package br.com.RsiHub3.ProjetoTDD.Utilitarios;

import org.openqa.selenium.By;

import br.com.RsiHub3.ProjetoWebTDD.Pages.PaginaInicial;

public class ExtraindoDadosExcel {

	public String getUserNameCorreto () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 0);
	}
	
	public String getSenha () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 1);
	}
	
	public String getEmailCorreto () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 2);
	}
	
	public String getFirstName () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 3);
	}
	
	public String getLastName () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 4);
	}
	
	public String getPhoneNumber () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 5);
	}
	
	public String getCountry () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 6);
	}
	
	public String getCity () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 7);
	}
	
	public String getAdress () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 8);
	}
	
	public String getState () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 9);
	}
	
	public String getCep () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(1, 10);
	}
	
	public String getUserNameErrado () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(2, 0);
	}
	
	public String getEmailErrado () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Cadastro");
		return ExcelUtils.getCellData(2, 2);
	}
	
	public String getUsuarioValidoExcel () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Login");
		return ExcelUtils.getCellData(1, 0);
	}
	
	public String getSenhaValidaExcel () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Login");
		return ExcelUtils.getCellData(1, 1);	
	}
	
	public String getUsuarioInvalidoExcel () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Login");
		return ExcelUtils.getCellData(2, 0);
	}
	
	public String getSenhaInvalidaExcel () throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData , "Login");
		return ExcelUtils.getCellData(2, 1);	
	}
}
