import java.util.Scanner;

public class Main_Class {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int operationNumber;
        System.out.println("press 1 for number algorithms ");
        System.out.println("press 2 for sorting algorithm");
        System.out.println("press 3 for selecting algorithm");
        System.out.println("please enter an operation number");
        operationNumber = input.nextInt();
        switch (operationNumber) {
            case 1:
                Number_Algorithm X = new Number_Algorithm();
                X.Algorithm_ofNumbers(operationNumber);//We call the method inside the object.
                break;//We make it exit the switch block when the process is finished.
            case 2:
                Sorting_Algorithm Y = new Sorting_Algorithm();
                Y.Algorithm_ofSorting(operationNumber);
                break;
            case 3:
                Selecting_Algorithm Z = new Selecting_Algorithm();
                Z.Algorithm_ofSelecting();
                break;
            default:
                System.out.println("You entered invalid value");
        }


    }
}
