class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        // 1. Add days for all past years since 1971
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        
        // 2. Add days for all past months in the current year
        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];
            if (m == 2 && isLeapYear(year)) {
                totalDays += 1; // Leap day in February
            }
        }
        
        // 3. Add remaining days in current month
        totalDays += (day - 1);
        
        // Jan 1, 1971 was Friday (index 5 in our array: Sunday = 0, ..., Friday = 5)
        return days[(5 + totalDays) % 7];
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
