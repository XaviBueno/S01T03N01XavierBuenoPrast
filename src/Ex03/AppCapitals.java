package Ex03;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class AppCapitals {

	public static void main(String[] args) {
		//Definició del HashMap
		HashMap<String,String> llistaPaisos=new HashMap<String,String>();
			
		//Demana nom usuari
		Usuari usuari= new Usuari(inputString("Introdueix el teu nom"),0);
		
		//Captura les dades de l'arxiu countries i el passa a un HashMap
		
		llistaPaisos=capturaArxiuPaisos("countries.txt");
				
		//Fa les preguntes de les diferents capitals
	
		preguntaPaisos(usuari,llistaPaisos,10);
		
		//Mostra el resultat
		System.out.println("La teva puntuació es.."+usuari.getPunts());
		
		//Desa el resulta en un arxiu
		desaReultats("classificacio.txt", usuari);
	}
	
	//Captura arxiu paissos i retorna un HashMap
	
	static HashMap<String,String> capturaArxiuPaisos(String arxiu){
		String linea;
		HashMap<String,String> llistaPaisos=new HashMap<String,String>();
		
		try {
			File arxiuCapitals= new File(arxiu);
			Scanner input= new Scanner(arxiuCapitals);
			while(input.hasNextLine()) {
				linea=input.nextLine();
				if(!linea.isBlank()) {
					String[] paisCap = linea.split(" ");
					llistaPaisos.put(paisCap[0], paisCap[1]);
				}
			}
		
		}catch(FileNotFoundException e) {
			 e.printStackTrace();
		}	
		return  llistaPaisos;
	}
	
	
	// desa en un arxiu puntuacions i noms
	
	static void desaReultats(String arxiuResultat, Usuari usuari) {
		try {
			FileWriter arxiu=new FileWriter(arxiuResultat,true);
			arxiu.write(usuari.toString()+'\n');
			
			arxiu.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		
	
	//Pregunta paisos a un usuari i comprova si ha encertat o no

	static void preguntaPaisos(Usuari usuari, HashMap<String,String> paisos, int numPaisos) {
		String capital;
		String pais;
		int index;
		ArrayList<String> paisosApreguntar=new ArrayList<String>();
		//Genera la llista de paisos a prguntar
		
		paisosApreguntar=seleccionaPaisos(paisos,numPaisos);
		
		for (index=0;index<paisosApreguntar.size();index++) {
			pais=paisosApreguntar.get(index);
			System.out.println("Capital nº "+ (index+1));
			capital=inputCapital(pais).replace(' ', '_');

			//Busca en el hashmap
			
			if(capital.equals(paisos.get(pais).toLowerCase())) {
				
				System.out.println("Has encertat");
				usuari.sumaPunt();
				
			}
			else {
				System.out.println("T'has equivocat");
				System.out.println("La capital de "+pais+" es "+paisos.get(pais));
			}
		}
	}
	

	//Retorna n paisos de manera aleatoria de un hashmap i que no es repeteixin 

	static ArrayList<String> seleccionaPaisos(HashMap<String,String> capitals, int num){
		int index;
		int loop;
		String pais;
		ArrayList<String> llistaPaisos=new ArrayList<String>() ;
		List<String> paisos=new ArrayList<String>(capitals.keySet());
		loop=0;
		
		while(loop<num) {
			//generem un nombre aleatori entre 0 i el nombre de paisos
			index= (int)(Math.random()*paisos.size());
			//Seleccionem el pais
			pais=paisos.get(index);
			//Comproba que no s'hagi repetit
			if(!llistaPaisos.contains(pais)) {
				llistaPaisos.add(pais);
				++loop;
			}
			
		}
		return llistaPaisos;

	}

	//Demana  capital

	static String inputCapital(String pais) {
		
		return inputString("Entra la capital de "+pais+":").toLowerCase();
		
		
		
	}

	//Demana un string i mostra missatge
	static String inputString(String missatge) {
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		return input.nextLine();
	}

}
