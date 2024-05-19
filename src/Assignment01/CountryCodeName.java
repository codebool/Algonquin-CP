/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-18
 * Modified: 2024-05-19
 * Description: Assignment 01
 */

package Assignment01;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// class to store the country code and country name
public class CountryCodeName {
    // 2D array to store country code and country name
    private String[][] countryData = new String[250][2];

    // method to initialize the countryData array
    public void init() {
        String[] countryCodes = Locale.getISOCountries();

        // loop through the country codes and get the country name
        for (int i = 0; i < countryCodes.length; i++) {
            String countryCode = countryCodes[i];
            String countryName = new Locale("", countryCode).getDisplayCountry();

            // System.out.println(countryCode + " - " + countryName);

            // store the country code and country name in the 2D array
            countryData[i][0] = countryCode;
            countryData[i][1] = countryName;
        }
    }

    // method to get the country name based on the country code
    public String getCountryName(String countryCode) {
        // loop through the countryData array to find the country name
        for (int i = 0; i < countryData.length; i++) {
            // check if the country code is found
            if (countryData[i][0] != null && countryData[i][0].equalsIgnoreCase(countryCode)) {
                // return the country name
                return countryData[i][1];
            }
        }
        // return null if the country code is not found
        return null;
    }

    // method to get the country code based on the country name
    public String getCountryCode(String countryName) {
        // loop through the countryData array to find the country code
        for (int i = 0; i < countryData.length; i++) {
            // check if the country name is found
            if (countryData[i][1] != null && countryData[i][1].equalsIgnoreCase(countryName)) {
                // return the country code
                return countryData[i][0];
            }
        }
        // return null if the country name is not found
        return null;
    }

    // method to get the country name based on the country code
    public String[] getMatchedCountries(String match) {
        // check if the matching string is less than 2 letters
        if (match.length() < 2) {
            System.out.println("Matching string cannot be less than two letters, please enter another matching string: ");
            return null;
        }
        // create an ArrayList to store the matched countries
        ArrayList<String> matchedCountries = new ArrayList<>();

        // loop through the countryData array to find the matching countries
        for (int i = 0; i < countryData.length; i++) {
            // check if the country name contains the matching string
            if (countryData[i][1] != null && countryData[i][1].toLowerCase().contains(match.toLowerCase())) {
                // add the country name and country code to the ArrayList
                matchedCountries.add(countryData[i][1] + " (" + countryData[i][0] + ")");
            }
            // check if the country code matches the matching string
            else if (match.length() == 2  && countryData[i][0] != null && countryData[i][0].equalsIgnoreCase(match)) {
                // add the country name and country code to the ArrayList
                matchedCountries.add(countryData[i][1] + " (" + countryData[i][0] + ")");
            }
        }

        // check if no countries are found
        if (matchedCountries.isEmpty()) {
            // return null if no countries are found
            return null;
        } else {
            // convert the ArrayList to an array and return the result
            String[] result = new String[matchedCountries.size()];
            // add the matched countries to the result array
            result = matchedCountries.toArray(result);
            // return the result array
            return result;
        }
    }

    // main method to test the CountryCodeName class
    public static void main(String[] args) {
        // create an instance of the CountryCodeName class
        CountryCodeName ccn = new CountryCodeName();
        // initialize the countryData array
        ccn.init();

        // create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        // variable to store the user input
        String input;

        System.out.println("Welcome to Country Code Name. Enter “bye” anytime to end.");

        // loop until the user enters "bye"
        do {
            System.out.print("Please enter a country code or a country name: ");
            // read the user input and remove any leading or trailing whitespace
            input = scanner.nextLine().trim();

            // check if the input is less than 2 letters
            while (input.length() < 2) {
                System.out.print("Matching string cannot be less than two letters, please enter another matching string: ");
                input = scanner.nextLine().trim();
            }

            // check if the input is not "bye"
            if (!input.equalsIgnoreCase("bye")) {
                if (input.length() == 2) {
                    String countryName = ccn.getCountryName(input);
                    // check if the country name is found
                    if (countryName == null) {
                        System.out.print("No match for country code entered. ");
                        continue;
                    } else {
                        System.out.println("The country name for the country code entered " + input + " is " + countryName);
                    }
                } else {
                    String countryCode = ccn.getCountryCode(input); // get the country code
                    if (countryCode == null) { // check if the country code is found
                        System.out.print("No match for country name entered. ");
                        continue;
                    } else {
                        System.out.println("The country code for the country name entered " + input.toUpperCase() + " is " + countryCode);
                    }
                }

                System.out.print("Please enter a matching string for the country names: ");
                String match = scanner.nextLine().trim();

                // check if the user entered "bye" for match string
                if (match.equalsIgnoreCase("bye")) {
                    break;
                }

                String[] matchedCountries = ccn.getMatchedCountries(match);

                // check if no countries are found
                if (matchedCountries == null || matchedCountries.length == 0) {
                    System.out.println("No match for matching string entered");
                } else { // display the matched countries
                    System.out.println("The list of countries for the matching string “" + match + "” is the following:");
                    System.out.println("Results count: " + matchedCountries.length);
                    // loop through the matched countries and display them
                    for (String country : matchedCountries) {
                        // display the country name and country code in the format "country name (country code)"
                        System.out.println("\t" + country);
                    }
                }
            }
        } while (!input.equalsIgnoreCase("bye")); // check if the user entered "bye"

        System.out.println("Bye.");
        // close the scanner object to release resources
        scanner.close();
    }
}
