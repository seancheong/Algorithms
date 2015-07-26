package com.sean.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {
		new QuickSort();
	}
	
	public QuickSort() {
		List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 3, 1, 8, 4, 2, 7));
		System.out.println(sort(list));
	}
	
	public List<Integer> sort(List<Integer> inputList) {
		List<Integer> outputList = new ArrayList<>();
		
		if(inputList.size() == 1) {
			outputList.add(inputList.get(0));
			
			return outputList;
		}
		
		int pivot = inputList.get(0);
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList =  new ArrayList<>();
		
		arrangePositionBasedOnPivot(inputList, pivot);
		
		split(inputList, pivot, leftList, rightList);
		
		merge(outputList, pivot, leftList, rightList);
		
		return outputList;
	}

	private void merge(List<Integer> outputList, int pivot,
			List<Integer> leftList, List<Integer> rightList) {
		if(!leftList.isEmpty()) {
			List<Integer> sortedLeftList = new ArrayList<>(sort(leftList));
			outputList.addAll(sortedLeftList);
		}
		
		outputList.add(pivot);
		
		if(!rightList.isEmpty()) {
			List<Integer> sortedRightList = new ArrayList<>(sort(rightList));
			outputList.addAll(sortedRightList);
		}
	}

	private void split(List<Integer> inputList, int pivot,
			List<Integer> leftList, List<Integer> rightList) {
		boolean right = false;
		
		for(int i = 0; i < inputList.size(); i++) {
			if(!right) {
				if(inputList.get(i) != pivot) {
					leftList.add(inputList.get(i));
					continue;
				}
				right = true;
				continue;
			}
			
			rightList.add(inputList.get(i));
		}
	}

	private void arrangePositionBasedOnPivot(List<Integer> inputList, int pivot) {
		for(int i = 1; i < inputList.size(); i++) {
			if(inputList.get(i) < pivot) {
				int temp = inputList.get(i);
				inputList.remove(i);
				inputList.add(0, temp);
			}
		}
	}
}
