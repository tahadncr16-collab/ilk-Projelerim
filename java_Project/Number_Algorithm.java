import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Arrays;
import java.lang.Math;

public class Number_Algorithm {
    public void Algorithm_ofNumbers(int operationNumber) {
        Scanner input = new Scanner(System.in);
        int choice1;
        System.out.println("\n--- NUMBER ALGORITHMS MENU ---");
        System.out.println("1- Perfect Numbers");
        System.out.println("2- Fibonacci Numbers (a-Recursive / b-Standard)");
        System.out.println("3- Armstrong Numbers");
        System.out.println("4- Tribonacci Numbers");
        System.out.println("5- Palindrome Numbers");
        System.out.println("6- Cullen Numbers");
        System.out.println("7- Lasa Numbers");
        System.out.println("8- Fermat Numbers");
        System.out.println("9- Amicable Numbers");
        System.out.println("10- Abundant Numbers");
        System.out.println("11- Lucas Series");
        System.out.println("12- Tetranacci Numbers");
        System.out.println("13- Twin Primes");
        System.out.println("14- Woodall Numbers");
        System.out.println("15- Mersenne Numbers");
        System.out.println("16- Harshad Numbers");
        System.out.println("17- Cyclic Numbers");
        System.out.println("18- Tau Numbers");
        System.out.println("19- Betrothed Numbers");
        System.out.println("20- Kaprekar's Constant (6174)");
        System.out.print("\nPlease enter an algorithm number: ");
        choice1 = input.nextInt();
        switch (choice1) {
            case 1:
                PerfectNumber();
                break;
            case 2:
                FibonacciNumbers();
                break;
            case 3:
                ArmstrongNumbers();
                break;
            case 4:
                TribonacciNumbers();
                break;
            case 5:
                PalindromeNumbers();
                break;
            case 6:
                CullenNumbers();
                break;
            case 7:
                LasaNumbers();
                break;
            case 8:
                FermatNumbers();
                break;
            case 9:
                AmicableNumbers();
                break;
            case 10:
                AbundantNumbers();
                break;
            case 11:
                LucasSeries();
                break;
            case 12:
                TetranacciNumbers();
                break;
            case 13:
                TwinPrimes();
                break;
            case 14:
                WoodallNumbers();
                break;
            case 15:
                MersenneNumbers();
                break;
            case 16:
                HarshadNumbers();
                break;
            case 17:
                CyclicNumbers();
                break;
            case 18:
                TauNumbers();
                break;
            case 19:
                BetrothedNumbers();
                break;
            case 20:
                KaprekarConstant();
                break;
            default:
                System.out.println("You entered invalid value");
        }
    }

    public void PerfectNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number to check if it's a perfect number:");
        System.out.println("If you exit number algorithm enter (0)");
        while (true) {
            System.out.print("Your number: ");
            int sum = 0, number = input.nextInt();
            if (number == 0) {
                break;
            }
            for (int i = 1; i <= number / 2; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
            if (sum == number) {
                System.out.println(number + " is a perfect number");
            } else {
                System.out.println(number + " is a NOT perfect number.");
            }
        }
    }

    public void FibonacciNumbers() {

    }

    public void ArmstrongNumbers() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n--- Armstrong Number Checker ---");
        System.out.print("\nEnter a number to check if it is an Armstrong number: ");
        int number = input.nextInt();
        if (number < 0) {
            System.out.println(number + " is not an Armstrong number (negative numbers not supported).");
            return;
        }
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = String.valueOf(number).length();
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numberOfDigits);
            temp /= 10;
        }
        if (sum == originalNumber && originalNumber > 0) {
            System.out.println(originalNumber + " is an Armstrong number!");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }

    public void TribonacciNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Tribonacci Series ---");
        System.out.print("How many Tribonacci terms do you want to see?: ");
        int n = input.nextInt();

        // Validation: The number of terms must be greater than 0
        if (n <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        System.out.print("Tribonacci Series (" + n + " terms): ");

        // Using 'long' because Tribonacci numbers grow very fast
        // These represent the first three numbers of the sequence: T(0), T(1), T(2)
        long a = 0;
        long b = 0;
        long c = 1;

        // Optimized iterative loop (O(n) Time, O(1) Space)
        for (int i = 0; i < n; i++) {
            // Print the current term
            System.out.print(a + " ");

            // Calculate the next term by summing the previous three
            long next = a + b + c;

            // Shift the values forward for the next iteration
            a = b;
            b = c;
            c = next;
        }

        System.out.println(); // Move to the next line after printing the sequence
    }

    public void PalindromeNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Palindrome Number Checker ---");
        System.out.print("Enter a number to check if it is a palindrome: ");
        int number = input.nextInt();

        // Negative numbers are not palindromes (e.g., -121 reversed is 121-)
        if (number < 0) {
            System.out.println(number + " is not a palindrome (negative numbers don't match).");
            return; // Exit the method early
        }

        // Store the original number to compare it at the end
        int originalNumber = number;
        int reversedNumber = 0;

        // We use a temporary variable to safely modify the number
        int temp = number;

        // Loop to reverse the digits mathematically
        while (temp > 0) {
            // Get the last digit of the number
            int lastDigit = temp % 10;

            // Shift the reversed number left by one decimal place and add the last digit
            reversedNumber = (reversedNumber * 10) + lastDigit;

            // Remove the last digit from temp
            temp /= 10;
        }

        // Compare the original number with the newly reversed number
        if (originalNumber == reversedNumber) {
            System.out.println(originalNumber + " is a palindrome! (It reads the same backwards)");
        } else {
            System.out.println(originalNumber + " is not a palindrome.");
        }
    }

    public void CullenNumbers() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Cullen Numbers Generator ---");
        System.out.print("How many Cullen numbers do you want to generate?: ");
        int terms = input.nextInt();
        if (terms <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return;
        }
        System.out.print("Cullen Numbers (" + terms + " terms): ");
        for (int n = 1; n <= terms; n++) {
            long cullenValue = (long) n * (1L << n) + 1;
            System.out.print(cullenValue + " ");
        }
        System.out.println();
    }

    public void LasaNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Lasa (Lucky) Numbers Generator ---");
        System.out.println("(Note: Mathematically known as Ulam's Lucky Numbers)");
        System.out.print("Find Lasa numbers up to what limit?: ");
        int limit = input.nextInt();

        // Validation for the limit
        if (limit <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        // We use an ArrayList because we will be dynamically removing elements
        ArrayList<Integer> list = new ArrayList<>();

        // Populate the list with all numbers from 1 to the limit
        for (int i = 1; i <= limit; i++) {
            list.add(i);
        }

        // The index of the "step" number. We start at index 1 (which holds the number 2)
        int index = 1;

        // Continue filtering as long as the index is within the bounds of our shrinking list
        while (index < list.size()) {

            // The value at the current index determines our removal step (e.g., 2, then 3, then 7...)
            int step = list.get(index);

            // Loop BACKWARDS through the list to remove items.
            // Why backwards? Because if you delete an item from the front, all other items
            // shift left, which ruins the index counting. Going backwards prevents this!
            for (int i = list.size() - 1; i >= 0; i--) {

                // Human counting starts at 1, so the position is (i + 1)
                // If the position is a multiple of our step, we remove it
                if ((i + 1) % step == 0) {
                    list.remove(i);
                }
            }

            // Move to the next surviving number to use as our new step
            index++;
        }

        // Print the final surviving Lasa (Lucky) numbers
        System.out.print("Lasa Numbers up to " + limit + ": ");
        for (int number : list) {
            System.out.print(number + " ");
        }
        System.out.println(); // Move to the next line
    }

    public void FermatNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Fermat Numbers Generator ---");
        System.out.println("(Note: These numbers grow extremely fast!)");
        System.out.print("How many Fermat numbers do you want to generate?: ");
        int terms = input.nextInt();

        // Validation: Ensure the user enters a positive number
        if (terms <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        System.out.println("Fermat Numbers (" + terms + " terms):");

        // Fermat numbers traditionally start at n = 0
        for (int n = 0; n < terms; n++) {

            // Step 1: Calculate the exponent (2^n)
            int power = 1 << n;

            // Step 2: Calculate 2^(power) + 1
            // FIXED: Used BigInteger.valueOf(2) to make it compatible with all Java versions!
            BigInteger fermatValue = BigInteger.valueOf(2).pow(power).add(BigInteger.ONE);

            // Print the result formatted nicely
            System.out.println("F(" + n + ") = " + fermatValue);
        }

        System.out.println(); // Move to the next line when finished
    }

    public void AmicableNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Amicable Numbers Finder ---");
        System.out.print("Find amicable pairs up to what limit?: ");
        int limit = input.nextInt();

        // Validation: Ensure the user enters a positive number
        if (limit <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        System.out.println("Amicable Pairs up to " + limit + ":");
        boolean foundAny = false; // To track if we actually find any pairs

        // Iterate through all numbers starting from 2 up to the user's limit
        for (int a = 2; a <= limit; a++) {

            // Get the sum of proper divisors for our current number 'a'
            int b = getSumOfProperDivisors(a);

            // Check if they form an amicable pair:
            // 1. a < b : This prevents printing the same pair twice (e.g., 220,284 and 284,220)
            // 2. b <= limit : Ensures the second number also respects the user's limit
            // 3. getSumOfProperDivisors(b) == a : The core definition of amicable numbers
            if (a < b && b <= limit && getSumOfProperDivisors(b) == a) {
                System.out.println("(" + a + ", " + b + ")");
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No amicable pairs found in this range.");
        }
        System.out.println(); // Move to the next line when finished
    }

    // HELPER METHOD: Highly optimized divisor sum calculator
    private int getSumOfProperDivisors(int n) {
        int sum = 1; // 1 is always a proper divisor for every number

        // Optimization: We only need to loop up to the square root of 'n'.
        // For example, if n=100 and we find divisor 2, we automatically know 50 is also a divisor.
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i; // Add the small divisor

                // Add the large counterpart divisor, but make sure we don't add the square root twice
                // (e.g., for 36, don't add 6 twice)
                if (i * i != n) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }


    public void AbundantNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Abundant Numbers Finder ---");
        System.out.print("Find abundant numbers up to what limit?: ");
        int limit = input.nextInt();

        // Validation: Ensure the user enters a positive number
        if (limit <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        System.out.print("Abundant Numbers up to " + limit + ": ");
        boolean foundAny = false; // To track if we actually find any

        // Loop through all numbers from 1 up to the user's limit
        for (int number = 1; number <= limit; number++) {

            int sumOfDivisors = 0;

            // 1 is a proper divisor for every number greater than 1
            if (number > 1) {
                sumOfDivisors = 1;
            }

            // Optimized divisor calculation (looping only up to the square root)
            for (int i = 2; i * i <= number; i++) {

                // If 'i' is a divisor
                if (number % i == 0) {
                    sumOfDivisors += i; // Add the small divisor

                    // Add the large counterpart divisor (e.g., if number is 12 and i is 2, add 6)
                    // We check (i * i != number) to avoid adding the square root twice (like 4 for 16)
                    if (i * i != number) {
                        sumOfDivisors += number / i;
                    }
                }
            }

            // The core logic: If the sum of proper divisors is strictly greater than the number itself
            if (sumOfDivisors > number) {
                System.out.print(number + " ");
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.print("None found in this range.");
        }

        System.out.println(); // Move to the next line when finished
    }


    public void LucasSeries() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Lucas Series Generator ---");
        System.out.print("How many Lucas terms do you want to see?: ");
        int n = input.nextInt();

        // Validation: Ensure the user enters a positive number
        if (n <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        System.out.print("Lucas Series (" + n + " terms): ");

        // Unlike Fibonacci (which starts with 0 and 1), Lucas starts with 2 and 1
        // We use 'long' because these numbers grow very fast and would break a standard 'int'
        long first = 2;
        long second = 1;

        // Optimized iterative loop (O(n) Time, O(1) Space)
        for (int i = 0; i < n; i++) {
            // Print the current term
            System.out.print(first + " ");

            // Calculate the next term by summing the previous two
            long next = first + second;

            // Shift the values forward for the next iteration
            first = second;
            second = next;
        }

        System.out.println(); // Move to the next line after printing the sequence
    }

    // 12. Tetranacci Numbers
    public void TetranacciNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Tetranacci Series Generator ---");
        System.out.print("How many Tetranacci terms do you want to see?: ");
        int n = input.nextInt();

        // Validation: Ensure the user enters a positive number
        if (n <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        System.out.print("Tetranacci Series (" + n + " terms): ");

        // We use 'long' because summing four numbers causes the values to grow incredibly fast
        // These represent the first four numbers of the sequence: T(0), T(1), T(2), T(3)
        long a = 0;
        long b = 0;
        long c = 0;
        long d = 1;

        // Optimized iterative loop (O(n) Time, O(1) Space)
        for (int i = 0; i < n; i++) {
            // Print the current term
            System.out.print(a + " ");

            // Calculate the next term by summing the previous four
            long next = a + b + c + d;

            // Shift the values forward for the next iteration
            a = b;
            b = c;
            c = d;
            d = next;
        }

        System.out.println(); // Move to the next line after printing the sequence
    }

    public void TwinPrimes() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Twin Primes Finder ---");
        System.out.print("Find twin primes up to what limit?: ");
        int limit = input.nextInt();

        // Validation: Ensure the user enters a valid limit
        // The first twin prime pair is (3, 5), so limits under 5 won't have any pairs
        if (limit < 5) {
            System.out.println("Please enter a number of 5 or higher to find twin primes.");
            return; // Exit the method early
        }

        System.out.println("Twin Primes up to " + limit + ":");
        boolean foundAny = false;

        // We start from 3 because 2 is the only even prime, and it cannot have a twin (2+2=4 is not prime)
        // We loop up to (limit - 2) so we don't accidentally check a pair that exceeds the user's limit
        for (int n = 3; n <= limit - 2; n += 2) {

            // Check if BOTH 'n' and 'n + 2' are prime
            if (isPrime(n) && isPrime(n + 2)) {
                System.out.println("(" + n + ", " + (n + 2) + ")");
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No twin primes found in this range.");
        }

        System.out.println(); // Move to the next line when finished
    }

    // HELPER METHOD: Highly optimized prime checker
    private boolean isPrime(int number) {
        // Numbers less than 2 are not prime
        if (number <= 1) {
            return false;
        }
        // 2 and 3 are prime numbers
        if (number <= 3) {
            return true;
        }
        // Eliminate multiples of 2 and 3 immediately (huge performance boost)
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        // Check for factors from 5 up to the square root of the number.
        // We can increment by 6 (i += 6) because all primes greater than 3
        // can be written in the form 6k - 1 or 6k + 1.
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }

        return true; // No divisors found, it must be prime
    }


    // Method to execute when choice 14 is selected
    public void WoodallNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Woodall Numbers Generator ---");
        System.out.print("How many Woodall numbers do you want to generate?: ");
        int terms = input.nextInt();

        // Validation: Ensure the user enters a positive number
        if (terms <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return; // Exit the method early
        }

        System.out.print("Woodall Numbers (" + terms + " terms): ");

        // Loop to generate the sequence starting from n = 1
        for (int n = 1; n <= terms; n++) {

            // Formula: n * 2^n - 1
            // We use '1L << n' (bitwise shift) as a highly optimized way to calculate 2^n
            // We cast everything to 'long' because exponential growth makes the numbers very large
            long woodallValue = (long) n * (1L << n) - 1;

            System.out.print(woodallValue + " ");
        }

        System.out.println(); // Move to the next line after printing the sequence
    }

    public void MersenneNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Mersenne Numbers Generator ---");
        System.out.print("How many Mersenne numbers do you want to generate?: ");
        int terms = input.nextInt();

        if (terms <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return;
        }

        System.out.print("Mersenne Numbers (" + terms + " terms): ");

        // Formula: M(n) = 2^n - 1
        for (int n = 1; n <= terms; n++) {
            // Using bitwise shift (1L << n) to quickly calculate 2^n
            long mersenneValue = (1L << n) - 1;
            System.out.print(mersenneValue + " ");
        }
        System.out.println();
    }

    public void HarshadNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Harshad Numbers Finder ---");
        System.out.print("Find Harshad numbers up to what limit?: ");
        int limit = input.nextInt();

        if (limit <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return;
        }

        System.out.print("Harshad Numbers up to " + limit + ": ");

        for (int i = 1; i <= limit; i++) {
            int sumOfDigits = 0;
            int temp = i;

            // Calculate the sum of the digits
            while (temp > 0) {
                sumOfDigits += temp % 10;
                temp /= 10;
            }

            // A Harshad number is divisible by the sum of its digits
            if (i % sumOfDigits == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void CyclicNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Cyclic Number Checker ---");
        System.out.println("(Hint: The most famous cyclic number is 142857)");
        System.out.print("Enter a number to check: ");
        String numberStr = input.next();

        long number = Long.parseLong(numberStr);
        int length = numberStr.length();
        boolean isCyclic = true;

        // To be cyclic, its multiples must be permutations of the original digits.
        // We double the string (e.g., 142857142857) to easily check for circular permutations
        String doubledStr = numberStr + numberStr;

        System.out.println("Checking permutations...");
        for (int i = 1; i <= length; i++) {
            long multiple = number * i;

            // Format the multiple to ensure it has the same number of digits (preserves leading zeros)
            String formatStr = "%0" + length + "d";
            String multipleStr = String.format(formatStr, multiple);

            System.out.println(number + " x " + i + " = " + multipleStr);

            // If the doubled original string doesn't contain the multiple, it's not cyclic
            if (!doubledStr.contains(multipleStr)) {
                isCyclic = false;
                break;
            }
        }

        if (isCyclic) {
            System.out.println(number + " is a TRUE Cyclic Number!");
        } else {
            System.out.println(number + " is NOT a Cyclic Number.");
        }
    }

    public void TauNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Tau Numbers Finder ---");
        System.out.print("Find Tau numbers up to what limit?: ");
        int limit = input.nextInt();

        if (limit <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return;
        }

        System.out.print("Tau Numbers up to " + limit + ": ");

        for (int n = 1; n <= limit; n++) {
            int divisorCount = 0;

            // Calculate how many total divisors the number has (optimized up to square root)
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    divisorCount++; // Count the small divisor
                    if (i * i != n) {
                        divisorCount++; // Count the paired large divisor
                    }
                }
            }

            // A Tau number is divisible by its total number of divisors
            if (n % divisorCount == 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }

    public void BetrothedNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Betrothed Pairs Finder ---");
        System.out.print("Find Betrothed pairs up to what limit?: ");
        int limit = input.nextInt();

        if (limit <= 0) {
            System.out.println("Please enter a valid number greater than 0.");
            return;
        }

        System.out.println("Betrothed Pairs up to " + limit + ":");
        boolean foundAny = false;

        for (int a = 2; a <= limit; a++) {
            // We reuse the getSumOfProperDivisors method we wrote for Amicable numbers
            // Betrothed definition: Sum of proper divisors of 'a' equals 'b' + 1
            int b = getSumOfProperDivisors(a) - 1;

            // Validation: Ensure b > a (no duplicates), b is within limit, and check reverse condition
            if (a < b && b <= limit && getSumOfProperDivisors(b) - 1 == a) {
                System.out.println("(" + a + ", " + b + ")");
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No betrothed pairs found in this range.");
        }
    }

    public void KaprekarConstant() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Kaprekar's Constant (6174) Routine ---");
        System.out.print("Enter a 4-digit number (with at least two different digits): ");
        int number = input.nextInt();

        // Validate input length
        if (number < 1000 || number > 9999) {
            System.out.println("Invalid input! You must enter exactly a 4-digit number.");
            return;
        }

        int current = number;
        int steps = 0;

        System.out.println("Starting the routine...");

        // Loop until we hit the magic constant 6174 or hit 0 (which means all digits were identical)
        while (current != 6174 && current != 0) {
            steps++;

            // Format the number as a 4-character string (preserves leading zeros like 0999)
            String numberStr = String.format("%04d", current);
            char[] digits = numberStr.toCharArray();

            // Sort digits ascending
            Arrays.sort(digits);
            String ascendingStr = new String(digits);

            // Reverse the string to get descending order
            String descendingStr = new StringBuilder(ascendingStr).reverse().toString();

            // Convert back to integers
            int asc = Integer.parseInt(ascendingStr);
            int desc = Integer.parseInt(descendingStr);

            // Subtract smaller from larger
            current = desc - asc;

            // Print the current step
            System.out.printf("Step %d: %04d - %04d = %04d\n", steps, desc, asc, current);

            // Security breaker to prevent infinite loops if user enters identical digits (e.g., 1111)
            if (current == 0) {
                System.out.println("Routine failed. You entered a number with identical digits.");
                return;
            }
        }

        System.out.println("Success! Reached Kaprekar's Constant (6174) in " + steps + " steps.");
    }

}

