package org.processmining.plugins.workshop.visualize_petrinet;

import java.util.ArrayList;

import org.deckfour.xes.model.XEvent;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;
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
		
		XTrace traces = log.get(0);
		ArrayList<String> activityList = new ArrayList<String>();
		String temp = ""; //store list in string
		for	(int i = 0; i < traces.size(); i++)
		{
			XEvent event = traces.get(i);
			String nameActivity = event.getAttributes().get("Activity").toString();
			boolean isDiff = true;
			for (int j = 0; j < activityList.size(); j++)
			{
				if(activityList.get(j).equalsIgnoreCase(nameActivity))
				{
					isDiff = false;
				}
			}
			
			if(isDiff)
			{
				activityList.add(nameActivity);
				temp = temp +" - "+ nameActivity;
			}
		}
		
		return temp;
	}
}
