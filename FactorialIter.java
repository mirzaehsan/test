// FactorialIter - calculating the Factorial with an iterative algorithm
public class FactorialIter {

    private static final int INPUT_LOWER_BOUND = 0;
    private static final int INPUT_UPPER_BOUND = 20;

    public class InvalidNumberException extends Exception { // Custom exception to check if input is number
        public InvalidNumberException(String input) {
            super("Given input: \"" + input + "\" is not a number");
        }
    }



    public class UpperBoundException extends Exception { // Custom exception to check range of input
        public UpperBoundException(String input) {
            super("Given input exceeds the highest range :" + INPUT_UPPER_BOUND);
        }
    }

    public class LowerBoundException extends Exception { // Custom exception to check range of input
        public LowerBoundException(String input) {
            super("Given input is below the lowest range :" + INPUT_LOWER_BOUND);
        }
    }

    public static void main(String[] args) { // Frame for reading a value
        if (args.length > 0) {            // from the command line
            String str = args[0];
            try {
                FactorialIter factorialIter = new FactorialIter(str);
            }catch (Exception e){
                System.out.println("Following exception occurred:\n" + e.getMessage());
            }
        } else
            System.out.println("use syntax: java FactorialIter n");
    }


    public FactorialIter(String str) throws InvalidNumberException, UpperBoundException,LowerBoundException { // Printing out the result
        // check for invalid inputs
        if (!str.matches("(-?)\\d+")) { // Checks if numeric
            throw new InvalidNumberException(str);
        }
        int num = Integer.parseInt(str);
        if (num < INPUT_LOWER_BOUND ) {
            throw new LowerBoundException(str);
        }
        if (num > INPUT_UPPER_BOUND) {
            throw new UpperBoundException(str);
        }
        System.out.println(num + "! = " + factorial(num));
        System.out.println("for testing");
    }

    public long factorial(int n) { // iterative algorithm
        long res = 1;
        for (int i = n; i > 1; i--)
            res = res * i;
        return res;
    }

}
