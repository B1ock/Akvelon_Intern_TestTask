import binarymatrix.BinaryMatrix;
import calculator.BasicCalculator;

import java.io.*;
import java.util.Scanner;


public class Main {
    private static final String DEFAULT_FILE = "BinaryMatrixDefault.txt";
    private static final Scanner in = new Scanner(System.in);
    private static final File file = new File(DEFAULT_FILE);

    private static void printMainMenu(){
        System.out.println("Choose how to create an input matrix:");
        System.out.println("1. By default - the program will automatically create a matrix at its discretion");
        System.out.println("2. From file");
        System.out.println("3. Set the matrix in the console");
        System.out.println("0. Exit from program");
    }

    private static void toMakeChoice() {
        int n;


        while (true){
            printMainMenu();

            do {
                n = in.nextInt();
                if (n < 0 || n > 3) {
                    System.out.println("Try again.");
                }
            } while (n < 0 || n > 3);


            switch (n) {
                case 1:
                    BasicCalculator.toCreateBMatrix(5, 5);
                    continue;
                case 2:
                    toMakeMatrixFromFile();
                    continue;
                case 3:
                    toMakeMatrixInConsole();
                    continue;
                case 0:
                    System.out.println("Exit from program");
                    in.close();
                    System.exit(0);

            }
            break;
        }

    }

    private static byte[][] createBMatrixFromFile(){
        int m, k;
        String url;
        System.out.println("Enter the dimensions of the matrix");
        m = in.nextInt();
        k = in.nextInt();
        System.out.println("Enter the path to the matrix file");
        url = in.next();

        String line;
        byte lineCount = 0;
        String matrix_line[];
        byte[][] bmxTemp = new byte[m][k];
        File fileBinaryMatrix = new File(url);


        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(fileBinaryMatrix));

        } catch (FileNotFoundException e) {
            System.out.println("The file can not be found by the specified path");
        }
        try {
            while ((line = bfr != null ? bfr.readLine() : null) != null) {
                matrix_line = line.split(" ");
                for (int i = 0; i < m; i++)
                    bmxTemp[lineCount][i] = Byte.parseByte(matrix_line[i]);
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Empty line from matrix");
        } finally {
            if (bfr != null) try {
                bfr.close();
            } catch (IOException e) {
                System.out.println("Error closing resources");
            }
        }
        return bmxTemp;
    }

    private static byte[][] createBMatrixFromDefaultFile(){
        String line;
        String matrix_line[];
        byte[][] bmxTemp = new byte[7][7];
        byte lineCount = 0;
        //fr = new FileReader(file);
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("The file can not be found by the specified path");
        }
        try {
            while ((line = bfr != null ? bfr.readLine() : null) != null) {
                matrix_line = line.split(" ");
                for (int i = 0; i < 7; i++)
                    bmxTemp[lineCount][i] = Byte.parseByte(matrix_line[i]);

                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Empty line from matrix");
        }finally {
            if (bfr != null) try {
                bfr.close();
            } catch (IOException e) {
                System.out.println("Error closing resources");
            }
        }
        return bmxTemp;
    }

    private static void printMenuWorkWithFile(){
        System.out.println("1. Specify the path to the file");
        System.out.println("2. Use default file");
        System.out.println("3. Back");
    }

    private static void toMakeMatrixFromFile() {
        int n, temp;
        while (true){
            printMenuWorkWithFile();
            n = in.nextInt();
            if (n == 1) {
                    BinaryMatrix bmxTemp = new BinaryMatrix(createBMatrixFromFile());
                    temp = BasicCalculator.toCalculateSequence(bmxTemp);
                    printResult(temp);
            } else if (n == 2) {
                    BinaryMatrix bmxTemp = new BinaryMatrix(createBMatrixFromDefaultFile());
                    bmxTemp.printBMatrix();
                    temp = BasicCalculator.toCalculateSequence(bmxTemp);
                    printResult(temp);

            }else if(n == 3){
                break;
            }
            if (n < 1 || n > 2) {
                System.out.println("Try again.");
            }
        }
    }

    private static void printMenuWorkWithConsole(){
        System.out.println("1. Specify only the size of the matrix and the program will fill it randomly");
        System.out.println("2. Enter the matrix into the console");
        System.out.println("3. Back");
    }


    private static void toCreateRandomBMatrixUserDimensions(){
        int  m, k;

        System.out.println("Enter the dimensions of the matrix");
        m = in.nextInt();
        k = in.nextInt();
        BasicCalculator.toCreateBMatrix(m, k);
    }


    private static byte[][] toCreateBMatrixUser(){
        int a, b;
        System.out.println("Enter the dimensions of the matrix");
        System.out.print("Enter the number of rows in the array: ");
        a = in.nextInt();
        System.out.print("Enter the number of columns in the array: ");
        b = in.nextInt();
        byte[][] bmxArray = new byte[a][b];
        for (int i = 0; i < bmxArray.length; i++) {
            for (int j = 0; j < bmxArray[i].length; j++) {
                bmxArray[i][j] = in.nextByte();
            }
        }
        return bmxArray;
    }

    private static void toMakeMatrixInConsole() {
        int n, temp;

        while (true) {
            printMenuWorkWithConsole();

            n = in.nextInt();
            if (n == 1) {
                toCreateRandomBMatrixUserDimensions();

            } else if (n == 2) {
                BinaryMatrix bmxTemp = new BinaryMatrix(toCreateBMatrixUser());
                bmxTemp.printBMatrix();
                temp = BasicCalculator.toCalculateSequence(bmxTemp);
                printResult(temp);

            }else if(n == 3){
                break;
            } else if (n < 1 || n > 3) {
                System.out.println("Try again.");
            }
        }
    }

    private static void printResult(int temp){
        System.out.println("The maximum length of a sequence\n " +
                "of units in a given unit matrix is --->  " + temp);
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        toMakeChoice();
    }

}

