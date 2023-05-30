
public class Program {

    public static void main(String[] args) {
        // Test your method here      
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder values = new StringBuilder();
//        String values = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                values.append(array[i][j]);
//                values = values + array[i][j]; // It creates multiple Strings
            }
            values.append("\n");
//            values = values + "\n";
        }
        return values.toString();
    }
}
