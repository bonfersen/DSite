package com.dsite.constants;

import java.math.BigDecimal;

public class DSiteCoreConstants {

	/**
	 * Empleado
	 */
	public final static Integer EMPLEADO_ADMIN = 1;
	public final static String USUARIO_ADMIN = "ADMIN";

	/**
	 * Carpeta de acceso WEB para fotos
	 */
	public final static String RUTA_WEB_FOTOS = "/imagenes";
	
	/**
	 * NIVEL_USUARIO_SISTEMA
	 */
	public final static String NIVEL_USUARIO_SISTEMA_DEFAULT = "NUSI001";

	/**
	 * ESTADO_CAJA_CHICA
	 */
	public final static String ESTADO_OBRA_CREADO = "ESOB001";
	public final static String ESTADO_OBRA_EJECUCION = "ESOB002";
	public final static String ESTADO_OBRA_ANULADO = "ESOB003";
	public final static String ESTADO_OBRA_PARALIZADO = "ESOB004";
	public final static String ESTADO_OBRA_REACTIVADO = "ESOB005";
	public final static String ESTADO_OBRA_FINALIZADO = "ESOB006";
	public final static String ESTADO_OBRA_CERRADO = "ESOB007";
	
	/**
	 * ESTADO_CAJA_CHICA
	 */
	public final static String ESTADO_CAJA_CHICA_SOLICITADO = "ECCH001";
	public final static String ESTADO_CAJA_CHICA_APROBADO = "ECCH002";
	public final static String ESTADO_CAJA_CHICA_RECHAZADO = "ECCH003";
	public final static String ESTADO_CAJA_CHICA_DEPOSITADO = "ECCH004";
	public final static String ESTADO_CAJA_CHICA_ASIGNADO = "ECCH005";

	/**
	 * ESTADO_FINANZAS
	 */
	public final static String ESTADO_FINANZA_PENDIENTE = "ESFI001";
	public final static String ESTADO_FINANZA_OFERTADO = "ESFI002";
	public final static String ESTADO_FINANZA_LIQUIDADO = "ESFI003";
	public final static String ESTADO_FINANZA_OBSERVADO = "ESFI004";

	/**
	 * ESTADO_ACTA_CONTRATA
	 */
	public final static String ESTADO_ACTA_CONTRATA_PENDIENTE = "EACO001";
	public final static String ESTADO_ACTA_CONTRATA_ENVIADO = "EACO002";
	public final static String ESTADO_ACTA_CONTRATA_APROBADO = "EACO003";
	public final static String ESTADO_ACTA_CONTRATA_RECHAZADO = "EACO004";
	public final static String ESTADO_ACTA_CONTRATA_NO_APLICA = "EACO005";

	/**
	 * ESTADO_PAGO_CONTRATA
	 */
	public final static String ESTADO_PAGO_CONTRATA_SOLICITADO = "EPCO001";
	public final static String ESTADO_PAGO_CONTRATA_APROBADO = "EPCO002";
	public final static String ESTADO_PAGO_CONTRATA_PAGADO = "EPCO003";
	public final static String ESTADO_PAGO_CONTRATA_RECHAZADO = "EPCO004";

	/**
	 * TIPO_ENVIO_CUSTOMER_SERVICE
	 */
	public final static String TIPO_ENVIO_CUSTOMER_SERVICE_OFERTA = "TECS001";
	public final static String TIPO_ENVIO_CUSTOMER_SERVICE_LIQUIDACION = "TECS002";
	public final static String TIPO_ENVIO_CUSTOMER_SERVICE_ACTACAMPO = "TECS003";
	public final static String TIPO_ENVIO_CUSTOMER_SERVICE_ACTAFINAL = "TECS004";

	/**
	 * ESTADO_RENDICION
	 */
	public final static String ESTADO_RENDICION_POR_RENDIR = "ESRE001";
	public final static String ESTADO_RENDICION_PENDIENTE_REEMBOLSO = "ESRE002";
	public final static String ESTADO_RENDICION_REEMBOLSADO = "ESRE003";
	public final static String ESTADO_RENDICION_PENDIENTE_DESCUENTO = "ESRE004";
	public final static String ESTADO_RENDICION_DESCONTADO = "ESRE005";
	public final static String ESTADO_RENDICION_COMPLETADO = "ESRE006";
	/**
	 * ESTADO_RENDICION_APROBACION
	 */
	public final static String ESTADO_RENDICION_APROBACION_PENDIENTE = "ERAP001";
	public final static String ESTADO_RENDICION_APROBACION_APROBADO = "ERAP002";
	public final static String ESTADO_RENDICION_APROBACION_RECHAZADO = "ERAP003";
	
	/**
	 * ESTADO_CIERRE_ECONOMICO
	 */
	public final static String ESTADO_CIERRE_ECONOMICO_PENDIENTE = "ECEC001";
	public final static String ESTADO_CIERRE_ECONOMICO_PARCIAL = "ECEC002";
	public final static String ESTADO_CIERRE_ECONOMICO_FINALIZADO = "ECEC003";
	
	/**
	 * CATEGORIA_CONTRATA
	 */
	public final static String CATEGORIA_CONTRATA_GRANDE = "CACO001";
	public final static String CATEGORIA_CONTRATA_MEDIANO = "CACO002";
	public final static String CATEGORIA_CONTRATA_PEQUENO = "CACO003";

	/**
	 * CLASIFICACION_CAJA_CHICA
	 */
	public final static String CLASIFICACION_CAJA_CHICA_CAJA = "CCCH001";
	public final static String CLASIFICACION_CAJA_CHICA_VIATICO = "CCCH002";

	/**
	 * Cadenas numericas y decimales
	 */
	public static final String CERO_CADENA = "0";
	public static final String CIEN_CADENA = "100";
	public static final String CERO_DECIMAL_CADENA = "0.00";

	/**
	 * ESTADO_LIQUIDACION_CONTRATA
	 */
	public static final String ESTADO_LIQUIDACION_CONTRATA_GENERADO = "ELCO001";
	public static final String ESTADO_LIQUIDACION_CONTRATA_PENDIENTE = "ELCO002";
	public static final String ESTADO_LIQUIDACION_CONTRATA_SOLICITADO = "ELCO003";
	public static final String ESTADO_LIQUIDACION_CONTRATA_LIQUIDADO = "ELCO004";
	
	/**
	 * TIPO_SOLICITUD_PAGO
	 */
	public static final String TIPO_SOLICITUD_PAGO_ADELANTO = "TSPA001";
	public static final String TIPO_SOLICITUD_PAGO_LIQUIDACION = "TSPA002";
	
	/**
	 * Valores enteros
	 */
	public static final int CERO_INT = 0;

	/**
	 * Valores Decimales.
	 */
	public static final BigDecimal ZERO = BigDecimal.ZERO;

	/**
	 * Field ACTIVO.
	 */
	public static final String ACTIVO = "1";
	/**
	 * Field NO ACTIVO.
	 */
	public static final String INACTIVO = "0";
	/**
	 * Cadena Si
	 */
	public static final String CADENA_SI = "Si";
	/**
	 * Cadena No
	 */
	public static final String CADENA_NO = "No";
	/**
	 * 	Caracteres especiales
	 */
	public static final String UNICODE_A_MIN_TILDE = "\u00e1";
	public static final String UNICODE_E_MIN_TILDE = "\u00e9";
	public static final String UNICODE_I_MIN_TILDE = "\u00ed";
	public static final String UNICODE_O_MIN_TILDE = "\u00f3";
	public static final String UNICODE_U_MIN_TILDE = "\u00fa";
	public static final String UNICODE_A_MAY_TILDE = "\u00c1";
	public static final String UNICODE_E_MAY_TILDE = "\u00c9";
	public static final String UNICODE_I_MAY_TILDE = "\u00cd";
	public static final String UNICODE_O_MAY_TILDE = "\u00d3";
	public static final String UNICODE_U_MAY_TILDE = "\u00da";
	public static final String UNICODE_ENE_MIN_TILDE = "\u00f1";
	public static final String UNICODE_ENE_MAY_TILDE = "\u00d1";
	/***
	 * Acronimo de Horas Minutos y Segundo
	 */
	public final static String HORAS = "hh";
	public final static String MINUTOS = "mm";
	public final static String SEGUNDOS = "ss";

	/***
	 * CADENAS ENTERAS DE MINUTOS
	 */
	public static final int CINCO_MINUTOS = 5;
	public static final int CERO_MINUTOS = 0;
	public static final int CERO_SEGUNDOS = 0;

	/***
	 * Caracteres Especiales
	 */
	public final static String VACIO = "";
	public final static String ESPACIO = " ";
	public final static String DOS_PUNTOS = ":";
	public final static String BACK_SLASH = "\\";
	public final static String SLASH = "/";
	public final static String PUNTO = ".";
	public final static String TAB = "\t";
	public final static String NUEVA_LINEA = "\n";
	public final static String GUION = "-";
	public final static String GUION_ABAJO = "_";
	public final static String ASTERISCO = "*";
	public static final String PLECA = "|";
	public final static String PUNTO_Y_COMA = ";";
	public final static String COMA = ",";
	public static final String PORCENTAJE = "%";
	public static final String NO_TIENE = "NO TIENE";
	/**
	 * CADENAS LLAVES.
	 */
	public static final String LLAVE_ABIERTA = "{";
	public static final String LLAVE_CERRADA = "}";
	/**
	 * COMILLAS.
	 */
	public static final String COMILLAS_DOBLES = "\"";
	public static final String COMILLAS_SIMPLES = "'";
	/**
	 * CADENAS CORCHETES.
	 */
	public static final String CORCHETE_ABIERTO = "[";
	public static final String CORCHETE_CERRADO = "]";

	/***
	 * Cadena Numeros
	 */
	public static final String UNO = "1";
	public static final String DOS = "2";
	public static final String TRES = "3";
	public static final String CUATRO = "4";
	public static final String CINCO = "5";
	public static final String SEIS = "6";

	/***
	 * Cadena Enteros
	 */
	public static final Integer UNO_NUMERO = 1;
	public static final Integer DOS_NUMERO = 2;
	public static final Integer TRES_NUMERO = 3;
	public static final Integer CUATRO_NUMERO = 4;
	public static final Integer CINCO_NUMERO = 5;
	public static final Integer SEIS_NUMERO = 6;
	public static final Integer SIETE_NUMERO = 7;
	public static final Integer OCHO_NUMERO = 8;
	public static final Integer NUEVE_NUMERO = 9;
	public static final Integer DIEZ_NUMERO = 10;
	public static final Integer ONCE_NUMERO = 11;
	public static final Integer DOCE_NUMERO = 12;

	public final static String NN = "NN";

	/***
	 * Feriados
	 */
	public final static int FERIADO_ANYO_NUEVO = 1;
	public final static int FERIADO_DIA_TRABAJADOR = 1;
	public final static int FERIADO_DIA_SAN_PEDRO_SAN_PABLO = 29;
	public final static int FERIADO_DIA_INDEPENDENCIA = 28;
	public final static int FERIADO_DIA_FIESTAS_PATRIAS = 29;
	public final static int FERIADO_SANTA_ROSA_LIMA = 30;
	public final static int FERIADO_COMBATE_ANGAMOS = 8;
	public final static int FERIADO_DIA_TODOS_LOS_SANTOS = 1;
	public final static int FERIADO_DIA_VIRGEN_INMACULADA = 8;
	public final static int FERIADO_NAVIDAD = 25;

	/***
	 * Usuario anonimo
	 */
	public final static String USUARIO_ANONIMO = "anonymousUser";

	/**
	 * Extensiones de imagenes
	 */
	public final static String EXTENSION_JPG = "jpg";
	public final static String EXTENSION_GIF = "gif";
	public final static String EXTENSION_PNG = "png";
	public final static String EXTENSION_BMP = "bmp";

	/***
	 * Extensiones diversas
	 */
	public final static String EXTENSION_HTML = "html";
	public final static String EXTENSION_XML = "xml";

	/**
	 * Tags HTML
	 */
	public final static String TAG_HTML_BR = "<br />";

	/**
	 * Unicode UTF-8 (8-bit Unicode Transformation Format)
	 */
	public final static String FORMATO_CARACTERES_UTF_8 = "UTF-8";

	/**
	 * Maximo de tamano de imagen para un upload
	 */
	public final static Integer IMAGE_MAX_WIDTH_UPLOAD_LEGALL = 1024;

	/**
	 * Null
	 */
	public static final String NULL = "NULL";

	/**
	 * Tipo de tamanyo de un archivo
	 */
	public final static String BYTES = "bytes";
	public final static String KILO_BYTES = "kilobytes";
	public final static String MEGAS_BYTES = "megasbytes";
	public final static String GIGA_BYTES = "gigabytes";
	public final static double LIMITE_KILO_BYTES_RIMAC = 3000;

	public final static String VALIDACION_CAMPO_OBLIGATORIO = "obligatorio";
	public final static String VALIDACION_CAMPO_OPCIONAL = "opcional";
}
