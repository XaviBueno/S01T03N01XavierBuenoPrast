package Ex03;

public class Usuari {
	//Atributs
	private String nom;
	private int puntuacio;
	
	//Constructor
	public Usuari(String nom, int puntuacio) {
		this.nom=nom;
		this.puntuacio=puntuacio;
	}
	//Seters 6 getters
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public int getPunts() {
		return puntuacio;
	}
	
	//Mètodes
	
	public void sumaPunt() {
		puntuacio++;
	}

	
	public String toString(){
		
		return nom+" "+puntuacio;
	}

}
