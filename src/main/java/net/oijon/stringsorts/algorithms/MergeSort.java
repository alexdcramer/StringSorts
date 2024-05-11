package net.oijon.stringsorts.algorithms;

import java.util.ArrayList;

import net.oijon.stringsorts.Comparer;
import net.oijon.stringsorts.Comparison;

public class MergeSort {

	public static ArrayList<String> sort(ArrayList<String> list) {
		return sort(list, Comparison.ALPHABETICAL);
	}

	public static String[] sort(String[] list) {
		return sort(list, Comparison.ALPHABETICAL);
	}

	public static ArrayList<String> sort(ArrayList<String> list, Comparison mode) {
		// split
		
		ArrayList<String> listA = new ArrayList<String>();
		ArrayList<String> listB = new ArrayList<String>();
				
		if (list.size() > 1) {
			int halfpoint = list.size() / 2;
			for (int i = 0; i < halfpoint; i++) {
				listA.add(list.get(i));
			}
			for (int i = 0; i < list.size() - halfpoint; i++) {
				listB.add(list.get(i + halfpoint));
			}
			listA = sort(listA, mode);
			listB = sort(listB, mode);
			
		}
			
		// merge
		ArrayList<String> mergedList = new ArrayList<String>();
		
		String minA = listA.get(0);
		String maxA = listA.get(listA.size() - 1);
		String minB = listB.get(0);
		String maxB = listB.get(listB.size() - 1);
		
		Comparer c = new Comparer(mode);
		
		// speeds things up if the split lists can rather simply be added together
		
		if (c.compare(maxA, minB) == -1) {
			for (int i = 0; i < listA.size(); i++) {
				mergedList.add(listA.get(i));
			}
			for (int i = 0; i < listB.size(); i++) {
				mergedList.add(listB.get(i));;
			}
		} else if (c.compare(maxB, minA) == -1) {
			for (int i = 0; i < listB.size(); i++) {
				mergedList.add(listB.get(i));
			}
			for (int i = 0; i < listA.size(); i++) {
				mergedList.add(listA.get(i));
			}
		} else {
			// lists cannot be trivially merged, must instead check each entry
			int indexA = 0;
			int indexB = 0;
			
			for (int i = 0; i < list.size(); i++) {
				if (indexA < listA.size() & indexB < listB.size()) {
					int compNum = c.compare(listA.get(indexA), listB.get(indexB));
					switch (compNum) {
						case -1:
							mergedList.set(i, listB.get(indexB));
							indexB++;
							break;
						default:
							// prioritizes list A if two components are equal, on next iteration it will grab from B if it also isn't equal
							mergedList.set(i, listA.get(indexA));
							indexA++;
							break;
					}
				} else if (indexA >= listA.size()) {
					mergedList.set(i, listB.get(indexB));
					indexB++;
				} else if (indexB >= listB.size()) {
					mergedList.set(i, listA.get(indexA));
					indexA++;
				}
			}
		}		
		return mergedList;
	}

	public static String[] sort(String[] list, Comparison mode) {
		// split
		
		String[] listA = new String[0];
		String[] listB = new String[0];
		
		if (list.length > 1) {
			int halfpoint = list.length / 2;
			listA = new String[halfpoint];
			listB = new String[list.length - halfpoint];
			for (int i = 0; i < halfpoint; i++) {
				listA[i] = list[i];
			}
			for (int i = 0; i < list.length - halfpoint; i++) {
				listB[i] = list[i + halfpoint];
			}
			listA = sort(listA, mode);
			listB = sort(listB, mode);
			
		}
		
		// merge
		String[] mergedList = new String[list.length];
		
		String minA = listA[0];
		String maxA = listA[listA.length - 1];
		String minB = listB[0];
		String maxB = listB[listB.length - 1];
		
		Comparer c = new Comparer(mode);
		
		// speeds things up if the split lists can rather simply be added together
		
		if (c.compare(maxA, minB) == -1) {
			for (int i = 0; i < listA.length; i++) {
				mergedList[i] = listA[i];
			}
			for (int i = 0; i < listB.length; i++) {
				mergedList[i + listA.length] = listB[i];
			}
		} else if (c.compare(maxB, minA) == -1) {
			for (int i = 0; i < listB.length; i++) {
				mergedList[i] = listB[i];
			}
			for (int i = 0; i < listA.length; i++) {
				mergedList[i + listB.length] = listA[i];
			}
		} else {
			// lists cannot be trivially merged, must instead check each entry
			int indexA = 0;
			int indexB = 0;
			
			for (int i = 0; i < list.length; i++) {
				if (indexA < listA.length & indexB < listB.length) {
					int compNum = c.compare(listA[indexA], listB[indexB]);
					switch (compNum) {
						case -1:
							mergedList[i] = listB[indexB];
							indexB++;
							break;
						default:
							// prioritizes list A if two components are equal, on next iteration it will grab from B if it also isn't equal
							mergedList[i] = listA[indexA];
							indexA++;
							break;
					}
				} else if (indexA >= listA.length) {
					mergedList[i] = listB[indexB];
					indexB++;
				} else if (indexB >= listB.length) {
					mergedList[i] = listA[indexA];
					indexA++;
				}
			}
		}
		
		
		return mergedList;
	}

}
