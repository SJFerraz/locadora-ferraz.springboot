package br.com.locadoraferraz.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class DateUtils {
      public static Integer calculaIdade(LocalDate dataNascimento) {
    	  final LocalDate dataAtual = LocalDate.now();
	      final Period periodo = Period.between(dataNascimento, dataAtual);
	      return periodo.getYears();
      }
}
