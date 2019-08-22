package br.com.moraes.templatesuleiman.api.util;

import java.lang.reflect.Type;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.moraes.templatesuleiman.api.response.Response;

public class ConsumidorServicosUtil {
	
	private static final Log logger = LogFactory.getLog(ConsumidorServicosUtil.class);
	
	/**
	 * 
	 * @param url String
	 * @param httpMethod HttpMethod
	 * @param object Object
	 * @param headers HttpHeaders
	 * @return String
	 */
	public static <T> String consumir(String url, HttpMethod httpMethod, Object object, HttpHeaders headers) {
		HttpEntity<?> entity = new HttpEntity<>(object, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class);
		HttpStatus httpStatus = response.getStatusCode();
		logger.info(String.format("Reaquisção %s realizada na URL == \"%s\" com Status == %s", httpMethod, url, httpStatus));
		String result = response.getBody();
		logger.info(String.format("Resultado == \"%s\"", result));
		return result;
	}
	
	/**
	 * 
	 * @param url String
	 * @param httpMethod HttpMethod
	 * @param type Type
	 * @param object Object
	 * @param headers HttpHeaders
	 * @return Object<T>
	 */
	public static <T> T consumir(String url, HttpMethod httpMethod, Type type, Object object, HttpHeaders headers) {
		String result = consumir(url, httpMethod, object, headers);
		
		try {
			Gson gson = new Gson();
			T retorno = gson.fromJson(result, type);
			return retorno;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @param url String 
	 * @param httpMethod HttpMethod
	 * @param headers HttpHeaders
	 * @param type Type
	 * @return Object<T>
	 */
	public static <T> T consumir(String url, HttpMethod httpMethod, HttpHeaders headers, Type type) {
		return consumir(url, httpMethod, type, null, headers);
	}
	
	/**
	 * 
	 * @param url String
	 * @param httpMethod HttpMethod
	 * @param headers HttpHeaders
	 * @return String
	 */
	public static String consumir(String url, HttpMethod httpMethod, HttpHeaders headers) {
		return consumir(url, httpMethod, null, headers);
	}
	
	/**
	 * 
	 * @param url String
	 * @param httpMethod HttpMethod
	 * @param headers HttpHeaders
	 * @return Map<String, Object>
	 */ 
	public static Map<String, Object> consumirRetMap(String url, HttpMethod httpMethod, HttpHeaders headers) {
		return consumir(url, httpMethod, headers, new TypeToken<Map<String, Object>>() {}.getType());
	}
	
	/**
	 * 
	 * @param url
	 * @param httpMethod
	 * @param object
	 * @return
	 */
	public static String consumir(HttpMethod httpMethod, Object object, String url) {
		return consumir(url, httpMethod, object, new HttpHeaders());
	}
	
	public static void validarRespose(Response<?> response) throws Exception {
		if(response.getErros() != null && !response.getErros().isEmpty()) {
			throw new Exception(response.getErros().get(0));
		}
	}
}
