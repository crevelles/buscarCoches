import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Modelo implements Serializable{
	
	Process p = null;
	Runtime r = Runtime.getRuntime();
	VistaBusca vb;// = new VistaBusca();
	ArrayList<DireccionWeb> direcciones = new ArrayList<>();
	DireccionWeb dw;
	String web ;
	File fil;
	
	
	
		
	public  Modelo(VistaBusca vb) {
		this.vb = vb;
		leerFichero();
	}


	public void limpiarTabla() {
	try {
		while (vb.table.getColumnCount() > 1) {
			DefaultTableModel t = (DefaultTableModel) vb.table.getModel();
			t.removeRow(0);
		}
	} catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
	}
}


	public void power() {
		try {
			p = r.exec("C:\\Program Files (x86)\\Microsoft Office\\Office12\\powerpnt.exe");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El sistema no puede hallar la ruta del ejecutable");
		}
	}

	
	public void excel() {
		try {
			p = r.exec("C:\\Program Files (x86)\\Microsoft Office\\Office12\\excel.exe");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El sistema no puede hallar la ruta del ejecutable");
		}
	}

	
	public void word() {
		try {
			p = r.exec("C:\\Program Files (x86)\\Microsoft Office\\Office12\\winword.exe");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El sistema no puede hallar la ruta del ejecutable");
		}
	}
	
	
	public void navegacion() {		
		dw = new DireccionWeb(vb.dirWeb.getText().toString());
		boolean seguir = true;
			if(dw.getDireccionWeb().length() == 0) {
				JOptionPane.showMessageDialog(null, "Introduce una dirección web");
				seguir = false;
			} else {
				for (int i = 0; i < direcciones.size(); i++) {
					if(direcciones.get(i).getDireccionWeb().equalsIgnoreCase(dw.getDireccionWeb())) {
						try {
							r.exec("rundll32 url.dll, FileProtocolHandler " + dw.getDireccionWeb());
							vb.dirWeb.setText(null);
							seguir = false;
						} catch (IOException e) {	
						}
					}
				}
			}		
			if(seguir) {
				try {
					r.exec("rundll32 url.dll, FileProtocolHandler " + dw.getDireccionWeb());
					direcciones.add(dw);
					insertar(dw);
					insertaFichero();

					vb.dirWeb.setText(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		} 

	
	public void cerrar() {
		vb.dispose();
	}
	
	
	public void insertaFichero() {
		StringBuffer sb = null;
		try {
			BufferedWriter fo = new BufferedWriter(new FileWriter("urls.txt", true));
			fo.write(vb.dirWeb.getText().toString() + "\n");
			fo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void leerFichero() {
		StringBuffer sb = null;
		String direccion = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("urls.txt"));
			//direccion = (br.readLine().toString().trim());
			/*
			 * bucle For(array.length)(
			 * array[posicion]=al contenido del fichero
			 * insertar(array[posicion].DireccionWeb)
			 * nextline
			 * )
			 */
			//DireccionWeb d = new DireccionWeb(br.readLine().toString().trim());
			while((direccion =br.readLine()) != null) {
				DireccionWeb d = new DireccionWeb(direccion);
				direcciones.add(d);
				insertar(d);
			}
			
			
			
			
			br.close();
		} catch (FileNotFoundException e) {
			 fil = new File("urls.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void insertar(DireccionWeb dw) {
		DefaultTableModel tabla = (DefaultTableModel) vb.table.getModel();
		tabla.addRow(new Object[] { 
				dw.getDireccionWeb() 
				});
	}

	
	




	
	
	

	
	
	
			
}


	
		
	
	
	

