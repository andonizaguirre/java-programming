
public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        //write some code here
        if (number1 > number2 && number1 > number3) {
            return number1;
        } else if (number2 > number1 && number2 > number3) {
            return number2;
        } else {
            return number3;
        }        
//        int greatest = number1;
//        if (number2 > greatest) {
//            greatest = number2;
//        }
//        if (number3 > greatest) {
//            greatest = number3;
//        }
//        return greatest;        
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}
