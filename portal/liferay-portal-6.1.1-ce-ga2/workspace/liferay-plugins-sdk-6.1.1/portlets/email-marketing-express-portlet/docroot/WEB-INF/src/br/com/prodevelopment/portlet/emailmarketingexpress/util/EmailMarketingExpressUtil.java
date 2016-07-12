package br.com.prodevelopment.portlet.emailmarketingexpress.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import br.com.prodevelopment.portlet.emailmarketingexpress.Constantes;
import br.com.prodevelopment.portlet.emailmarketingexpress.vo.ArquivoVO;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

public class EmailMarketingExpressUtil {

	public static Map<String, ArquivoVO> confirmar(ActionRequest request, ActionResponse response)
			throws Exception {
		Map<String, ArquivoVO> retorno = null;
		// Recupera os objetos de request
		UploadPortletRequest upLoadRequest = PortalUtil
				.getUploadPortletRequest(request);
		File arquivo = upLoadRequest.getFile(Constantes.PROP_NOME_ARQUIVO);
		String nomeArquivo = upLoadRequest
				.getFileName(Constantes.PROP_NOME_ARQUIVO);
		if (Validator.isNotNull(nomeArquivo)) {
			request.setAttribute(Constantes.NOME_PARAM_NOME_ARQUIVO, " - "
					+ nomeArquivo);		// Objeto do portal
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			


			nomeArquivo = arquivo.getPath();

			retorno = carregarDadosPlanilha(nomeArquivo);
		}
		return retorno;
	}

	private static Map<String, ArquivoVO> carregarDadosPlanilha(
			String nomeArquivo) throws FileNotFoundException, IOException,
			Exception {
		Map<String, ArquivoVO> lista = null;
		ArquivoVO arquivo = null;

		try {
			// WorkBook, o arquivo planilha em si
			HSSFWorkbook wb;

			// Worksheet vai usar, aquelas abinhas que tem lá embaixo no Excel
			HSSFSheet sheet;

			// passa qual WorkBook vai ser usada, de acordo com o caminho
			wb = new HSSFWorkbook(new FileInputStream(nomeArquivo));

			// Passa qual WorkSheet vai ser usada.
			sheet = wb.getSheetAt(0);

			if (sheet.getLastRowNum() > 0) {
				lista = new HashMap<String, ArquivoVO>();
			}

			// Ler linhas
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				// Ler colunas
				for (int j = 0; j < 2; j++) {
					// Cria a linha de acordo com o parametro
					HSSFRow row = sheet.getRow(i);

					// Com a linha criada, pega a célula
					HSSFCell cell = row.getCell(j);

					String valor = "";
					if (cell != null) {
						if (cell.getCellType() == cell.CELL_TYPE_STRING) {
							valor = cell.getRichStringCellValue().getString();
						} else if ((cell.getCellType() == cell.CELL_TYPE_NUMERIC)) {
							valor = String.valueOf(cell.getNumericCellValue());
						}

						if (i > 0) {
							if (j == 0) {
								arquivo = new ArquivoVO();
								arquivo.setNome(valor);
							} else if (j == 1) {
								if (Helper.validaEmail(valor)) {
									arquivo.setEmail(valor);
									lista.put(valor, arquivo);
								}
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return lista;
	}

	public static String gerarArquivoTexto(ActionRequest request, Map<String, ArquivoVO> lista) throws IOException {
		FileWriter fileWriter = null;
		PrintWriter writer = null;
		BufferedWriter fw = null;
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		DateFormat hf = new SimpleDateFormat("hhmmss");

		// Montar o nome do arquivo
		String sData = df.format(DateUtil.getDataAtual());
		String sHora = hf.format(new Date());
		String sArquivo = "EmailMarketing-" + sData + sHora + ".txt";

		String caminhoArquivo = PortletProps.get("caminho.arquivo");
		
		try {
			fileWriter = new FileWriter(caminhoArquivo + sArquivo);
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(caminhoArquivo + sArquivo),"utf-8"));
			writer = new PrintWriter(fw);
			
			for (Iterator iter = lista.keySet().iterator(); iter.hasNext();) {  
				String key = (String)iter.next();  
	            ArquivoVO item = lista.get(key);

	            writer.println(item.getNome() + ";" + item.getEmail());
			}

			// fechando os objetos de io:
			writer.close();
			fileWriter.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
		return caminhoArquivo + sArquivo;
	}

	public static void enviarEmail(ActionRequest request, String nomeArquivo, List<File> anexos) throws IOException {
		String urlPortal = PortletProps.get("email.url.portal");
		String corpo = PortletProps.get("email.corpo");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<b><i>");
		sb.append("Programa de Fidelidade");
		sb.append("</i></b><br><br>");
		sb.append("Prezado cliente,");
		sb.append("<br>");
		sb.append(corpo);
		sb.append("<br><br>");
		sb.append("<a href='");
		sb.append(urlPortal);
		sb.append("'>");
		sb.append("Clique aqui para conferir.");
		sb.append("</a>");
		
		sb.append("</html>");
		
		String fromEmail = PortletProps.get("email.from");
		String assunto = PortletProps.get("email.assunto");
		String toEmail = "";
		
		// Ler o arquivo texto
		FileReader arq = new FileReader(nomeArquivo);
		BufferedReader lerArq = new BufferedReader(arq);
		String linha = lerArq.readLine();
		while (linha != null) {
			String[] aEmails = linha.split(StringPool.SEMICOLON);
			toEmail = aEmails[1];
			if (Validator.isNotNull(toEmail)) {
				Email.sendEmail(fromEmail, toEmail, assunto, sb.toString(), anexos);
			}
			linha = lerArq.readLine();
		}
		arq.close();
	}
}
