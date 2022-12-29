import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int[] RandomValuesArray()
    {
        Random rand = new Random();
        Scanner key = new Scanner(System.in);
        int elementsQuantity = Integer.parseInt(
                getUserInput("How many numbers to generate: ")
        );
        int value1;//Set the origin of the array value
        int value2;//Set the bound of the array value
        int[] numbers = new int[elementsQuantity];
        print("Choose the origin of the array value:");
        value1 = key.nextInt();
        print("Now choose the bound of the array value:");
        value2 = key.nextInt();
        print("So you want to generate " + elementsQuantity + " numbers from " + value1 + " to " + value2 + "\nHere you go!");
        for (int i = 0; i < elementsQuantity; ++i) {
            numbers[i] = rand.nextInt(value1, value2);
            System.out.println(numbers[i]);
        }
        return numbers;
    }
    public static int[] CustomArrayInput()
    {
        int arrayLength = Integer.parseInt(
                getUserInput("How many numbers to add: ")
        );
        int[] numbers = new int[arrayLength];
        for (int i = 0; i < arrayLength; ++i) {
            numbers[i] = Integer.parseInt(
                    getUserInput("number " + (i + 1) + ": ")
            );
        }
        return numbers;
    }
    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
    public static String getUserInput(String prompt) {
        print(prompt);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim().toLowerCase();
    }
    public static int arraySum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    public static int printBiggestValue(int[] array)
    {
        int max = array[0];
        int i;

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 0; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // Print the result (1 + 2 + 3 = 6)
    public static void printArraySum(int[] array) {
        int sum = arraySum(array);
        for (int i = 0; i < array.length - 1; ++i) {
            System.out.print(array[i] + " + ");
        }
        System.out.print(array[array.length - 1] + " = " + sum + "\n");
    }
    public static void printArray()
    {
        int[] arr;
        int option;
        int action;
        Scanner choice = new Scanner(System.in);
        do {
            System.out.println("Welcome to the Adder programme. Type a number to choose an option;\n1 - add custom values\n2 - generate random values");
            option = choice.nextInt();
            if (option == 1)
            {
                arr = CustomArrayInput();
            }
            else if (option == 2)
            {
                arr = RandomValuesArray();
            }
            else if (option < 1)
            {
                print("All numbers, which are smaller than 1 will be turned into 1.");
                arr = CustomArrayInput();
            }
            else
            {
                print("All numbers, which are greater than 2 will be turned into 2.");
                arr = RandomValuesArray();
            }
            print("What do you want to do with your array.\n1 - summarize the values of the array\n2 - find the biggest value of the array");
            action = choice.nextInt();
            if (action == 1)
            {
                printArraySum(arr);
            }
            else if (action == 2)
            {
                System.out.println("The biggest value of this array is: " + printBiggestValue(arr));
            }
            else if (action < 1)
            {
                print("All numbers, which are smaller than 1 will be turned into 1.");
                printArraySum(arr);
            }
            else
            {
                print("All numbers, which are greater than 2 will be turned into 2.");
                System.out.println("The biggest value of this array is: " + printBiggestValue(arr));
            }
        }
        while(isContinue());
    }
    public static boolean isContinue() {
        String userInput = getUserInput("Do you want to continue? (Y/N)\n");
        return userInput.equalsIgnoreCase("Y");
    }
    public static void main(String[] args)
    {
        printArray();
    }
}