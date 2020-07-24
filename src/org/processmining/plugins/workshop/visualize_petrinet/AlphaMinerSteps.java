package org.processmining.plugins.workshop.visualize_petrinet;

import java.util.ArrayList;

public class AlphaMinerSteps {

	public ArrayList<String> buatPlace(String[][] footprint, ArrayList<String> activities)  {
		//notations
		String succession = ">";
		String causality = "-->";
		String paralel = "||";
		String not = "#";
		String back_causality = "<--";
		
		//print footprint
		for(int i = 0; i < footprint.length; i++) {
			for(int j = 0; j < footprint[i].length; j++) {
				System.out.print(footprint[i][j]+ "\t");
			}
			System.out.println();
		}
		
		//step 1 -> get activities dari log
		//step 2 -> tentukan start dan end
		String start = activities.get(0);
		String end = activities.get(activities.size()-1);
		System.out.println("Start : "+start+" | End : "+end);
		
		//step 3 -> menentukan XL --> A->(B#C), A->B, (A#B)->C
		ArrayList<String> xL = new ArrayList<String>();
		for(int i = 0; i < footprint.length; i++) { //looping baris
			for(int j = 0; j < footprint[i].length; j++) { //looping kolom
				if(footprint[i][j].equals(causality)) {
					xL.add(activities.get(i)+","+activities.get(j));
				}
			}
		}
		for(int i = 0; i < footprint.length; i++) { //looping baris
			//baris
			ArrayList<Integer> causalitiesRow = new ArrayList<Integer>();
			for(int j = 0; j < footprint[i].length; j++) { //looping kolom
				if(footprint[i][j].equals(causality)) {
					causalitiesRow.add(j);
				}
			}
			for(int k = 0; k < causalitiesRow.size(); k++) {
				for(int l = k+1; l < causalitiesRow.size(); l++) {
					if(footprint[causalitiesRow.get(k)][causalitiesRow.get(l)].equals(not)) {
						xL.add(activities.get(i)+",("+activities.get(causalitiesRow.get(k))+","+activities.get(causalitiesRow.get(l))+")");
					}
				}
			}
			
			//column
			ArrayList<Integer> causalitiesColumn = new ArrayList<Integer>();
			for(int j = 0; j < footprint[i].length; j++) { //looping kolom
				if(footprint[j][i].equals(causality)) {
					causalitiesColumn.add(j);
				}
			}			
			for(int k = 0; k < causalitiesColumn.size(); k++) {
				for(int l = k+1; l < causalitiesColumn.size(); l++) {
					if(footprint[causalitiesColumn.get(k)][causalitiesColumn.get(l)].equals(not)) {
						xL.add("("+activities.get(causalitiesColumn.get(k))+","+activities.get(causalitiesColumn.get(l))+"),"+activities.get(i));
					}
				}
			}
		}
		System.out.println(xL);
		
		//step 4 -> seleksi mana yang subset
		ArrayList<String> hurufHapus = new ArrayList<String>();
		for(String index : xL){
			boolean isKurung = index.substring(2, 3).equals("("); 
			String awal = "";
			String akhir1 = "";
			String akhir2 = "";
			if(isKurung) {
				awal = index.substring(0,1);
				akhir1 = index.substring(3, 4);
				akhir2 = index.substring(5, 6);
				
				for(int i = 0; i < xL.size(); i++) {
					if(xL.get(i).equals(awal+","+akhir1) || xL.get(i).equals(awal+","+akhir2)) {
						hurufHapus.add(xL.get(i));
					}
				}
				
			}
			
			isKurung = index.substring(0, 1).equals("("); 
			String akhir = "";
			String awal1 = "";
			String awal2 = "";
			if(isKurung) {
				akhir = index.substring(6,7);
				awal1 = index.substring(1,2);
				awal2 = index.substring(3,4);
				
				for(int i = 0; i < xL.size(); i++) {
					if(xL.get(i).equals(awal1+","+akhir) || xL.get(i).equals(awal2+","+akhir)) {
						hurufHapus.add(xL.get(i));
					}
				}
				
			}
		}
		
		for(String huruf : hurufHapus) { //foreach
			for(int i = 0; i < xL.size(); i++) {
				if(huruf.equals(xL.get(i))) {
					xL.remove(i);
					break;
				}
			}
		}
		
		return xL;
		
		
	}
	
}
