package org.processmining.plugins.workshop.visualize_petrinet;

import java.util.ArrayList;

import org.deckfour.xes.model.XLog;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;

public class VisualizePetrinet {
	@Plugin(
            name = "Visualize Petrinet", 
            parameterLabels = {"XLog"}, 
            returnLabels = { "Matrix"}, 
            returnTypes = { String.class}, 
            userAccessible = true, 
            help = "visualize"
    )
    @UITopiaVariant(
            affiliation = "Gebang Raya University", 
            author = "ERZ & RHA", 
            email = "contact@erzaputra.com"
    )
	public static String convert(PluginContext context, XLog log) {
		
		//notations
		String succession = ">";
		String causality = "-->";
		String paralel = "||";
		String not = "#";
		String back_causality = "<--";
		
		Footprint footprint = new Footprint();
		String[][] footprintArray = footprint.buatFootprint(log);
		System.out.println("Bentuk terakhir dari object footprint");
		for(int i = 0; i < footprintArray.length; i++) {
			for(int j = 0; j < footprintArray[i].length; j++) {
				System.out.print(footprintArray[i][j]+ "\t");
			}
			System.out.println();
		}
		
		AlphaMinerSteps Alpha = new AlphaMinerSteps();
		Activity act = new Activity();
		ArrayList<String> placeArray = Alpha.buatPlace(footprintArray, act.getActivities(log));
		String places = "";
		for (String  place : placeArray) {
			places += place+" - ";
		}
		
		System.out.println(places);

		return places;
		
	}
}
