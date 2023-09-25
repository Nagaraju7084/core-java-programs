package com.psystem;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();        
	    int maxDaysInMonth = c.getMaximum(Calendar.DAY_OF_MONTH);
	    int firstMonday = c.get(Calendar.MONDAY); // first monday in the month (Beware, 0 is the first day of the month)
	    int mondays = 0;
	    int i=firstMonday;
	    while(i<maxDaysInMonth){
	        mondays++;
	        i+=7;
	    };
	    System.out.println(mondays);
		
		Map<Integer, String> daysMap = new HashMap<>();
		
		daysMap.put(1, "Monday");
		daysMap.put(2, "Tueseday");
		daysMap.put(3, "Wednesday");
		daysMap.put(4, "Thursday");
		daysMap.put(5, "Fridaday");
		daysMap.put(6, "Saterday");
		daysMap.put(7, "Sunday");
		daysMap.put(8, "Monday");
		daysMap.put(9, "Tueseday");
		daysMap.put(10, "Wednesday");
		daysMap.put(11, "Thursday");
		daysMap.put(12, "Fridaday");
		daysMap.put(13, "Saterday");
		daysMap.put(14, "Sunday");
		
		
		for(Map.Entry<Integer, String> entry : daysMap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			
			if(value.equalsIgnoreCase("Monday") ) {
				System.out.println("Monday :\t" + value + "day:\t"+key); //
				//4 phases
				//1st phase
				//enroll the students into the school
				//enroll the students into the school diff exams
				//publish the
				//certificate
			}
		}
	}
}