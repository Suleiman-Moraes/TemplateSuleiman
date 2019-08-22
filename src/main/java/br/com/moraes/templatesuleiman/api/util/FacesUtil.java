package br.com.moraes.templatesuleiman.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.moraes.templatesuleiman.message.Message;

public class FacesUtil {

	private static final Log logger = LogFactory.getLog(FacesUtil.class);
	
	private static final String URL_PORTAL_CADU_WEB_SERVICE = "https://www.portal.agr.go.gov.br/services";
	private static final String URL_PORTAL_CADASTROUNICO_WEB_SERVICE = "https://www.portal.agr.go.gov.br/cadastrounicoservice";
	private static final String URL_PORTAL_TRANSPORTE_NAO_REGULAR = "https://www.portal.agr.go.gov.br/ModuloTransporte";
	
	public static String getUrlTransporteWebService(String context) {
		try {
			if(context.matches("http://localhost:.*")) {
				return "http://localhost:8888";
			}
			else if(context.matches("http://10.243.4.187:8082.*")) {
				return "http://10.243.4.187:8082/services";
			}
			else if(context.matches("http://10.243.1.27:8080.*")) {
				return "http://10.243.1.27:8080/services";
			}
			else{//context.matches(URL_PORTAL_CADU + ".*")
				return URL_PORTAL_CADU_WEB_SERVICE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return URL_PORTAL_CADU_WEB_SERVICE;
		}
	}
	
	public static String getUrlTransporteNaoRegular(String context) {
		try {
			if(context.matches("http://localhost:.*")) {
				return "http://localhost:9090/ModuloTransporte";
			}
			else if(context.matches("http://10.243.4.187:8082.*")) {
				return "http://10.243.4.187:8082/ModuloTransporte";
			}
			else if(context.matches("http://10.243.1.27:8080.*")) {
				return "http://10.243.1.27:8080/ModuloTransporte";
			}
			else{//context.matches(URL_PORTAL_CADU + ".*")
				return URL_PORTAL_TRANSPORTE_NAO_REGULAR;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return URL_PORTAL_TRANSPORTE_NAO_REGULAR;
		}
	}
	
	public static String getUrCadastroUnicoWebService(String context) {
		try {
			if(context.matches("http://localhost:.*")) {
				return "http://localhost:8080";
			}
			else if(context.matches("http://10.243.4.187:8082.*")) {
				return "http://10.243.4.187:8082/cadastrounicoservice";
			}
			else if(context.matches("http://10.243.1.27:8080.*")) {
				return "http://10.243.1.27:8080/cadastrounicoservice";
			}
			else{//context.matches(URL_PORTAL_CADU + ".*")
				return URL_PORTAL_CADASTROUNICO_WEB_SERVICE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return URL_PORTAL_CADASTROUNICO_WEB_SERVICE;
		}
	}

	public static Properties propertiesLoader() {
		return properties("sistema_pt.properties");
	}
	
	public static Properties propertiesLoaderURL() {
		return properties("url_pt.properties");
	}

	public static Properties properties(String name) {
		Properties prop = new Properties();
		try {
			String caminho = Message.class.getResource("").getPath() + name;
			File file = new File(caminho);
			FileInputStream fileInputStream = new FileInputStream(file);
			prop.load(fileInputStream);
			fileInputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return prop;
	}
}