/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-28
 * Modified: 2024-07-20
 * Description: Lab assignment 4
 */

package Assignment04;

import java.io.*;
import java.util.ArrayList;

public class DisplayMyAddressOnTheMap {
    public static void main(String[] args) {
        // File paths
        String inputFilePath = "D:\\Algonquin College\\2024_Spring\\CST7284_300\\eclipse-workspace\\MyJava\\src\\Assignment03\\InputAddresses.txt";
        String outputFilePath = "D:\\Algonquin College\\2024_Spring\\CST7284_300\\eclipse-workspace\\MyJava\\src\\Assignment03\\OutputAddresses.csv";

        ArrayList<Address> addresses = new ArrayList<>();
        ArrayList<Person> persons = new ArrayList<>();

        // Read the input file and write the output file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            // Read the file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }
                // Read the person information from the file
                String[] personInfo = line.split(" and |, ");
                // Create a new person object
                Person person = new Person();
                if (personInfo.length == 1) {
                    String[] names = personInfo[0].split(" ");
                    person.setFirstName(names[0]);
                    person.setLastName(names[1]);
                } else if (personInfo.length == 2) {
                    String[] names = personInfo[0].split(" ");
                    person.setFirstName(names[0]);
                    names = personInfo[1].split(" ");
                    person.setSpouseFirstName(names[0]);
                    person.setLastName(names[1]);
                    person.setSpouseLastName(names[1]);
                }
                persons.add(person);

                // Read the address information from the file
                line = br.readLine();
                Address address = new Address();
                String[] addressParts = line.split(" ");
                address.setStreetNumber(addressParts[0]);
                address.setStreetName(addressParts[1]);
                address.setStreetType(addressParts[2]);
                if (addressParts.length == 4) {
                    address.setStreetOrientation(addressParts[3]);
                }

                line = br.readLine();
                String[] locationParts = line.split(", ");
                address.setCity(locationParts[0]);
                address.setProvince(locationParts[1]);
                addresses.add(address);

                // skip the postal code line
                br.readLine();
            }

            // Write the output file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (int i = 0; i < persons.size(); i++) {
                    Person person = persons.get(i);
                    Address address = addresses.get(i);
                    // Write the person and address information to the output file
                    bw.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
                            person.getFirstName(), person.getLastName(),
                            person.getSpouseFirstName() != null ? person.getSpouseFirstName() : "",
                            person.getSpouseLastName() != null ? person.getSpouseLastName() : "",
                            address.getStreetNumber(), address.getStreetName(), address.getStreetType(),
                            address.getStreetOrientation() != null ? address.getStreetOrientation() : "",
                            address.getCity(), address.getProvince()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
