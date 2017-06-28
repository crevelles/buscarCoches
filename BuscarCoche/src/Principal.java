
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		VistaBusca vb = new VistaBusca();
		
		AccessOracle bbdd = new AccessOracle();
		Controlador c = new Controlador(vb, bbdd);
		vb.setControlador(c);
		vb.setVisible(true);
		
	}

}
