package com.core.dsalgothroughjava.healthcare;

import java.util.Arrays;

public class PatientRecordBasedOnRegTimeBubbleSort {

	public static void main(String[] args) {
		PatientRecord[] patientRecords = {
	            new PatientRecord("John", 120),
	            new PatientRecord("Alice", 90),
	            new PatientRecord("Bob", 180),
	            new PatientRecord("Emily", 60),
	            new PatientRecord("David", 150)
	        };
		
		System.out.println("before sorting");
		System.out.println(Arrays.toString(patientRecords));
		
		bubbleSort(patientRecords);
		
		System.out.println("after sorting");
		System.out.println(Arrays.toString(patientRecords));
		
	}
	
	private static void bubbleSort(PatientRecord[] patientRecord) {
		
		boolean swapped;
		
		for(int i=0; i<patientRecord.length-1; i++) {
			swapped = false;
			for(int j=0; j<patientRecord.length - i -1; j++) {
				if(patientRecord[j].getRegistrationTime() > patientRecord[j+1].getRegistrationTime()) {
					PatientRecord temp = patientRecord[j];
					patientRecord[j] = patientRecord[j+1];
					patientRecord[j+1] = temp;
					swapped = true;
				}
			}
			
			//if no swaps occured in the inner loop, the array is already sorted
			if(!swapped) {
				break;
			}
		}
		
	}
	
	static class PatientRecord{
		private String name;
		private int registrationTime;
		
		public PatientRecord(String name, int registrationTime) {
			super();
			this.name = name;
			this.registrationTime = registrationTime;
		}
		
		public int getRegistrationTime() {
			return registrationTime;
		}

		@Override
		public String toString() {
			return "PatientRecord [name=" + name + ", registrationTime=" + registrationTime + "]";
		}
		
	}

}
