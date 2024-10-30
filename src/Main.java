import java.util.Random;
import java.util.Scanner;
public class Main {
    public static double getAverage(int values[]) {
        if (values.length == 0) return 0.0;
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        int sum = 0;
        Random randomNum = new Random();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = randomNum.nextInt(100) + 1;
            sum += dataPoints[i];
        }

        for (int i = 0; i < dataPoints.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            System.out.print(dataPoints[i]);
        }

        double average = (double) sum / dataPoints.length;

        System.out.println("\n\nThe sum of all values in dataPoints is: " + sum);
        System.out.println("The average of the values in dataPoints is: " + average);

        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        System.out.println("The minimum value in the dataPoints array is: " + min);
        System.out.println("The maximum value in the dataPoints array is: " + max);

        int userValue = SafeInput.getRangedInt(in, "\nEnter a value to search for in dataPoints ", 1, 100);

        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }

        System.out.println("The value " + userValue + " was found " + count + " times in the dataPoints array.");

        boolean inputFound = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (userValue == dataPoints[i]) {
                inputFound = true;
                System.out.println(userValue + " is first found at index " + i);
                break;
            }
        }
        if (!inputFound) {
            System.out.println("The number you entered is not found in the array.");
        }

        in.close();
    }
}