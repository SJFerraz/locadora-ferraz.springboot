package br.com.locadoraferraz.util;

import java.io.IOException;
import java.io.OutputStream;

public class FileUtils {
	public static void closeAndFlushOutput(OutputStream outStream) {
		try {
			outStream.flush();
			outStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
