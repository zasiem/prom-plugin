package org.processmining.plugins.workshop.visualize_petrinet;

import java.util.ArrayList;

import org.deckfour.xes.model.XEvent;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;

public class Activity {

	public ArrayList<String> getActivities(XLog log)
	{
		ArrayList<ArrayList<String>> cases = new ArrayList<ArrayList<String>>();
		for(XTrace trace : log) {
			ArrayList<String> caseTemp = new ArrayList<String>();
			for(XEvent event : trace) {
				String nameActivity = event.getAttributes().get("Activity").toString();
				caseTemp.add(nameActivity);
			}
			cases.add(caseTemp);
		}

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
		
		return activities;
	}
	
}
