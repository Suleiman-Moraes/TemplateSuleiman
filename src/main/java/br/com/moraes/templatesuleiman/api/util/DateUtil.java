package br.com.moraes.templatesuleiman.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author suleiman-am
 *
 */
public class DateUtil {

	private static SimpleDateFormat formatador = new SimpleDateFormat();

	public static String getDiaMesAno(Date data) {
		verificarData(data);
		formatador.applyPattern("dd/MM/yyyy");
		return formatador.format(data);
	}

	public static Date parseData(String data, String formato) throws ParseException {
		formatador.applyPattern(formato);
		return formatador.parse(data);
	}

	public static String getDiaMesAnoHorasMinutosSegundos(Date data, Date data2) {
		if (data != null) {
			return formatador.format(data);
		} else {
			return formatador.format(data2);
		}
	}

	public static String getDiaMesAnoHorasMinutosSegundos(Date data) {
		verificarData(data);
		formatador.applyPattern("dd/MM/yyyy HH:mm:ss");
		return formatador.format(data);
	}

	public static String getHorasMinutosSegundos(Date data) {
		verificarData(data);
		formatador.applyPattern("HH:mm:ss");
		return formatador.format(data);
	}

	public static String getDataPorExtenso(Date data) {
		verificarData(data);
		formatador.applyPattern("EEEEE dd 'de' MMMMM 'de' yyyy");
		return formatador.format(data);
	}

	public static String getDataPorExtensoSemCidade(Date data) {
		verificarData(data);
		formatador.applyPattern("dd 'de' MMMMM 'de' yyyy");
		return formatador.format(data);
	}

	public static String getDataAtualPorExtensoSemCidade() {
		return getDataPorExtensoSemCidade(new Date());
	}

	public static String getDataAtualPorExtenso() {
		return getDataPorExtenso(new Date());
	}

	public static String getDataFormatada(Date data, String formato) {
		verificarData(data);
		verificarFormato(formato);
		formatador.applyPattern(formato);
		return formatador.format(data);

	}

	public static String getDataAtualFormatada(String formato) {
		verificarFormato(formato);
		formatador.applyPattern(formato);
		return formatador.format(new Date());

	}

	public static void verificarData(Date data) {
		if (data == null) {
			throw new IllegalArgumentException("A data não pode ser nula!");
		}
	}

	public static void verificarFormato(String formato) {
		if (StringUtil.isNullOrEmpity(formato)) {
			throw new IllegalArgumentException("O formato não pode ser vazio!");
		}
	}

	public static String getDataFormatoSQL(String data) {
		if (StringUtil.isNotNullOrEmpity(data)) {
			String[] array = data.split("/");
			return String.format("%s-%s-%s", array[2], array[1], array[0]);
		}
		return "";
	}

	public static Date getDataDe(String data) throws ParseException {
		return StringUtil.isNullOrEmpity(data) ? DateUtil.parseData("01/01/1990", "dd/MM/yyyy")
				: DateUtil.parseData(data, "dd/MM/yyyy");
	}

	public static Date getDataAte(String data) throws ParseException {
		return StringUtil.isNullOrEmpity(data) ? new Date()
				: DateUtil.parseData(data + " 23:59:59", "dd/MM/yyyy HH:mm:ss");
	}

}
