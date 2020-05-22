package org.processmining.plugins.workshop.visualize_petrinet;

import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.elements.Place;
import org.processmining.models.graphbased.directed.petrinet.elements.Transition;
import org.processmining.models.graphbased.directed.petrinet.impl.PetrinetFactory;
import org.processmining.models.semantics.petrinet.Marking;

public class petrinet {
	@Plugin(
            name = "Petrinet by ERZ and RHA", 
            parameterLabels = {}, 
            returnLabels = { "Petrinet","Marking" }, 
            returnTypes = { Petrinet.class, Marking.class }, 
            userAccessible = true, 
            help = "Produces the string: 'Hello world'"
    )
    @UITopiaVariant(
            affiliation = "Telyu ya ini saya", 
            author = "ERZ & RHA", 
            email = "erza@travedia.id"
    )
    public static Object[] Petrinet(PluginContext context) {
			Petrinet net = PetrinetFactory.newPetrinet("coba");
			Transition trans = net.addTransition("hai");
			Place place = net.addPlace("start");
			net.addArc(place, trans);

			Marking mark = new Marking();
			mark.add(place);
			
            return new Object[] {net, mark};
    }
}



