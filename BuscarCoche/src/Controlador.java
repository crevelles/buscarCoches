import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener, MouseListener{

	VistaBusca vb;
	Modelo md;
	Runtime r = Runtime.getRuntime();


	
	public Controlador(VistaBusca vb, Modelo model) {
		super();
		this.vb = vb;
		this.md = model;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o == vb.btnSalir) {
			md.cerrar();
			
		} else if(o == vb.btnExcel) {
			md.excel();
		} else if(o == vb.btnPowerpoint) {
			md.power();
		} else if(o == vb.btnWord) {
			md.word();
		} else if(o == vb.btnGO) {
			md.navegacion();
		} else if(o == vb.btnLimpiarHistorial) {
			limpiarTabla();
			
		}
		
	}

	private void limpiarTabla() {

		try {
			while (vb.table.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vb.table.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {

		Object o = e.getSource();
		int fila = vb.table.rowAtPoint(e.getPoint());
		vb.dirWeb.setText(md.direcciones.get(fila).getDireccionWeb());
		try {
			r.exec("rundll32 url.dll, FileProtocolHandler " +md.direcciones.get(fila).getDireccionWeb());
			vb.dirWeb.setText(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

	
}
