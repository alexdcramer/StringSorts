package net.oijon.stringsorts;

import java.util.ArrayList;

public class BubbleSort extends SortingAlgorithm {

	@Override
	public ArrayList<String> sort(ArrayList<String> list) {
		return sort(list, Comparison.ALPHABETICAL);
	}

	@Override
	public String[] sort(String[] list) {
		return sort(list, Comparison.ALPHABETICAL);
	}

	@Override
	public ArrayList<String> sort(ArrayList<String> list, Comparison mode) {
		Comparer c = new Comparer(mode);
		ArrayList<String> newList = new ArrayList<String>(list);
		for (int i = 0; i < list.size() - 1; i++) {
			if (c.compare(newList.get(i), newList.get(i + 1)) == -1) {
				String placeholder = newList.get(i);
				newList.set(i, newList.get(i + 1));
				newList.set(i + 1, placeholder);
				i = 0;
			}
		}
		return newList;
	}

	@Override
	public String[] sort(String[] list, Comparison mode) {
		Comparer c = new Comparer(mode);
		String[] newList = new String[list.length];
		
		for (int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		
		for (int i = 0; i < list.length - 1; i++) {
			if (c.compare(newList[i], newList[i + 1]) == -1) {
				String placeholder = newList[i];
				newList[i] = newList[i + 1];
				newList[i + 1] = placeholder;
				i = 0;
			}
		}
		return newList;
	}

}
