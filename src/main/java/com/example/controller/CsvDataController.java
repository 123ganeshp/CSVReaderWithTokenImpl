package com.example.controller;


import com.example.entity.CsvData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CsvDataController {

    public static final String CSV_FILE_PATH = "D:/Hoonartek/PinCode.csv";


//    public static final Logger logger = LogManager.getLogger(CsvDataController.class);


    @GetMapping(value = "/getdata")
    public static List<CsvData> readCsvFile() {

        List<CsvData> addresses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            if (reader != null && reader.ready()) {
                reader.readLine();

            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8) { // Ensure at least 6 elements exist in the array
                    String zipCode = parts[0].trim();
                    String placeName = parts[1].trim();
                    String country = parts[2].trim();
                    String stateCode = parts[3].trim();
                    String state = parts[4].trim();
                    String city = parts[5].trim();
                    String latitude = parts[8].trim();
                    String longitude = parts[9].trim();

                    CsvData address = new CsvData(zipCode, placeName, country, stateCode, state, city, latitude, longitude);

                    addresses.add(address);
                } else {
                    // Handle the case when the array does not have enough elements
                    System.err.println("Invalid record in CSV file: " + line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
//            logger.info("Failed to read CSV file.");
            throw new RuntimeException("Failed to read CSV file.");
        }

        return addresses;

    }

    @GetMapping(value ="/data/{zipcode}")
    public Object readRecordById(@PathVariable String zipcode) {
//        logger.info("Reading record by zipcode: {}", zipcode);

        if (zipcode.length() != 6) {
            return "zipcode not defined. Zipcode should be 6 digits.";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    String recordId = values[0].trim();

                    if (recordId.equals(zipcode)) {
                        String placeName = values[1].trim();
                        String country = values[2].trim();
                        String stateCode = values[3].trim();
                        String state = values[4].trim();
                        String city = values[5].trim();
                        String latitude = values[8].trim();
                        String longitude = values[9].trim();

                        // Create a Map representing the output
                        Map<String, String> output = new LinkedHashMap<>();
                        output.put("PlaceName", placeName);
                        output.put("Country", country);
                        output.put("StateCode", stateCode);
                        output.put("State", state);
                        output.put("City", city);
                        output.put("Latitude", latitude);
                        output.put("longitude", longitude);

//                        logger.info("Records: {}", output);

                        return output;
                    }
                }
            }
//            logger.info("No matching zipcode found: {}", zipcode);

            return "Zipcode not found: " + zipcode;

        } catch (IOException e) {
            e.printStackTrace();

//            logger.info("Failed to read CSV file.");
            throw new RuntimeException("Failed to read CSV file.");
        }
    }

}
