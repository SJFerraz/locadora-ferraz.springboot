package br.com.locadoraferraz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.locadoraferraz.model.testeentity.ClienteTest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class JXLSCustom {
	
	@Value("${jxlsresources.pathdestinationdir}")
	public String diretorioDestino;
	
	@Value("${jxlsresources.pathtemplatedir}")
	public String diretorioTemplate;
	
	
	
	public boolean criarDocumentoExcelComObjeto(String destineName, String templateName,
			Map<String, Object> data, String extensaoArq)
			throws FileNotFoundException, InvalidAlgorithmParameterException {
		
				
		if ((!extensaoArq.equals("xls")) && (!extensaoArq.equals("xlsx"))) {
			throw new InvalidAlgorithmParameterException("Extensão deve ser 'XLS' ou 'XLSX' para arquivos excel.");
		}
		String extensao = (".").concat(extensaoArq);
		String pathTemplateName = (diretorioTemplate).concat(templateName).concat(extensao);
		String pathDestineName = (diretorioDestino).concat(destineName).concat("-")
				.concat(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).concat(extensao);

		try (InputStream input = new FileInputStream(pathTemplateName);
				OutputStream outStream = new FileOutputStream(pathDestineName)) {// 1

			Context context = new Context();
			for (Entry<String, Object> element : data.entrySet()) { // 2
				context.putVar(element.getKey(), element.getValue());
			}

			JxlsHelper.getInstance().processTemplate(input, outStream, context); // 3

			if (new File(pathDestineName).exists() && new File(pathDestineName).canRead()) {
				return true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;

	}

	public boolean criarDocumentoXLSComObjeto(String destineName, String templateName, Map<String, Object> data)
			throws FileNotFoundException {
		try {
			return criarDocumentoExcelComObjeto(destineName, templateName, data, "xls");
		} catch (InvalidAlgorithmParameterException e) {
			return false;
		}
	}

	public boolean criarDocumentoXLSXComObjeto(String destineName, String templateName, Map<String, Object> data)
			throws FileNotFoundException {
		try {
			return criarDocumentoExcelComObjeto(destineName, templateName, data, "xlsx");
		} catch (InvalidAlgorithmParameterException e) {
			return false;
		}
	}
	
	
	public boolean testeDocExcel() {
		// TODO Auto-generated method stub
        System.out.println("Vamos lá...");
        
        
        
        ClienteTest c = new ClienteTest("Mário", "1212211222", "Rua dos cogumelos, 12");
        ClienteTest c2 = new ClienteTest("Sonic", "33322272111", "Rua das colinas verdes, 1233");
        
        List<ClienteTest> listCli = Arrays.asList(c,c2);
        
        Map<String, Object> data = new HashMap<>();
        
        data.put("criadoEm", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        data.put("clientes", listCli);
        
        
        try {
			return criarDocumentoXLSXComObjeto("resultCliente", "templateCliente", data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
        
	}
}
