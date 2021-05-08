package com.sse.software_testing.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hq
 */
class TriangleServiceTest {
    @Autowired
    TriangleService TriangleService;
    @Test
    public void test(){
        testCase("src/csv/triangle-boundary.csv");
        testCase("src/csv/triangle-equivalent.csv");
    }
    public void testCase(String csvFile) {
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] csvContent = line.split(csvSplitBy);
//                System.out.println(csvContent[0]+','+csvContent[1]+','+csvContent[2]+','+csvContent[3]);
                String res = TriangleService.getTriangleType(
                        Double.parseDouble(csvContent[0]),Double.parseDouble(csvContent[1]),Double.parseDouble(csvContent[2])
                );
                assertEquals(csvContent[3],res);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}