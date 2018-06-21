package com.dsite.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.dsite.constants.DSiteCoreConstants;

public class FileManagerUtil {

	/***
	 * Escribe un archivo en disco duro dentro de una estructura de carpetas anyo, mes y dia.
	 * @param inputStream Streams de datos
	 * @param path La ruta donde se empezaran a crear las carpetas
	 * @param fileName Nombre del archivo que se almacenara en la estructura creada
	 * @return Nombre con la ruta absoluta del archivo creado.
	 * @throws IOException
	 */
	public static String createFileByAnyoMesDia(InputStream inputStream, String path, String fileName) throws IOException {
		String rutaAnyoMesDia = createFoldersWithAnyoMesDia(path);
		File pathfileAndName = new File(rutaAnyoMesDia + DSiteCoreConstants.SLASH + fileName);
		writeFile(inputStream, pathfileAndName);
		inputStream.close();
		return pathfileAndName.getAbsolutePath();
	}
	
	/***
	 * Crea una estructura de carpetas con el formato anyo/mes/dia en la ruta especificada
	 * @param path La ruta donde se empezaran a crear las carpetas
	 * @param fileName Nombre del archivo que se almacenara en la estructura creada
	 * @throws IOException
	 */
	public static String createFoldersWithAnyoMesDia(String path) throws IOException {
		Calendar cal = Calendar.getInstance();
		Date hoy = new Date();
		cal.setTime(hoy);
		int anio = cal.get(1);
		String mes = DSiteCoreConstants.CERO_CADENA + (cal.get(2) + 1);
		mes = mes.substring(mes.length() - 2, mes.length());
		String dia = DSiteCoreConstants.CERO_CADENA + cal.get(5);
		dia = dia.substring(dia.length() - 2, dia.length());

		String ruta = path + DSiteCoreConstants.SLASH + anio;

		File carpAnyo = new File(ruta);
		if (!carpAnyo.exists()) {
			carpAnyo.mkdir();
		}

		ruta = ruta + DSiteCoreConstants.SLASH + mes;
		File carpMes = new File(ruta);
		if (!carpMes.exists()) {
			carpMes.mkdir();
		}

		ruta = ruta + DSiteCoreConstants.SLASH + dia;
		File carpDia = new File(ruta);
		if (!carpDia.exists()) {
			carpDia.mkdir();
		}
		
		return ruta;
	}

	public static String obtenerDiaMesAnyo() throws IOException {
		Calendar cal = Calendar.getInstance();
		Date hoy = new Date();
		cal.setTime(hoy);
		int anio = cal.get(1);
		String mes = DSiteCoreConstants.CERO_CADENA + (cal.get(2) + 1);
		mes = mes.substring(mes.length() - 2, mes.length());
		String dia = DSiteCoreConstants.CERO_CADENA + cal.get(5);
		dia = dia.substring(dia.length() - 2, dia.length());

		String ruta=anio+"/"+mes+"/"+dia+"/";
		
		return ruta;
	}


	public static String createFile(InputStream inputStream, String path, String fileName) throws IOException {
		File pathfileName = new File(path + "\\" + fileName);
		writeFile(inputStream, pathfileName);
		inputStream.close();
		return pathfileName.getAbsolutePath();		
	}

	public static void writeFileText(String str, File pathfileName) throws IOException {
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathfileName), "UTF8"));
		out.append(str);
		out.flush();
		out.close();
	}

	/***
	 * Metodo para escribir un archivo en disco duro.
	 * @param inputStream Recibe el objeto que representa los bytes a almacenar
	 * @param pathAndFileName Ruta y nombre del archivo donde se almacena la data
	 * @throws IOException
	 */
	public static void writeFile(InputStream inputStream, File pathAndFileName) throws IOException {
		OutputStream out = new FileOutputStream(pathAndFileName);
		byte buf[] = new byte[1024];
		int len;
		while ((len = inputStream.read(buf)) > 0)
			out.write(buf, 0, len);
		inputStream.close();
		out.close();
	}

	/***
	 * Metodo para eliminar un archivo o un directorio.
	 * @param fileName Representa un directorio o un archivo con la ruta completa
	 * @throws Exception Lanza excepcion si directorio o archivo no existe, si se encuentra protegido o en 
	 * 		   caso de ser un directorio que no se encuentre vacio
	 */
	public static void deleteFile(String fileName) throws Exception {
		File f = new File(fileName);

		// Valida si archivo existe
		if (!f.exists())
			throw new IllegalArgumentException("No se encuentra el archivo o directorio especificado: " + fileName);
		// Valida que el archivo no este protegido
		if (!f.canWrite())
			throw new IllegalArgumentException("Archivo Protegido: " + fileName);

		// Si es un directorio se valida que no se encuentre vacio
		if (f.isDirectory()) {
			String[] files = f.list();
			if (files.length > 0)
				throw new IllegalArgumentException("El directorio no se encuentra vacio: " + fileName);
		}

		boolean success = f.delete();
		
		if (!success)
			throw new IllegalArgumentException("Delete: deletion failed");
	}

	/***
	 * Anade al nombre del archivo el formato yyyyMMddHHmmss	 
	 * @param fileName Nombre del archivo, ejemplo : miArchivo.txt
	 * @return Nombre del nuevo archivo con el formato yyyyMMddHHmmss_MiArchivo.txt
	 */
	public static String renameFile(String fileName) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = fmt.format(new Date()) + DSiteCoreConstants.GUION_ABAJO
				+ fileName.substring(fileName.lastIndexOf(DSiteCoreConstants.BACK_SLASH) + 1);
		newFileName = newFileName.replace(DSiteCoreConstants.ESPACIO, DSiteCoreConstants.GUION_ABAJO);
		return newFileName;
	}
}
