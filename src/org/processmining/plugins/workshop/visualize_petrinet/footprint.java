package org.processmining.plugins.workshop.visualize_petrinet;

import java.util.ArrayList;

public class footprint {

	public static void main(String args[]) {
		//notations
		String succession = ">";
		String causality = "-->";
		String paralel = "||";
		String not = "#";
		String back_causality = "<--";
		
		//data
		ArrayList<String> case1 = new ArrayList<String>();
		case1.add("Z");
		case1.add("A");
		case1.add("A");
		case1.add("A");
		case1.add("B");
		case1.add("C");
		case1.add("A");
		case1.add("A");
		case1.add("A");
		case1.add("X");
		ArrayList<String> case2 = new ArrayList<String>();
		case2.add("Z");
		case2.add("A");
		case2.add("A");
		case2.add("A");
		case2.add("A");
		case2.add("B");
		case2.add("A");
		case2.add("C");
		case2.add("A");
		case2.add("A");
		case2.add("X");
		
		ArrayList<ArrayList<String>> cases = new ArrayList<ArrayList<String>>();
		cases.add(case1);
		cases.add(case2);
		
		System.out.println(cases);
		
		//pembuatan array list activities untuk label matrix
		ArrayList<String> activities = new ArrayList<String>();
		for (ArrayList<String>  kasus : cases) {
			for (String activity : kasus) {
				if(!activities.contains(activity)) {
					activities.add(activity);
				}
			}
		}
		
		System.out.println(activities);
		
		//membuat matriks 2 dimensi seukuran activities
		String[][] matrix = new String[activities.size()][activities.size()];
		
		//mengecek succession
		for(int i = 0; i < activities.size(); i++) {
			for(int j = 0; j < activities.size(); j++) {

				String activity_baris = activities.get(i);
				String activity_kolom = activities.get(j);
				
				boolean isSuccession = false;
				for (ArrayList<String>  kasus : cases) {
					//k adalah index posisi dari kasus
					for(int k = 0; k < kasus.size()-1; k++) {
						if(kasus.get(k).equals(activity_baris) 
							&& kasus.get(k+1).equals(activity_kolom)) {
							matrix[i][j] = succession;
							isSuccession = true;
						}
					}
					
					if (!isSuccession) {
						matrix[i][j] = not;
					}
					
				}
				
			}
		}
		
		for(int i = 0; i < activities.size(); i++) {
			for(int j = 0; j < activities.size(); j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		
		String[][] matrixLast = new String[activities.size()][activities.size()];
		for(int i = 0; i < activities.size(); i++) {
			for(int j = 0; j < activities.size(); j++) {
				if (matrix[i][j].equals(">") && matrix[j][i].equals(">")) {
					matrixLast[i][j] = paralel;
				}else if(matrix[i][j].equals(">") && matrix[j][i].equals("#")) {
//					if	(matrixLast[j][i].equals(causality)) {
//						matrixLast[i][j] = back_causality;
//					}else {
						matrixLast[i][j] = causality;
//					}
				}else { //hestek doang
					matrixLast[i][j] = not;
				}
			}
		}
		
		System.out.println("bentuk terakhir");
		for(int i = 0; i < activities.size(); i++) {
			for(int j = 0; j < activities.size(); j++) {
			System.out.print(matrixLast[i][j]+ "\t");
			}
			System.out.println();
		}
		
		
	}
	
}
