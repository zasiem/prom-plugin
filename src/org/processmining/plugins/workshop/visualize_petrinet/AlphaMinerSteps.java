package org.processmining.plugins.workshop.visualize_petrinet;

public class AlphaMinerSteps {

	public static void main(String[] erzagantengidaman) {
		
		//notations
		String succession = ">";
		String causality = "-->";
		String paralel = "||";
		String not = "#";
		String back_causality = "<--";
		
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
		
		for(int i = 0; i < footprintExample.length; i++) {
			for(int j = 0; j < footprintExample[i].length; j++) {
				System.out.print(footprintExample[i][j]+ "\t");
			}
			System.out.println();
		}
		
		
	}
	
}
