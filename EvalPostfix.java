//EvalPostfix.java

import java.io.*;
import java.lang.Math;
/**
 * Stack Lab
 * EvalPostFix class evaluates expression passed from InfixToPostfix class
 * @author Zhenia Steger
 * Palomar College
 */
public class EvalPostfix
{
    ObjectStack evalStack = new ObjectStack();
    private PrintWriter pw;
    String expToEval;
    int temp1;
    int temp2;
    int result = 0;
    int finalResult = 0;
    /**
     * Class constructor
     * @param pw Accepts parameter for access to PrintWriter
     */
    public EvalPostfix(PrintWriter pw) {
        this.pw = pw;
    }
    /**
     * Evaluates the PostFix expression that is passed
     * @param expToEval PostFix expression passed as a String
     */
    public void evaluatePostfix(String expToEval){
        this.expToEval = expToEval;
        for (int i = 0; i < expToEval.length(); i++) {
            char ch = expToEval.charAt(i);

            if (ch >= '0' && ch <= '9') {
                evalStack.push(ch - 48);}
            else if (ch == '^'){
                temp2 = (Integer) evalStack.pop();
                temp1 = (Integer) evalStack.pop();
                evalStack.push((int) Math.pow(temp1,temp2));}
            else if (ch == '*'){
                temp2 = (Integer) evalStack.pop();
                temp1 = (Integer) evalStack.pop();
                evalStack.push(temp1 * temp2);}
            else if (ch == '/'){
                temp2 = (Integer) evalStack.pop();
                temp1 = (Integer) evalStack.pop();
                evalStack.push(temp1 / temp2);}
            else if (ch == '+'){
                temp2 = (Integer) evalStack.pop();
                temp1 = (Integer) evalStack.pop();
                evalStack.push(temp1 + temp2);}
            else if (ch == '-'){
                temp2 = (Integer) evalStack.pop();
                temp1 = (Integer) evalStack.pop();
                evalStack.push(temp1 - temp2);}
        }
        finalResult = (Integer) evalStack.pop();
        System.out.println(finalResult);
        pw.println(finalResult);
    }
}
