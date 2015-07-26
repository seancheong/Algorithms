package com.sean.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		new MergeSort();
	}
	
	public MergeSort() {
		List<Integer> list = new ArrayList<>(Arrays.asList(23, 8, 63, 4, 21, 77, 15, 3));
		System.out.println(sort(list));
	}
	
	public List<Integer> sort(List<Integer> inputList) {
		List<Integer> outputList = new ArrayList<>();
		
		if(inputList.size() == 1) {
			outputList.add(inputList.get(0));
			return outputList;
		}
		
		if(inputList.size() == 2) {
			if(inputList.get(0) < inputList.get(1)) {
				outputList.add(inputList.get(0));
				outputList.add(inputList.get(1));
			}
			else {
				outputList.add(inputList.get(1));
				outputList.add(inputList.get(0));
			}
			
			return outputList;
		}
		
		List<Integer> aSortedList;
		List<Integer> bSortedList;
		
		int aListSize = inputList.size() / 2;
		
		List<Integer> aTempList = new ArrayList<>();
		List<Integer> bTempList = new ArrayList<>();
			
		split(inputList, aListSize, aTempList, bTempList);
		
		aSortedList = new ArrayList<>(sort(aTempList));
		bSortedList = new ArrayList<>(sort(bTempList));
		
		merge(inputList, outputList, aSortedList, bSortedList);
		
		return outputList;
	}

	private void split(List<Integer> inputList, int aListSize,
			List<Integer> aTempList, List<Integer> bTempList) {
		for(int i = 0; i < inputList.size(); i++) {
			if(i < aListSize) {
				aTempList.add(inputList.get(i));
				continue;
			}
			bTempList.add(inputList.get(i));
		}
	}

	private void merge(List<Integer> inputList, List<Integer> outputList,
			List<Integer> aSortedList, List<Integer> bSortedList) {
		int aIteration = 0;
		int bIteration = 0;
		
		for(int k = 0; k < inputList.size(); k++) {
			if(aIteration >= aSortedList.size()) {
				outputList.add(bSortedList.get(bIteration));
				bIteration++;
			}
			else if(bIteration >= bSortedList.size()) {
				outputList.add(aSortedList.get(aIteration));
				aIteration++;
			}
			else {
				if(aSortedList.get(aIteration) < bSortedList.get(bIteration)) {
					outputList.add(aSortedList.get(aIteration));
					aIteration++;
				}
				else {
					outputList.add(bSortedList.get(bIteration));
					bIteration++;
				}
			}
		}
	}

}
