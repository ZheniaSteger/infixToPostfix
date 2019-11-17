//Driver.java

import java.io.*;
import java.util.Scanner;
/**
 * Stack Lab
 * Infix To Postfix Converter
 * @author Zhenia Steger
 * Palomar College
 */
public class Driver {
    /**
     * Main method runs the program
     */
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        Scanner scan = new Scanner(new File("infix.txt"));
        System.out.println("Evaluating expressions from infix.txt");
        InfixToPostfix conv = new InfixToPostfix(pw);
        EvalPostfix eval = new EvalPostfix(pw);
        String post;

        while (scan.hasNext()) {
            String exp = scan.nextLine();
            System.out.println(exp);
            pw.println(exp);
            post = conv.toPostfix(exp);
            eval.evaluatePostfix(post);
        }

        scan.close();
        pw.close();
    }
}
