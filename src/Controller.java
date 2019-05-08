import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private String txt1;
    private File txt2;
    public Controller(File txt2) {
        this.txt2=txt2;
    }

    public void read_file_txt(File txt2) throws IOException {

        this.txt2=txt2;
        FileInputStream f_stream = new FileInputStream(txt2);
        BufferedReader br = new BufferedReader(new InputStreamReader(f_stream));

        String strLine;
        ArrayList<String> list = new ArrayList<String>();


//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            list.add(strLine);
            System.out.println (strLine);
            System.out.println(list.size());
        }

//Close the input stream
        f_stream.close();
    };
    private void creation_mtx(){

    };
    private void movement_by_mtx(){

    };

        char[][] matrix = new char[11][11];

        public void add_number(){};
        public void encryption () {
            System.out.println("Шифрование");
        }
        ;
        public void decryption () {
            System.out.println("Расшифровка");
        }
        ;
        public void render () {

        }

    public String codeString (String input){
        char[][] matrix = new char[11][11];

        iterateCodeMatrix (matrix, 5, 5, true, 0, input);

        String output = "";
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                output += matrix[j][i];
            }
        }


        return output;
    }
    private void iterateCodeMatrix (char[][] matrix, int x, int y, boolean goRight, int length, String s){
        /* This recursive method fills the matrix this way:
         * (n is a number of an iteration)
         *  4 4 4 4 3
         *  4 2 2 1 3
         *  4 2 0 1 3
         *  4 2 3 3 3
         *  4 5 5 5 5
         */

        int iterator = 0;

        // if first iteration
        if (length == 0){
            matrix[x][y] = s.charAt(iterator);
            iterateCodeMatrix(matrix, x + 1, y, goRight, length + 1, s.substring(1));
        }
        //if last iteration
        else if (length == matrix.length){
            for (int i = 1; i < matrix.length; i++){
                matrix[i][y] = s.charAt(iterator);
                iterator++;
            }

            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[0].length; j++){
                    System.out.print(matrix[j][i] + " ");
                }
                System.out.print("\n");
            }
        }
        // any other iteration
        else {
            if (goRight){
                //go right
                for (int i = 0; i < length; i++){
                    matrix[x + i][y] = s.charAt(iterator);
                    iterator++;
                }
                //go up
                for (int j = 0; j < length; j++){
                    matrix[x + length - 1][y - j - 1] = s.charAt(iterator);
                    iterator++;
                }
                //next iteration
                iterateCodeMatrix(matrix, x + length - 2, y - length, !goRight, length + 1, s.substring(length * 2));
            }
            else if (!goRight){
                //go left
                for (int i = 0; i < length; i++){
                    matrix[x - i][y] = s.charAt(iterator);
                    iterator++;
                }
                //go down
                for (int j = 0; j < length; j++){
                    matrix[x - length + 1][y + j + 1] = s.charAt(iterator);
                    iterator++;
                }
                //next iteration
                iterateCodeMatrix(matrix, x - length + 2, y + length, !goRight, length + 1, s.substring(length * 2));
            }

        }

    }










    }

