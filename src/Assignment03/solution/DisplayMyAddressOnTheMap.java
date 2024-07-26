import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The DisplayMyAddressOnTheMap class contains the main method to read input addresses,
 * parse them to extract relevant data, and write the output to a CSV file.
 */
public class DisplayMyAddressOnTheMap {
    public static void main(String[] args) {
        // Try-with-resources statement to automatically close the BufferedReader and FileWriter
        try (BufferedReader br = new BufferedReader(new FileReader("./InputAddresses.txt"));
             FileWriter fw = new FileWriter("./OutputAddresses.csv")) {

            String line;  // Variable to hold each line read from the input file

            // Loop through each line in the input file
            while ((line = br.readLine()) != null) {
                // Skip blank lines that separate addresses
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Parse the person information
                Person person = parsePerson(line);

                // Parse the address information
                Address address = parseAddress(br);

                // Prepare the formatted output string
                String output = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSpouseFirstName() == null ? "" : person.getSpouseFirstName(),
                        person.getSpouseLastName() == null ? "" : person.getSpouseLastName(),
                        address.getStreetNumber(),
                        address.getStreetName(),
                        address.getStreetType(),
                        address.getStreetOrientation() == null ? "" : address.getStreetOrientation(),
                        address.getCityName(),
                        address.getProvince());

                // Write the formatted output string to the OutputAddresses.csv file
                fw.write(output);
            }
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
    }

    /**
     * Parses the person information from the given line.
     * @param line The current line containing the person's name(s).
     * @return A Person object with the parsed information.
     */
    private static Person parsePerson(String line) {
        Person person = new Person();

        // Split the names by " and " or ", "
        String[] names = line.split(" and |, ");
        // Separate and set the first name and last name for the primary person
        if (names.length > 0) {
            String[] primaryPerson = names[0].trim().split(" ");
            if (primaryPerson.length >= 2) {
                person.setFirstName(primaryPerson[0]);
                person.setLastName(primaryPerson[1]);
            } else {
                person.setFirstName(primaryPerson[0]);
                person.setLastName(""); // Set last name to empty if not available
            }
        }

        // If there are more names, set the spouse's names
        if (names.length > 1) {
            String[] spouse = names[1].trim().split(" ");
            if (spouse.length >= 2) {
                person.setSpouseFirstName(spouse[0]);
                person.setSpouseLastName(spouse[1]);
            } else {
                person.setSpouseFirstName(spouse[0]);
                person.setSpouseLastName(""); // Set last name to empty if not available
            }
        }

        return person;
    }

    /**
     * Parses the address information from the BufferedReader.
     * @param br The BufferedReader to read lines.
     * @return An Address object with the parsed information.
     * @throws IOException If an I/O error occurs.
     */
    private static Address parseAddress(BufferedReader br) throws IOException {
        Address address = new Address();

        // Read the address line and the city/province line
        String addressLine = br.readLine();
        String cityProvinceLine = br.readLine();

        // Split the address line to extract street elements
        String[] parts = addressLine.split(" ");
        if (parts.length >= 2) {
            address.setStreetNumber(parts[0]);
            address.setStreetName(parts[1]);
            if (parts.length > 2) address.setStreetType(parts[2]);
            if (parts.length > 3) address.setStreetOrientation(parts[3]);
        }

        // Split the city/province line to extract city name and province
        String[] cityProvinceParts = cityProvinceLine.split(",");
        if (cityProvinceParts.length >= 2) {
            address.setCityName(cityProvinceParts[0].trim());
            address.setProvince(cityProvinceParts[1].trim());
        }

        // Skip the postal code line
        br.readLine();
        return address;
    }
}