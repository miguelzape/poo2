package utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class UtilsDdBb {

	public static void visualizaDBTabla(ResultSet rs) {

		ResultSetMetaData rsmd = null;
		String[] nombresColumnas;
		String[][] campos;
		int nCol=0;
		int nFil=0;
		
		try {
			rsmd = rs.getMetaData();
			nCol=rsmd.getColumnCount();
			
			rs.first();
			while (rs.next()){
			   nFil++;
			}
			//rs.last();
			//nFil=rs.getRow();
			
			System.out.println("La tabla tiene " + nFil +" filas y " + nCol + " columnas");
			
			nombresColumnas = new String[nCol];
			campos = new String[nFil][nCol];
			for (int iter = 1; iter <= rsmd.getColumnCount(); iter++) {
				nombresColumnas[iter] = rsmd.getColumnName(iter);
			}
			
			

		} catch (Exception e) {
			System.out.println("error en visualizaTabla " + e.getMessage());
		}

	}

}
