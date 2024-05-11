package net.oijon.stringsorts.algorithms;

import java.util.ArrayList;

import net.oijon.stringsorts.Comparer;
import net.oijon.stringsorts.Comparison;

public class BubbleSort {

	
	public static ArrayList<String> sort(ArrayList<String> list) {
		return sort(list, Comparison.ALPHABETICAL);
	}

	
	public static String[] sort(String[] list) {
		return sort(list, Comparison.ALPHABETICAL);
	}

	
	public static ArrayList<String> sort(ArrayList<String> list, Comparison mode) {
		Comparer c = new Comparer(mode);
		ArrayList<String> newList = new ArrayList<String>(list);
		for (int i = 0; i < list.size() - 1; i++) {
			if (c.compare(newList.get(i), newList.get(i + 1)) == 1) {
				String placeholder = newList.get(i);
				newList.set(i, newList.get(i + 1));
				newList.set(i + 1, placeholder);
				i = -1;
			}
		}
		return newList;
	}

	
	public static String[] sort(String[] list, Comparison mode) {
		Comparer c = new Comparer(mode);
		String[] newList = new String[list.length];
		
		for (int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		
		for (int i = 0; i < list.length - 1; i++) {
			if (c.compare(newList[i], newList[i + 1]) == 1) {
				String placeholder = newList[i];
				newList[i] = newList[i + 1];
				newList[i + 1] = placeholder;
				i = -1;
			}
		}
		return newList;
	}

}
