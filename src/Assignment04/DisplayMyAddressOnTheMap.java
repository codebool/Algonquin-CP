/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-28
 * Modified: 2024-07-20
 * Description: Lab assignment 4
 */

package Assignment04;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayMyAddressOnTheMap {

    public static void main(String[] args) {
        // File paths
        String inputFilePath = "D:\\Algonquin College\\2024_Spring\\CST7284_300\\eclipse-workspace\\MyJava\\src\\Assignment04\\InputAddresses.txt";
        String outputFilePath = "D:\\Algonquin College\\2024_Spring\\CST7284_300\\eclipse-workspace\\MyJava\\src\\Assignment04\\OutputAddresses.csv";
        String targetFilePath = "D:\\Algonquin College\\2024_Spring\\CST7284_300\\eclipse-workspace\\MyJava\\src\\Assignment04\\BoQu_LatLong.csv";

        // Generate OutputAddresses.csv from InputAddresses.txt
        generateOutputAddresses(inputFilePath, outputFilePath);

        // Generate BoQu_LatLong.csv from OutputAddresses.csv
        generateLatLong(outputFilePath, targetFilePath);
    }

    // Read the input file and write the output file
    private static void generateOutputAddresses(String inputFilePath, String outputFilePath) {
        List<Address> addresses = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] personInfo = line.split(" and |, ");
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

                br.readLine(); // skip postal code line
            }

            for (int i = 0; i < persons.size(); i++) {
                Person person = persons.get(i);
                Address address = addresses.get(i);
                bw.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
                        person.getFirstName(), person.getLastName(),
                        person.getSpouseFirstName() != null ? person.getSpouseFirstName() : "",
                        person.getSpouseLastName() != null ? person.getSpouseLastName() : "",
                        address.getStreetNumber(), address.getStreetName(), address.getStreetType(),
                        address.getStreetOrientation() != null ? address.getStreetOrientation() : "",
                        address.getCity(), address.getProvince()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read the output file and write the target file
    private static void generateLatLong(String outputFilePath, String targetFilePath) {
        List<String> addresses = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(outputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                Person person = new Person();
                person.setFirstName(columns[0]);
                person.setLastName(columns[1]);
                person.setSpouseFirstName(columns[2].isEmpty() ? null : columns[2]);
                person.setSpouseLastName(columns[3].isEmpty() ? null : columns[3]);

                StringBuilder address = new StringBuilder();
                address.append(columns[4]).append("+").append(columns[5]).append("+").append(columns[6]);
                if (!columns[7].isEmpty()) {
                    address.append("+").append(columns[7]);
                }
                address.append(",+").append(columns[8]).append(",+").append(columns[9]).append(",+Canada");

                addresses.add(address.toString());
                persons.add(person);
            }

            for (int i = 0; i < addresses.size(); i++) {
                String latLong = getLatLongFromAddress(addresses.get(i));
                if (latLong != null) {
                    bw.write(latLong);
                    bw.write(",");
                    bw.write(persons.get(i).getFirstName() + " " + persons.get(i).getLastName());
                    if (persons.get(i).getSpouseFirstName() != null) {
                        bw.write(" and " + persons.get(i).getSpouseFirstName() + " " + persons.get(i).getSpouseLastName());
                    }
                    bw.write(",111,1,1");
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the latitude and longitude from the address
    private static String getLatLongFromAddress(String address) {
        String apiKey = "AIzaSyBuRBfnZIOq9GP7ijo3rccub6WfVnXfXXs";
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey;

        // Send the request to Google Maps API
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String json = EntityUtils.toString(response.getEntity());
                return parseJsonResponse(json);
            } else {
                System.out.println("Error: " + response.getStatusLine().getStatusCode());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Parse the JSON response from Google Maps API
    private static String parseJsonResponse(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonArray results = jsonObject.getAsJsonArray("results");

        // Get the latitude and longitude from the JSON response
        if (results.size() > 0) {
            JsonObject location = results.get(0).getAsJsonObject()
                    .getAsJsonObject("geometry")
                    .getAsJsonObject("location");
            String lat = location.get("lat").getAsString();
            String lng = location.get("lng").getAsString();
            return lat + "," + lng;
        } else {
            return null;
        }
    }
}
