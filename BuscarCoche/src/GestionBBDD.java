import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionBBDD {

	
	Connection conexion;

	public GestionBBDD(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	
	
	public void consultaCoches(ArrayList<Coche> coches){
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM COCHES";
			System.out.println(select);
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Coche c  = new Coche();
				c.setMarca(rset.getString("MARCA"));
				c.setModelo(rset.getString("MODELO"));
				c.setMatricula(rset.getString("MATRICULA"));
				c.setPrecio(rset.getInt("PRECIO"));
				coches.add(c);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public boolean buscarCoches(int precioMinimo, int precioMaximo) {
		
		try {
			ArrayList<Coche> coches = new ArrayList<>();
			Coche c  = new Coche();
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM COCHES WHERE PRECIO > "+precioMinimo + " AND PRECIO < "+ precioMaximo;
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				c.setMarca(rset.getString("MARCA"));
				c.setModelo(rset.getString("MODELO"));
				c.setMatricula(rset.getString("MATRICULA"));
				c.setPrecio(rset.getInt("PRECIO"));
				coches.add(c);
				return true;
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
