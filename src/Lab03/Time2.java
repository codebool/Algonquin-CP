package Lab03; /**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-26
 * Modified: 2024-05-23
 * Description: Lab assignment 3
 */

public class Time2 {
    private int hour; // 0 - 23
    private int minute; // 0 - 59   
    private int second; // 0 - 59  

    // Time2 no-argument constructor: initializes each instance variable
    // to zero; ensures that Time2 objects start in a consistent state
    public Time2() {
        this(0, 0, 0); // invoke Time2 constructor with three arguments
    }

    // Time2 constructor: hour supplied, minute and second defaulted to 0
    public Time2(int h) {
        this(h, 0, 0); // invoke Time2 constructor with three arguments
    }

    // Time2 constructor: hour and minute supplied, second defaulted to 0
    public Time2(int h, int m) {
        this(h, m, 0); // invoke Time2 constructor with three arguments
    }

    // Time2 constructor: hour, minute and second supplied
    public Time2(int h, int m, int s) {
        setTime(h, m, s); // invoke setTime to validate time
    }

    // // Time2 constructor: another Time2 object supplied
    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    // Set a new time value using universal time; perform validity checks on
    // the data; set invalid values to zero
    /* Write header for setTime. */
    public boolean setTime(int h, int m, int s) {
        /* Write code here that declares three boolean variables which are 
          initialized to the return values of setHour, setMinute and setSecond.
          These lines of code should also set the three member variables. */
      
       /* Return true if all three variables are true; otherwise, return false. */
        if (setHour(h) && setMinute(m) && setSecond(s)) {
            return true;
        } else {
            return false;
        }
    }

    // Validate and set hour
    public boolean setHour(int h) {
        if (h >= 0 && h < 24) {
            hour = h;
            return true;
        } else {
            return false;
        }
    }

    // Validate and set minute
    public boolean setMinute(int m) {
        if (m >= 0 && m < 60) {
            this.minute = m;
            return true;
        } else if (m == 60) {
            this.minute = 0;
            return true;
        } else {
            return false;
        }
    }

    // Validate and set second
    public boolean setSecond(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
            return true;
        } else if (second == 60) {
            this.second = 0;
            return true;
        } else {
            return false;
        }
    }

    // Get hour value
    public int getHour() {
        return hour;
    }

    // Get minute value
    public int getMinute() {
        return minute;
    }

    // Get second value
    public int getSecond() {
        return second;
    }

    // Tick the time by one second
    public void tick() {
        setSecond( second + 1 );
        if ( second == 0 )
            incrementMinute();
    }

    // Increment the minute
    public void incrementMinute() {
        setMinute( minute + 1 );
        if ( minute == 0 )
            incrementHour();
    }

    // Increment the hour
    public void incrementHour() {
        setHour( hour + 1 );
    }

    // Convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    // Convert to String in standard-time format (H:MM:SS AM or PM)
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(),
                getSecond(),
                (getHour() < 12 ? "AM" : "PM"));
    }
}