package br.com.locadoraferraz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.Cleanup;

public class ExcelPoiUtils {
     public static List<Row> excelToListrow(File excelFile) throws FileNotFoundException, IOException {
    	 @Cleanup FileInputStream file = new FileInputStream(excelFile);
    	 @Cleanup Workbook workbook = new HSSFWorkbook(file);
    	 Sheet sheet = workbook.getSheetAt(0);
    	 return (List<Row>) ListUtils.toList(sheet.iterator());
     }
     
     public static List<Row> excelToListrow(String pathFile) throws FileNotFoundException, IOException {
    	 return excelToListrow(new File(pathFile));
     }
     
     public static void testeCriaArquivoExcel(List<?> listaObjetos) throws FileNotFoundException, IOException {
    	 if(!listaObjetos.isEmpty()) {
    	 String fileName = "/src/main/resources/teste.xlsx";
    	 Class<?> classeObj = listaObjetos.get(0).getClass();
    	 
    	 @Cleanup FileInputStream file = new FileInputStream(fileName);
    	 @Cleanup XSSFWorkbook workbook = new XSSFWorkbook(file);
    	 XSSFSheet planilha = workbook.createSheet("planilha"+classeObj.getSimpleName());
    	 
    	 int nrLinha = 0;
    	 
    	 adicionaCabecalho(classeObj, planilha, nrLinha);
    	 }
    	 
     }
     
     private static void adicionaCabecalho(Class<?> classe, XSSFSheet planilha, int nrLinha) {
    	 XSSFRow linha = planilha.createRow(nrLinha);
    	 //Collections.addAll(null, null)
     }
     
     private static void adicionaCelula(Row linha, int coluna, String valor) {
    	 Cell cell = linha.createCell(coluna);
    	 cell.setCellValue(valor);
     }
     
     private static void adicionaCelula(Row linha, int coluna, int valor) {
    	 Cell cell = linha.createCell(coluna);
    	 cell.setCellValue(valor);
     }
}
