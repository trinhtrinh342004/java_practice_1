// Learning Array, ArrayList, HashMap
package org.practice.saucedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ControlFlowAndCollection {

    // ARRAY PRACTICE
    public static int findSlowestTestIndex(int[] executionTimes){
        int highestIndex= 0;

        for (int i = 1; i < executionTimes.length; i++){
            if (executionTimes[i] > executionTimes[highestIndex]){
                highestIndex = i;
            }
        }

        return highestIndex;
    }

    public static int findFirstFailedTest(int[] testResults){
        for (int i = 0; i < testResults.length;i++){
            if (testResults[i] == 0){
                return i;
            }
        }
        return -1;
    }


    // ARRAYLIST PRACTICE
    public static ArrayList<String> getFailedTests(
            ArrayList<String> testNames,
            ArrayList<String> testResults) {

        ArrayList<String> failedTest = new ArrayList<>();

        for(int i = 0; i < testResults.size(); i++){
            if (testResults.get(i).equals("FAIL")){
                failedTest.add(testNames.get(i));
            }
        }

        return failedTest;
    }


    // HASH MAP

    public static HashMap<String, Integer> countTestResults(
            String[] testResults) {
        HashMap<String, Integer> resultCounts = new HashMap<>();

        for (String status : testResults){
            if (resultCounts.containsKey(status)){
                int currentCount = resultCounts.get(status);
                resultCounts.put(status, currentCount + 1);
            } else {
                resultCounts.put(status, 1);
            }
        }

        return resultCounts;
    }

    public static void main(String[] args) {

        // findSlowestTestIndex
        int[] executionTimes = {3, 7, 2, 9, 5};
        System.out.println("Slowest Test Index: " + findSlowestTestIndex(executionTimes));

        //findFirstFailedTest
        int[] testRe = {0, 1, 1};
        System.out.println("First Failed Test Index: " + findFirstFailedTest(testRe));

        //ArrayList: Lọc danh sách test case bị FAIL
        ArrayList<String> testNames = new ArrayList<>(
                Arrays.asList("Login", "Search", "Checkout")
        );

        testNames.add("Payment");

        ArrayList<String> testResults = new ArrayList<>(
                Arrays.asList("PASS", "FAIL", "PASS")
        );

        testResults.add("FAIL");

        ArrayList<String> result = getFailedTests(testNames, testResults);
        System.out.println(result);

        // HashMap
        String[] tests = {
                "PASS", "FAIL", "PASS",
                "SKIPPED", "FAIL", "PASS"
        };

        HashMap<String, Integer> output = countTestResults(tests);
        System.out.println(output);

    }
}
