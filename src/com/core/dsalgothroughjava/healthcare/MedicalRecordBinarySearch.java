package com.core.dsalgothroughjava.healthcare;

public class MedicalRecordBinarySearch {

	public static void main(String[] args) {
		
		int[] patientIds = {101, 204, 305, 408, 512, 609, 712};
		int targetId = 305;
		
		int index = binarySearch(patientIds, targetId);
		
		if(index != -1) {
			System.out.println("Medical record found at index : "+index);
		}else {
			System.out.println("Medical record not found");
		}
	}

	private static int binarySearch(int[] patientIds, int targetId) {
		int left = 0;
		int right = patientIds.length - 1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			//check if the target is present at the middle
			if(patientIds[mid] == targetId) {
				return mid;
			}
			//if the target is smaller, ignore the right half
			else if(patientIds[mid] > targetId) {
				right = mid - 1;
			}
			
			//if the target is larger, ignore the left half
			
			else {
				left = mid + 1;
			}
		}
		
		//target element is not present in the array
		return -1;
	}

}
