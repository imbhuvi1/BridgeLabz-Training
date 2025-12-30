class EMC_UC1 {

	// UC-1 Check if Employee is Present Or Absent using Random()
	public int getAttendance() {
		return (int) (Math.random() * 3);
	}
}

class EWC_UC2 {
	
	// UC-1 Check if Employee is Present Or Absent using Random()
	public int getAttendance() {
		return (int) (Math.random() * 3);
	}
	
	// UC-2 Full-Time Employee Daily Wage Calculation
	public int getDailyWage() {
		final int FULL_TIME_HOURS = 8;
		final int WAGE_PER_HOUR = 20;
		
		int attendance = getAttendance();
		int dailyHours = 0;
		
		if(attendance > 0) {
			dailyHours = FULL_TIME_HOURS;
		}

		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}
}

class EWC_UC3 {
	
	// UC-1 Check if Employee is Present Or Absent using Random()
	public int getAttendance() {
		return (int) (Math.random() * 3);
	}
	
	// UC-3 Part-Time Employee Wage Calculation
	public int getDailyWage() {
		final int PART_TIME_HOURS = 4;
		final int WAGE_PER_HOUR = 20;
		
		int attendance = getAttendance();
		int dailyHours = 0;
		
		if(attendance > 0) {
			dailyHours = PART_TIME_HOURS;
		}

		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}
}

class EWC_UC4 {
	// UC-1 Check if Employee is Present Or Absent using Random()
	public int getAttendance() {
		return (int) (Math.random() * 3);
	}

	// UC-2 Full-Time Employee Daily Wage Calculation
	public int getDailyWage() {
		final int FULL_TIME_HOURS = 8;
		final int WAGE_PER_HOUR = 20;
		
		int attendance = getAttendance();
		int dailyHours = 0;
		
		if(attendance > 0) {
			dailyHours = FULL_TIME_HOURS;
		}

		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}

	// UC-3 Part-Time Employee Wage Calculation
	public int getPartTimeDailyWage() {
		final int PART_TIME_HOURS = 4;
		final int WAGE_PER_HOUR = 20;
		
		int attendance = getAttendance();
		int dailyHours = 0;
		
		if(attendance > 0) {
			dailyHours = PART_TIME_HOURS;
		}

		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}

	// UC-4 Solving Using Switch Case
	public int getDailyHours(int attendance) {
		final int FULL_TIME_HOURS = 8;
		final int PART_TIME_HOURS = 4;
		int dailyHours = 0;
		switch (attendance) {
			case 1 -> {
				dailyHours = FULL_TIME_HOURS;
			}
			case 2 -> {
				dailyHours = PART_TIME_HOURS;
			}
			default -> {
				dailyHours = 0;
			}
		}
		return dailyHours;
	}
}

class UC5 {
	// UC-1 Check if Employee is Present Or Absent using Random()
	public int getAttendance() {
		return (int) (Math.random() * 3);
	}

	// UC-2 Full-Time Employee Daily Wage Calculation
	public int getDailyWage(int dailyHours) {
		final int WAGE_PER_HOUR = 20;
		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}

	// UC-3 Part-Time Employee Wage Calculation
	public int getPartTimeDailyWage(int dailyHours) {
		final int WAGE_PER_HOUR = 20;
		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}

	// UC-4 Solving Using Switch Case
	public int getDailyHours(int attendance) {
		final int FULL_TIME_HOURS = 8;
		final int PART_TIME_HOURS = 4;
		int dailyHours = 0;
		switch (attendance) {
			case 1 -> {
				dailyHours = FULL_TIME_HOURS;
			}
			case 2 -> {
				dailyHours = PART_TIME_HOURS;
			}
			default -> {
				dailyHours = 0;
			}
		}
		return dailyHours;
	}
	//UC-5 	Calculate Wages for a month
	public int getMonthlyWage() {
		int totalWage = 0;
		int totalWorkingDays = 0;
		while(totalWorkingDays < 20) {
			totalWorkingDays++;
			int attendance = getAttendance();
			int dailyHours = getDailyHours(attendance);
			int dailyWage = getDailyWage(dailyHours);
			totalWage += dailyWage;
		}
		return totalWage;
	}
}

class EWC_UC6{
	// UC-1 Check if Employee is Present Or Absent using Random()
	public int getAttendance() {
		return (int) (Math.random() * 3);
	}

	// UC-2 Full-Time Employee Daily Wage Calculation
	public int getDailyWage(int dailyHours) {
		final int WAGE_PER_HOUR = 20;
		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}

	// UC-3 Part-Time Employee Wage Calculation
	public int getPartTimeDailyWage(int dailyHours) {
		final int WAGE_PER_HOUR = 20;
		int dailyWage = dailyHours * WAGE_PER_HOUR;
		return dailyWage;
	}

	// UC-4 Solving Using Switch Case
	public int getDailyHours(int attendance, int totalWorkingHours) {
		final int FULL_TIME_HOURS = 8;
		final int PART_TIME_HOURS = 4;
		final int MAX_WORKING_HOURS = 100;
		int dailyHours = 0;
		switch (attendance) {
			case 1 -> {
				dailyHours = FULL_TIME_HOURS;
			}
			case 2 -> {
				dailyHours = PART_TIME_HOURS;
			}
			default -> {
				dailyHours = 0;
			}
		}
		if (totalWorkingHours + dailyHours > MAX_WORKING_HOURS) {
			dailyHours = MAX_WORKING_HOURS - totalWorkingHours;
		}

		return dailyHours;
	}
	
	// UC-6 Calculate wages till total working hours or total working days condition is reached
	public int getMonthlyWage() {
		final int MAX_WORKING_DAYS = 20;
		final int MAX_WORKING_HOURS = 8;
		int totalWage = 0;
		int totalWorkingDays = 0;
		int totalWorkingHours = 0;
		while(totalWorkingHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
			totalWorkingDays++;
			int attendance = getAttendance();
			int dailyHours = getDailyHours(attendance, totalWorkingHours);
			totalWorkingHours += dailyHours;
			int dailyWage = attendance == 2 ? getPartTimeDailyWage(dailyHours) : getDailyWage(dailyHours);
			totalWage += dailyWage;
		}
		return totalWage;
	}
	
}

public class EmployeeWageComputation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
		System.out.println();

		EmployeeWageComputation obj = new EmployeeWageComputation();

		final int WAGE_PER_HOUR = 20;
		final int FULL_TIME_HOURS = 8;
		final int PART_TIME_HOURS = 4;
		final int MAX_WORKING_DAYS = 20;
		final int MAX_WORKING_HOURS = 100;

		int totalWorkingHours = 0;
		int totalWorkingDays = 0;
		int totalWage = 0;

		// UC-6 Calculate wages till total working hours or total working days condition is reached
		while (totalWorkingHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
			totalWorkingDays++;

			// UC-1 Check if Employee is Present Or Absent using Random()
			// 0 for absent, 1 for pull time present, 2 for part time present
			int attendance = (int)(Math.random() * 3);
			int dailyHours = 0;

			// UC-4 Solving Using Switch Case
			switch (attendance) {
			// UC-2 Full-Time Employee Daily Wage Calculation
				case 1 -> {
					dailyHours = FULL_TIME_HOURS;
					System.out.println("Day " + totalWorkingDays + " : Full Time Present");
				}
				// UC-3 Part-Time Employee Wage Calculation
				case 2 -> {
					dailyHours = PART_TIME_HOURS;
					System.out.println("Day " + totalWorkingDays + " : Part Time Present");
				}
				default -> {
					System.out.println("Day " + totalWorkingDays + " : Absent");
				}
			}

			// UC-6 Ensuring Total Hours Do Not Exceed Max Working Hours
			if (totalWorkingHours + dailyHours > MAX_WORKING_HOURS) {
				dailyHours = MAX_WORKING_HOURS - totalWorkingHours;
			}

			totalWorkingHours += dailyHours;

			// UC-2 Daily Wage Calculation
			int dailyWage = dailyHours * WAGE_PER_HOUR;

			// UC-5 Calculating Wages For A Month
			totalWage += dailyWage;

			System.out.println(
					"Day " + totalWorkingDays + " : Daily Hours : " + dailyHours + "\nDaily Wage : " + dailyWage);
			System.out.println();
		}
		System.out.println();
		System.out.println("Total Working Days : " + totalWorkingDays);
		System.out.println("Total Working Hours : " + totalWorkingHours);
		System.out.println("Total Monthly Wage : Rs " + totalWage);
	}
}