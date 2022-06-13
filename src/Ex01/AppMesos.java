package Ex01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
public class AppMesos {

	public static void main(String[] args) {
		ArrayList<Month> mesos =new ArrayList<Month>();
		HashSet<Month> mesosHashSet = new HashSet<Month>();
		
		int index;
		String sortida="";
		
		ArrayList<Integer> lista = new ArrayList<>();
	    
	    //Metodo add. añade elementos a nuestra lista
	    lista.add(1);
	    lista.add(2);
	    lista.add(3);
		
	    afegirMes("gener",mesos,0);
	    afegirMes("febrer",mesos,1);
	    afegirMes("març",mesos,2);	
	    afegirMes("abril",mesos,3);
	    afegirMes("maig",mesos,4);
	    afegirMes("juny",mesos,5);
	    afegirMes("juliol",mesos,6);
	    afegirMes("setembre",mesos,7);
	    afegirMes("octubre",mesos,8);
	    afegirMes("novembre",mesos,9);
	    afegirMes("desembre",mesos,10);
		
		//Imprimeix els mesos
		
			    
	    for(index=0;index<mesos.size();index++) {
			sortida+= mesos.get(index).getMonth()+'\n';
		}
		System.out.println(sortida);
		
		
		
		//Inserta el mes d'agost
		afegirMes("agost",mesos,7);
	
		 
	
		//Imprimeix resultat, comprovar que s'ha afegit correctamen
		
		sortida="";
			System.out.println("S'HA INSERTAT EL MES D'AGOST");	 
		 for(index=0;index<mesos.size();index++) {
				sortida+= mesos.get(index).getMonth()+'\n';
			}
			System.out.println(sortida);
	
		
		//Transforma l'arrayList en un HashSet
		
			
			mesosHashSet.addAll(mesos);
			
			//Afegim diversos elements per comprovar que no es repeteix
		
			mesosHashSet.add(mesos.get(0));
			mesosHashSet.add(mesos.get(1));
			mesosHashSet.add(mesos.get(2));
			mesosHashSet.add(mesos.get(3));
			mesosHashSet.add(mesos.get(9));
			
		
		System.out.println("IMPRIMIM EL HASHSET PER COMPROVAR QUE NO  ES REPETEIXEN AMB UN FOR");
		
		
		for(Month mes:mesosHashSet) {
			System.out.println(mes.getMonth());
		}
		
		System.out.println("IMPRIMIM EL HASHSET PER COMPROVAR QUE NO  ES REPETEIXEN AMB UN ITERADOR");
		
		Iterator<Month> mesosIt=mesosHashSet.iterator();
		while(mesosIt.hasNext()) {
			  System.out.println(mesosIt.next().getMonth());
			}
		
		
		
	}	
	
	//Desa un mes en l'ArrayList de mesos
	
	public static void afegirMes(String mes,ArrayList<Month> mesos,int index ) {
		Month month=new Month(mes);
		mesos.add(index,month);
		
	}
	
}
