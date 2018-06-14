package com.dsite.util;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.dsite.constants.DSiteCoreConstants;

public class DateUtil {

	/***
	 * Milisegundos al dia
	 */
	public final static long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;

	/**
	 * Arreglo que representa los feriados
	 */
	static final List<DateTime> lstDiasFeriados = new ArrayList<DateTime>();

	static {
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.JANUARY + 1), DSiteCoreConstants.FERIADO_ANYO_NUEVO, 0,
				0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.MAY + 1), DSiteCoreConstants.FERIADO_DIA_TRABAJADOR, 0,
				0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.JUNE + 1),
				DSiteCoreConstants.FERIADO_DIA_SAN_PEDRO_SAN_PABLO, 0, 0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.JULY + 1),
				DSiteCoreConstants.FERIADO_DIA_INDEPENDENCIA, 0, 0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.JULY + 1),
				DSiteCoreConstants.FERIADO_DIA_FIESTAS_PATRIAS, 0, 0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.AUGUST + 1),
				DSiteCoreConstants.FERIADO_SANTA_ROSA_LIMA, 0, 0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.OCTOBER + 1),
				DSiteCoreConstants.FERIADO_COMBATE_ANGAMOS, 0, 0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.NOVEMBER + 1),
				DSiteCoreConstants.FERIADO_DIA_TODOS_LOS_SANTOS, 0, 0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.DECEMBER + 1),
				DSiteCoreConstants.FERIADO_DIA_VIRGEN_INMACULADA, 0, 0, 0));
		lstDiasFeriados.add(new DateTime(Calendar.getInstance().get(Calendar.YEAR), (Calendar.DECEMBER + 1), DSiteCoreConstants.FERIADO_NAVIDAD, 0,
				0, 0));
	}

	/**
	 * Enumeracion que representa el tipo de formato deseado
	 */
	public enum DateFormat {
		DATE_GUION("yyyy-MM-dd"), DATE_TIME_GUION("yyyy-MM-dd HH:mm:ss"), DATE_SLASH("dd/MM/yyyy"), DATE_TIME_SLASH("dd/MM/yyyy HH:mm:ss"), DATE_TIME_BIZAGUI(
				"yyyyMMdd HH:mm:ss"), TIME("HH:mm:ss"), DATE_TIME_JUNTO("yyyyMMddHHmmss"), DATE_TIME_GUION_2("dd-MM-yyyy HH:mm:ss"), DATE_DAY_MONTH_YEAR("ddMMyyyy");
		private String formato;

		DateFormat(String formato) {
			this.formato = formato;
		}

		public String getFormato() {
			return formato;
		}
	}

	/**
	 * Enumeracion que representa los dias de la semana
	 */
	enum WeekDays {
		LUNES(1), MARTES(2), MIERCOLES(3), JUEVES(4), VIERNES(5), SABADO(6), DOMINGO(7);
		private int dia;

		WeekDays(int dia) {
			this.dia = dia;
		}

		public int getDia() {
			return dia;
		}
	}

	public static int getMinutosTotales(String cadenaTiempo) throws Exception {
		int minutosTotales = 0;
		String tiempo[] = cadenaTiempo.split(" d ")[1].split(":");
		String hora = tiempo[0];
		String minuto = tiempo[1];
		// String segundo = tiempo[2];

		minutosTotales = (new Integer(hora)) * 60;
		minutosTotales = minutosTotales + (new Integer(minuto));

		return minutosTotales;
	}
	
	public static int getHorasTotales(String cadenaTiempo) throws Exception {
		
		String dias;
		dias=cadenaTiempo.substring(1, 3);
		int horasExtras=0;
		
		if (!dias.equals("00")){
			horasExtras=(new Integer(dias)) * 24;
		}
				
		int minutosTotales = 0;
		String tiempo[] = cadenaTiempo.split(" d ")[1].split(":");
		String hora = tiempo[0];
		String minuto = tiempo[1];
		// String segundo = tiempo[2];

		minutosTotales = ((new Integer(hora)) * 60) + ((new Integer(horasExtras)) * 60);
		minutosTotales = minutosTotales + (new Integer(minuto));
	
		return minutosTotales;
	}

	/**
	 * Retorna una cadena de fecha con el formato deseado
	 * 
	 * @param fecha
	 * @param formato
	 */
	public static String parseDateToString(Date fecha, DateFormat formato) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(formato.getFormato());
		return sdf.format(fecha);
	}
	
	/**
	 * Retorna un Date con el formato deseado
	 * 
	 * @param fecha
	 * @param formato
	 */
	public static Date parseStringToDate(String fecha, DateFormat formato) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(formato.getFormato());
		return sdf.parse(fecha);
	}

	/***
	 * Devuelve un objeto Date con las horas especificadas en una cadena
	 * 
	 * @param hhmmss
	 *            representa una cadena del formato HH:mm:ss
	 * @param date
	 *            Fecha que sera modificada
	 * @return nueva fecha
	 */
	public static Date getDateTimeByParams(Date date, String hhmmss) throws Exception {
		DateTime dateTime = new DateTime(date);
		String[] arrayTime = hhmmss.split(DSiteCoreConstants.DOS_PUNTOS);

		dateTime = dateTime.withHourOfDay(Integer.parseInt(arrayTime[0]));
		dateTime = dateTime.withMinuteOfHour(Integer.parseInt(arrayTime[1]));
		if (arrayTime.length == 3)
			dateTime = dateTime.withSecondOfMinute(Integer.parseInt(arrayTime[2]));
		else
			dateTime = dateTime.withSecondOfMinute(DSiteCoreConstants.CERO_SEGUNDOS);
		return dateTime.toDate();
	}

	/***
	 * Metodo que recibe un objeto Date y devuelve la hora en cadena con el
	 * formato HH:MM:SS
	 * 
	 * @param Fecha
	 *            de donde se obtendra la hora
	 * @return devuelve HH:MM:SS
	 */
	public static String getHourFromDate(java.util.Date date) throws Exception {
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}

	/***
	 * Devuelve un mapa con la Hora, minuto y segundo de la diferencia de 2
	 * fechas
	 * 
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public static Map<String, Long> getDiferencia(java.util.Date fecha1, java.util.Date fecha2) throws Exception {
		java.util.Date fechaMayor = null;
		java.util.Date fechaMenor = null;
		Map<String, Long> resultadoMap = new HashMap<String, Long>();

		/*
		 * Verificamos cual es la mayor de las dos fechas, para no tener
		 * sorpresas al momento de realizar la resta.
		 */
		if (fecha1.compareTo(fecha2) > 0) {
			fechaMayor = fecha1;
			fechaMenor = fecha2;
		} else {
			fechaMayor = fecha2;
			fechaMenor = fecha1;
		}

		// los milisegundos
		long diferenciaMils = fechaMayor.getTime() - fechaMenor.getTime();

		// obtenemos los segundos
		long segundos = diferenciaMils / 1000;

		// obtenemos las horas
		long horas = segundos / 3600;

		// restamos las horas para continuar con minutos
		segundos -= horas * 3600;

		// igual que el paso anterior
		long minutos = segundos / 60;
		segundos -= minutos * 60;

		// ponemos los resultados en un mapa :-)
		resultadoMap.put(DSiteCoreConstants.HORAS, horas);
		resultadoMap.put(DSiteCoreConstants.MINUTOS, minutos);
		resultadoMap.put(DSiteCoreConstants.SEGUNDOS, segundos);
		return resultadoMap;
	}

	/**
	 * Suma una cantidad de dias a una fecha determinada
	 * 
	 * @return la fecha incrementada con los dias indicados
	 */
	public static Date sumDay(Date fecha, int cantidadDias) throws Exception {
		DateTime fechaTemp = new DateTime(fecha);
		fechaTemp = fechaTemp.plus(Period.days(cantidadDias));
		return fechaTemp.toDate();
	}
	
	public static Date sumMonth(Date fecha, int cantidadMeses) throws Exception {
		DateTime fechaTemp = new DateTime(fecha);
		fechaTemp = fechaTemp.plus(Period.months(cantidadMeses));
		return fechaTemp.toDate();
	}
	
	public static Date sumMinute(Date fecha, int cantidadMinutos) throws Exception {
		DateTime fechaTemp = new DateTime(fecha);
		fechaTemp = fechaTemp.plus(Period.minutes(cantidadMinutos));
		return fechaTemp.toDate();
	}

	public static Date resDay(Date fecha, int cantidadDias) throws Exception {
		DateTime fechaTemp = new DateTime(fecha);		
		fechaTemp = fechaTemp.minus(Period.days(cantidadDias));
		return fechaTemp.toDate();
	}
	
	/**
	 * Se obtiene el siguiente dia laborable, considera los fines de semana y
	 * dias feriados.
	 * @author Bustamante_L
	 * @param La fecha de partida de busqueda
	 * @return La siguiente fecha laborable
	 * @throws Exception
	 */
	public static Date getSiguienteDiaLaborable(Date date) throws Exception {
		DateTime fecha = new DateTime(date);
		DateTime fechaTemp = null;
		boolean incrementaFecha;
		while (true) {
			fechaTemp = new DateTime();
			fechaTemp = fecha.plus(Period.days(1));
			int dayOfWeek = fechaTemp.getDayOfWeek();
			// Se analiza si es fin de semana
			if (dayOfWeek == WeekDays.SABADO.getDia() || dayOfWeek == WeekDays.DOMINGO.getDia()) {
				fecha = fechaTemp;
				continue;
			}
			incrementaFecha = false;
			// Se analiza si es feriado, se compara solo la fecha sin considerar "time"
			for (DateTime dtFeriado : lstDiasFeriados) {
				if (fechaTemp.toLocalDate().compareTo(dtFeriado.toLocalDate()) == 0) {
					fecha = fechaTemp;
					incrementaFecha = true;
					break;
				}
			}
			if (incrementaFecha)
				continue;
			break;
		}
		return fechaTemp.toDate();
	}

	public static String getNombreMes(Integer numberMonth) throws Exception {
		if (numberMonth < 1 && numberMonth > 12)
			throw new Exception("Numero de mes fuera del rango");
		String[] spanishMonths = new DateFormatSymbols(Locale.getDefault()).getMonths();
		return spanishMonths[numberMonth - 1];
	}
	
	/***
	 * Devuelve la edad a partir de la fecha de nacimiento
	 * @param fechaNacimiento fecha de nacimiento
	 * @return un objeto Integer con la edad del sujeto
	 * @throws Exception
	 */
	public static Integer getEdad(Date fechaNacimiento) throws Exception {
		Period period = new Period(fechaNacimiento.getTime(), new Date().getTime());
		return period.getYears();
	}
	
	/***
	 * Convierte los milisegundos a Date
	 * @param milliSeconds
	 * @return
	 */
	public static String ConvertMilliSecondsToFormattedDate(String milliSeconds){
		
		String dateFormat = "dd/MM/yyyy hh:mm:ss";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
	    
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(milliSeconds));
        return simpleDateFormat.format(calendar.getTime());
    }
	
	public static Date parseDate(String dateInString) throws ParseException {
		if (dateInString != null) {
			SimpleDateFormat format = new SimpleDateFormat(
					"dd/MM/yyyy HH:mm:ss");
			return format.parse(dateInString);
		} else
			return null;
	}
}
