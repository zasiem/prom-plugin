package org.processmining.plugins.workshop.visualize_petrinet;

import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;

public class petrinet {
	@Plugin(
            name = "Petrinet by Erza Ganteng", 
            parameterLabels = {}, 
            returnLabels = { "Hello world string" }, 
            returnTypes = { String.class }, 
            userAccessible = true, 
            help = "Produces the string: 'Hello world'"
    )
    @UITopiaVariant(
            affiliation = "Telyu ya ini saya", 
            author = "ERZ", 
            email = "erza@travedia.id"
    )
    public static String Petrinet(PluginContext context) {
            return "Percobaan";
    }
}



