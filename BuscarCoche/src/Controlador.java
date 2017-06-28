import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{

	VistaBusca vb;
	AccessOracle bbdd;
	ArrayList<Coche> coches = new ArrayList<>();
	GestionBBDD bd;
	
	public Controlador(VistaBusca vb, AccessOracle bbdd) {
		super();
		this.vb = vb;
		this.bbdd = bbdd;
		bd = new GestionBBDD(bbdd.conexion);
		bd.consultaCoches(coches);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o == vb.btnSalir) {
			vb.dispose();
			bbdd.cerrarBaseDatos();
		} else if (o == vb.btnBuscar){
			buscar();
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

	
	
	
	

	private void buscar() {
		int contador = 0;
		limpiarTabla();
		String pMin, pMax;
		pMin = vb.textMin.getText();
		pMax = vb.textMax.getText();
			try {
				int precioMinimo = Integer.parseInt(pMin);
				int precioMaximo = Integer.parseInt(pMax);
				for (Coche coche : coches) {
					if (coche.getPrecio() <= precioMaximo && coche.getPrecio() >= precioMinimo) {
						DefaultTableModel tabla = (DefaultTableModel) vb.table.getModel();
						tabla.addRow(new Object[] { 
								coche.getMarca(), 
								coche.getModelo(),
								coche.getMatricula(),
								coche.getPrecio() 
								});
						contador++;
					}
				}
				vb.lblError.setForeground(Color.BLUE);
				vb.lblError.setText("Se han encontrado " + contador + " resultados entre "+precioMinimo +" y "+ precioMaximo+" €");
			} catch (Exception e) {
				vb.lblError.setForeground(Color.RED);
				vb.lblError.setText("Solo puede introducir numeros");
				vb.textMin.setText(null);
				vb.textMax.setText(null);
			}

		}
}
