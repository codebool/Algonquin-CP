/**
 * The Person class encapsulates details of a person.
 * It includes fields for first name, last name, spouse's first name, and spouse's last name.
 * Each field has private access and corresponding getters and setters.
 */
public class Person {
    private String firstName;        // Stores the first name of the person
    private String lastName;         // Stores the last name of the person
    private String spouseFirstName;  // Stores the first name of the spouse
    private String spouseLastName;   // Stores the last name of the spouse

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }
}