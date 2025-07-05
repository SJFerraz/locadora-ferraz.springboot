package br.com.locadoraferraz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public final class DateUtils {
	  public static final String FORMATO_HORA_1 = "HH:mm", 
			                     FORMATO_HORA_2 = FORMATO_HORA_1+":ss", // HH:mm:ss
			                     FORMATO_DATA_BARRA = "dd/MM/yyyy", 
			                     FORMATO_DATA_HORA_BARRA = FORMATO_DATA_BARRA+" "+FORMATO_HORA_1, // dd/MM/yyyy HH:mm
			                     FORMATO_DATA_HORA_BARRA_COMPLETO = FORMATO_DATA_HORA_BARRA+":ss"; // dd/MM/yyyy HH:mm:ss
	  
	
      public static Integer calculaIdade(LocalDate dataNascimento) {
    	  final LocalDate dataAtual = LocalDate.now();
	      final Period periodo = Period.between(dataNascimento, dataAtual);
	      return periodo.getYears();
      }
      
      public static String formataDataParaTexto(Date data, String formato) {
    	  return new SimpleDateFormat(formato).format(data);
      }
      
      public static Date converteLocalDateParaDate(LocalDate locDate) {
    	  return Date.from(locDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
      }
      
      public static Date converteLocalDateTimeParaDate(LocalDateTime locDateTime) {
    	  return Date.from(locDateTime.atZone(ZoneId.systemDefault()).toInstant());
      }
      
      public static LocalDate converteDateParaLocalDate(Date date) {
    	  return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      }
      
      public static LocalDateTime converteDateParaLocalDateTime(Date date) {
    	  return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
      }
      
      public static String formataDataParaTexto(LocalDate data, String formato) {
    	  return formataDataParaTexto(converteLocalDateParaDate(data), formato);
      }
      
      public static String formataDataParaTexto(LocalDateTime data, String formato) {
    	  return formataDataParaTexto(converteLocalDateTimeParaDate(data), formato);
      }
      
      public static Date formataTextoParaData(String texto, String formato) throws ParseException{
    	  return new SimpleDateFormat(formato).parse(texto);
      }
      
      public static LocalDate formataTextoParaLocalData(String texto, String formato) throws ParseException{
    	  return converteDateParaLocalDate(formataTextoParaData(texto, formato));
      }
      
      public static LocalDateTime formataTextoParaLocalDataTime(String texto, String formato) throws ParseException{
    	  return converteDateParaLocalDateTime(formataTextoParaData(texto, formato));
      }
}
