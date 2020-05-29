package org.processmining.plugins.workshop.visualize_petrinet;

import org.deckfour.xes.model.XEvent;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.elements.Place;
import org.processmining.models.graphbased.directed.petrinet.elements.Transition;
import org.processmining.models.graphbased.directed.petrinet.impl.PetrinetFactory;

public class xlog_to_petrinet {

	@Plugin(
            name = "Xlog to Petrinet", 
            parameterLabels = {"XLog"}, 
            returnLabels = { "Petrinet"}, 
            returnTypes = { Petrinet.class}, 
            userAccessible = true, 
            help = "Mengubah XLog pertama menjadi petrinet"
    )
    @UITopiaVariant(
            affiliation = "Gebang Raya University", 
            author = "ERZ & RHA", 
            email = "contact@erzaputra.com"
    )
	public static Petrinet convert(PluginContext context, XLog log) {
		
		//inisialisasi petrinet
		Petrinet net = PetrinetFactory.newPetrinet("coba");
		Place placeStart = net.addPlace("start");
		Place placeEnd = net.addPlace("end");
		Transition trans = null;
		
		XTrace traces = log.get(0);
		
		for (int i = 0; i < traces.size(); i++)
		{
			
			XEvent event = traces.get(i);
			String nameEvent = event.getAttributes().get("Activity").toString();
			if	(nameEvent.equalsIgnoreCase("start")) {
				trans = net.addTransition(nameEvent);
				net.addArc(placeStart, trans);
			} else {
				Place tmp = net.addPlace("");
				net.addArc(trans, tmp);
				trans = net.addTransition(nameEvent);
				net.addArc(tmp, trans);
				if	(nameEvent.equalsIgnoreCase("end")) {
					net.addArc(trans,placeEnd);
				}
			}
		}

        return net;
	}
	
}
