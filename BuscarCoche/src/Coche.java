
public class Coche {

	
	String marca, modelo, matricula;
	int precio, km;
	
	
	
	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coche(String marca, String modelo, String matricula, int precio, int km) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.precio = precio;
		this.km = km;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	
	
}
