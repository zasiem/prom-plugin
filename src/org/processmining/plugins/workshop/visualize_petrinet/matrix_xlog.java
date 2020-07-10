package org.processmining.plugins.workshop.visualize_petrinet;

import org.deckfour.xes.model.XLog;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;

public class matrix_xlog {
	@Plugin(
            name = "Matrix Xlog", 
            parameterLabels = {"XLog"}, 
            returnLabels = { "Matrix"}, 
            returnTypes = { String.class}, 
            userAccessible = true, 
            help = "Membuat matrix dari xlog"
    )
    @UITopiaVariant(
            affiliation = "Gebang Raya University", 
            author = "ERZ & RHA", 
            email = "contact@erzaputra.com"
    )
	public static String convert(PluginContext context, XLog log) {
		
		Footprint footprint = new Footprint();
		String[][] footprintArray = footprint.buatFootprint(log);
		System.out.println("Bentuk terakhir dari object footprint");
		for(int i = 0; i < footprintArray.length; i++) {
			for(int j = 0; j < footprintArray[i].length; j++) {
				System.out.print(footprintArray[i][j]+ "\t");
			}
			System.out.println();
		}
		
		return "Berhasil";
		
	}
}
