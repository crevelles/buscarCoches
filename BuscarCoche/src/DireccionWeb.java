import java.io.Serializable;

public class DireccionWeb implements Serializable{

	
	String direccionWeb;

	public DireccionWeb(String direccionWeb) {
		super();
		this.direccionWeb = direccionWeb;
	}

	public String getDireccionWeb() {
		return direccionWeb;
	}
	
	
}
