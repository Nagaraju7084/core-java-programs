package com.core.dsalgothroughjava.healthcare;

public class DiagnosisMergeSort {

	public static void main(String[] args) {

		String[] diagnosisCodes = {
				"A01",
                "B12",
                "C56",
                "B02",
                "A10",
                "C08"
		};
		
		System.out.println("before sorting");
		for(String code : diagnosisCodes) {
			System.out.println(code);
		}
		
		//sort the diagnosis codes
		mergeSortOrdivide(diagnosisCodes, 0, diagnosisCodes.length-1);
		
		System.out.println("after sorting");
		for(String code : diagnosisCodes) {
			System.out.println(code);
		}
		
	}
	
	private static void mergeSortOrdivide(String[] diagnosisCodes, int si, int ei) {
		if(si >= ei) {
			return;
		}
		
		int mid = si + (ei - si) / 2;
		
		mergeSortOrdivide(diagnosisCodes, si, mid);
		mergeSortOrdivide(diagnosisCodes, mid + 1, ei);
		conquer(diagnosisCodes, si, mid, ei);
	}
	
	private static void conquer(String[] diagnosisCodes, int si, int mid, int ei) {
		String[] merged = new String[ei - si + 1];
		
		int idx1 = si;
		int idx2 = mid + 1;
		int x = 0;
		
		while(idx1 <= mid && idx2 <= ei) {
			if(diagnosisCodes[idx1].compareTo(diagnosisCodes[idx2]) <= 0) {
				merged[x++] = diagnosisCodes[idx1++];
			}else {
				merged[x++] = diagnosisCodes[idx2++];
			}
		}
		
		//copy remaining elements from left array
		while(idx1 <= mid) {
			merged[x++] = diagnosisCodes[idx1++];
		}
		
		//copy remaining elements from right array
		while(idx2 <= ei) {
			merged[x++] = diagnosisCodes[idx2++];
		}
		
		//copying elements from merged array to original array
		for(int i=0, j=si; i<merged.length; i++, j++) {
			diagnosisCodes[j] = merged[i];
		}
		
		merged = null;
	}
	
}
