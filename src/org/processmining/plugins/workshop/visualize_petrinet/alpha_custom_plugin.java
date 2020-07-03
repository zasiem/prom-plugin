package org.processmining.plugins.workshop.visualize_petrinet;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import org.deckfour.xes.model.XLog;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;

public class alpha_custom_plugin {
	@Plugin(
            name = "Alpha custom plugin", 
            parameterLabels = {"XLog"}, 
            returnLabels = { "Petrinet" }, 
            returnTypes = { Petrinet.class}, 
            userAccessible = true, 
            help = "custom alpha plugin"
    )
    @UITopiaVariant(
            affiliation = "Gebang Raya University", 
            author = "ERZ & RHA", 
            email = "contact@erzaputra.com"
    )
	public static Petrinet convert(PluginContext context, XLog log) {
		
		AlphaMinerPlugin alpha = new AlphaMinerPlugin();
		
		Object[] objects = new Object[] { 
                Petrinet.class, //index 0 
        }; 
		
		try {
			objects = alpha.doMining(context, log) ;
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (Petrinet) objects[0];
		
	}
}
