package br.com.moraes.templatesuleiman.api.util;

/**
 * 
 * @author suleiman-am
 *
 */
public abstract class ValidacaoComumUtil {
	
	public static void validarString(String texto, String nome, char fim) throws Exception {
		if(StringUtil.isNullOrEmpity(texto)) {
			throw new Exception(String.format("%s deve ser informad%s.", nome, fim));
		}
	}

	public static void validarNotNull(Object objeto, String nome, char fim) throws Exception {
		if(objeto == null) {
			throw new Exception(String.format("%s deve ser informad%s.", nome, fim));
		}
	}
}
