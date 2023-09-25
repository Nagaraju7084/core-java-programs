package com.core.dsalgothroughjava.healthcare;

public class PatientRecordQuickSort {
    // Define a class to represent a Patient Record
    public static class PatientRecord {
        private int id;
        private String name;
        private int age;
        private String condition;

        public PatientRecord(int id, String name, int age, String condition) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.condition = condition;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCondition() {
            return condition;
        }
    }

    // Function to perform Quick Sort on the array
    public static void quickSort(PatientRecord[] records, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(records, low, high);

            // Recursively sort the sub-arrays
            quickSort(records, low, pivotIndex - 1);
            quickSort(records, pivotIndex + 1, high);
        }
    }

    // Function to partition the array and return the pivot index
    private static int partition(PatientRecord[] records, int low, int high) {
        // Choose the rightmost element as the pivot
        PatientRecord pivot = records[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot, swap them
            if (records[j].getId() <= pivot.getId()) {
                i++;
                swap(records, i, j);
            }
        }

        // Swap the pivot element with the element at the correct position
        swap(records, i + 1, high);

        // Return the pivot index
        return i + 1;
    }

    // Function to swap two elements in the array
    private static void swap(PatientRecord[] records, int i, int j) {
        PatientRecord temp = records[i];
        records[i] = records[j];
        records[j] = temp;
    }

    public static void main(String[] args) {
        // Create a sample array of PatientRecord objects
        PatientRecord[] records = {
                new PatientRecord(102, "John", 30, "Fever"),
                new PatientRecord(105, "Sarah", 45, "Heart Disease"),
                new PatientRecord(101, "David", 55, "Diabetes"),
                new PatientRecord(104, "Emma", 20, "Injury"),
                new PatientRecord(103, "Michael", 40, "Asthma")
        };

        System.out.println("Before sorting:");
        for (PatientRecord record : records) {
            System.out.println("ID: " + record.getId() +
                    ", Name: " + record.getName() +
                    ", Age: " + record.getAge() +
                    ", Condition: " + record.getCondition());
        }

        // Sort the patient records
        quickSort(records, 0, records.length - 1);

        System.out.println("\nAfter sorting:");
        for (PatientRecord record : records) {
            System.out.println("ID: " + record.getId() +
                    ", Name: " + record.getName() +
                    ", Age: " + record.getAge() +
                    ", Condition: " + record.getCondition());
        }
    }
}