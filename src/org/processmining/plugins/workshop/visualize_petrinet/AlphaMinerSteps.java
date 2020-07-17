package org.processmining.plugins.workshop.visualize_petrinet;

import java.util.ArrayList;

public class AlphaMinerSteps {

	public static void main(String[] erzagantengidaman) {
		
		//notations
		String succession = ">";
		String causality = "-->";
		String paralel = "||";
		String not = "#";
		String back_causality = "<--";
		
		//inisialisasi footprint based on book
		String[][] footprintExample = new String[6][6];
		footprintExample[0][0] = not;
		footprintExample[0][1] = causality;
		footprintExample[0][2] = not;
		footprintExample[0][3] = not;
		footprintExample[0][4] = causality;
		footprintExample[0][5] = not;
		//
		footprintExample[1][0] = back_causality;
		footprintExample[1][1] = not;
		footprintExample[1][2] = causality;
		footprintExample[1][3] = back_causality;
		footprintExample[1][4] = paralel;
		footprintExample[1][5] = causality;
		//
		footprintExample[2][0] = not;
		footprintExample[2][1] = back_causality;
		footprintExample[2][2] = not;
		footprintExample[2][3] = causality;
		footprintExample[2][4] = paralel;
		footprintExample[2][5] = not;
		//
		footprintExample[3][0] = not;
		footprintExample[3][1] = causality;
		footprintExample[3][2] = back_causality;
		footprintExample[3][3] = not;
		footprintExample[3][4] = paralel;
		footprintExample[3][5] = not;
		//
		footprintExample[4][0] = back_causality;
		footprintExample[4][1] = paralel;
		footprintExample[4][2] = paralel;
		footprintExample[4][3] = paralel;
		footprintExample[4][4] = not;
		footprintExample[4][5] = causality;
		//
		footprintExample[5][0] = not;
		footprintExample[5][1] = back_causality;
		footprintExample[5][2] = not;
		footprintExample[5][3] = not;
		footprintExample[5][4] = back_causality;
		footprintExample[5][5] = not;
		
		//inisialisasi aktivitas based on book
		String[] activities = new String[]{
			"A","B","C","D","E","F"
		};
		
		//print footprint
		for(int i = 0; i < footprintExample.length; i++) {
			for(int j = 0; j < footprintExample[i].length; j++) {
				System.out.print(footprintExample[i][j]+ "\t");
			}
			System.out.println();
		}
		
		//step 1 -> get activities dari log
		//step 2 -> tentukan start dan end
		String start = activities[0];
		String end = activities[activities.length-1];
		System.out.println("Start : "+start+" | End : "+end);
		
		//step 3 -> menentukan XL --> A->(B#C), A->B, (A#B)->C
		ArrayList<String> xL = new ArrayList<String>();
		for(int i = 0; i < footprintExample.length; i++) { //looping baris
			for(int j = 0; j < footprintExample[i].length; j++) { //looping kolom
				if(footprintExample[i][j].equals(causality)) {
					xL.add("{"+activities[i]+","+activities[j]+"}");
				}
			}
		}
		for(int i = 0; i < footprintExample.length; i++) { //looping baris
			//baris
			ArrayList<Integer> causalitiesRow = new ArrayList<Integer>();
			for(int j = 0; j < footprintExample[i].length; j++) { //looping kolom
				if(footprintExample[i][j].equals(causality)) {
					causalitiesRow.add(j);
				}
			}
			for(int k = 0; k < causalitiesRow.size(); k++) {
				for(int l = k+1; l < causalitiesRow.size(); l++) {
					if(footprintExample[causalitiesRow.get(k)][causalitiesRow.get(l)].equals(not)) {
						xL.add("{"+activities[i]+",("+activities[causalitiesRow.get(k)]+","+activities[causalitiesRow.get(l)]+")}");
					}
				}
			}
			
			//column
			ArrayList<Integer> causalitiesColumn = new ArrayList<Integer>();
			for(int j = 0; j < footprintExample[i].length; j++) { //looping kolom
				if(footprintExample[j][i].equals(causality)) {
					causalitiesColumn.add(j);
				}
			}			
			for(int k = 0; k < causalitiesColumn.size(); k++) {
				for(int l = k+1; l < causalitiesColumn.size(); l++) {
					if(footprintExample[causalitiesColumn.get(k)][causalitiesColumn.get(l)].equals(not)) {
						xL.add("{("+activities[causalitiesColumn.get(k)]+","+activities[causalitiesColumn.get(l)]+"),"+activities[i]+"}");
					}
				}
			}
		}
		System.out.println(xL);
		
		//step 4 -> seleksi mana yang subset
		
	}
	
}
