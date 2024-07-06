/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-07
 * Modified: 2024-07-05
 * Description: Lab assignment 3
 */

package Assignment03;

public class Person {
    private String firstName;
    private String lastName;
    private String SpouseFirstName;
    private String SpouseLastName;

    public Person() {}

    public Person(String firstName, String lastName, String SpouseFirstName, String SpouseLastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SpouseFirstName = SpouseFirstName;
        this.SpouseLastName = SpouseLastName;
    }

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
        return SpouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        SpouseFirstName = spouseFirstName;
    }

    public String getSpouseLastName() {
        return SpouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        SpouseLastName = spouseLastName;
    }
}
