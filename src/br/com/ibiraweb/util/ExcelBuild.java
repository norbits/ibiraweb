package br.com.ibiraweb.util;
import java.io.InputStream;
import java.util.List;

public interface ExcelBuild <T>{

		public List<T> readExcel (InputStream file);
		public void    writeExcel();

}
