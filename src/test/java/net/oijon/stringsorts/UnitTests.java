package net.oijon.stringsorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.oijon.stringsorts.algorithms.BubbleSort;
import net.oijon.stringsorts.algorithms.MergeSort;

public class UnitTests {
	
	private String[] unsortedStringArr = {"Tirana", "Andorra la Vella", "Yerevan", "Vienna", "Baku",
			"Minsk", "Brussels", "Sarajevo", "Sofia", "Zagreb", "Nicosia", "Prague", "Copenhagen",
			"Tallinn", "Helsinki", "Paris", "Tbilisi", "Berlin", "Athens", "Budapest", "Reykjavik",
			"Dublin", "Rome", "Astana", "Pristina", "Riga", "Vaduz", "Vilnius", "Luxembourg", "Valletta",
			"Chisinau", "Monaco", "Podgorica", "Amsterdam", "Skopje", "Oslo", "Warsaw", "Lisbon", "Bucharest",
			"Moscow", "San Marino", "Belgrade", "Bratislava", "Ljubljana", "Madrid", "Stockholm", "Bern",
			"Ankara", "Kiev", "London", "Vatican City"
	};
	
	private String[] sortedStringArr = {
			"Amsterdam", "Andorra la Vella", "Ankara", "Astana", "Athens", "Baku", "Belgrade", "Berlin",
			"Bern", "Bratislava", "Brussels", "Bucharest", "Budapest", "Chisinau", "Copenhagen", "Dublin",
			"Helsinki", "Kiev", "Lisbon", "Ljubljana", "London", "Luxembourg", "Madrid", "Minsk", "Monaco",
			"Moscow", "Nicosia", "Oslo", "Paris", "Podgorica", "Prague", "Pristina", "Reykjavik", "Riga",
			"Rome", "San Marino", "Sarajevo", "Skopje", "Sofia", "Stockholm", "Tallinn", "Tbilisi", "Tirana",
			"Vaduz", "Valletta", "Vatican City", "Vienna", "Vilnius", "Warsaw", "Yerevan", "Zagreb"
	};
	
	private ArrayList<String> unsortedArrayList = new ArrayList<String>();
	private ArrayList<String> sortedArrayList = new ArrayList<String>();
	
	private void initArrLists() {
		unsortedArrayList.clear();
		for (int i = 0; i < unsortedStringArr.length; i++) {
			unsortedArrayList.add(unsortedStringArr[i]);
		}
		
		sortedArrayList.clear();
		for (int i = 0; i < sortedStringArr.length; i++) {
			sortedArrayList.add(sortedStringArr[i]);
		}
	}
	
	private void verifyAlphabetical(String[] newList) {
		for (int i = 0; i < sortedStringArr.length; i++) {
			assertEquals(newList[i], sortedStringArr[i]);
		}
	}
	
	private void verifyAlphabetical(ArrayList<String> newList) {
		for (int i = 0; i < sortedArrayList.size(); i++) {
			assertEquals(newList.get(i), sortedArrayList.get(i));
		}
	}
	
	private void verifySize(String[] newList) {
		for (int i = 0; i < newList.length - 1; i++) {
			assertFalse(newList[i].length() > newList[i + 1].length());
		}
	}
	
	private void verifySize(ArrayList<String> newList) {
		for (int i = 0; i < newList.size() - 1; i++) {
			assertFalse(newList.get(i).length() > newList.get(i + 1).length());
		}
	}
	
	@Test
	void testBubbleSort() {
		initArrLists();
		
		String[] sortedSA = BubbleSort.sort(unsortedStringArr);
		ArrayList<String> sortedAL = BubbleSort.sort(unsortedArrayList);
		verifyAlphabetical(sortedSA);
		verifyAlphabetical(sortedAL);
		
		sortedSA = BubbleSort.sort(unsortedStringArr, Comparison.ALPHABETICAL);
		sortedAL = BubbleSort.sort(unsortedArrayList, Comparison.ALPHABETICAL);
		verifyAlphabetical(sortedSA);
		verifyAlphabetical(sortedAL);
		
		sortedSA = BubbleSort.sort(unsortedStringArr, Comparison.SIZE);
		sortedAL = BubbleSort.sort(unsortedArrayList, Comparison.SIZE);
		verifySize(sortedSA);
		verifySize(sortedAL);
	}
	
	@Test
	void testMergeSort() {
		initArrLists();
		
		String[] sortedSA = MergeSort.sort(unsortedStringArr);
		ArrayList<String> sortedAL = MergeSort.sort(unsortedArrayList);
		verifyAlphabetical(sortedSA);
		verifyAlphabetical(sortedAL);
		
		sortedSA = MergeSort.sort(unsortedStringArr, Comparison.ALPHABETICAL);
		sortedAL = MergeSort.sort(unsortedArrayList, Comparison.ALPHABETICAL);
		verifyAlphabetical(sortedSA);
		verifyAlphabetical(sortedAL);
		
		sortedSA = MergeSort.sort(unsortedStringArr, Comparison.SIZE);
		sortedAL = MergeSort.sort(unsortedArrayList, Comparison.SIZE);
		verifySize(sortedSA);
		verifySize(sortedAL);
	}

}
