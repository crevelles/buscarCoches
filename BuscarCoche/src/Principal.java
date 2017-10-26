
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		VistaBusca vb = new VistaBusca();
		Modelo m = new Modelo(vb);
		Controlador c = new Controlador(vb,m);
		vb.setControlador(c);
		vb.setVisible(true);
		
	}

}
