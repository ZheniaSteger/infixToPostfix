//InfixToPostfix.java

import java.io.*;
import java.util.*;
/**
 * Stack Lab
 * InfixToPostfix class converts an infix expression read from a file to a postfix expression which is then written to a file.
 * This class uses the ObjectStack class for conversion.
 * @author Zhenia Steger
 * Palomar College
 */
public class InfixToPostfix
{
    ObjectStack operatorStack = new ObjectStack();
    private PrintWriter pw;
    String exp;
    String expPost = "";
    int priority = 0;

    /**
     * Class constructor
     * @param pw Accepts parameter for access to PrintWriter
     */
    public InfixToPostfix(PrintWriter pw) {
        this.pw = pw;
    }
    /**
     * Converts passed string to a PostFix expression.
     * @param exp Infix expression passed as string
     * @return expPost The converted string
     */
    public String toPostfix(String exp) {
        expPost = "";
        this.exp = exp;
        for (int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9')
                expPost += ch;
            else if (ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                while (!operatorStack.isEmpty() && priority((Character) operatorStack.top()) >= priority(ch) && (char)operatorStack.top() != '(')
                    expPost += operatorStack.pop();
                operatorStack.push(ch);}
            else if (ch == '(') {
                operatorStack.push(ch);}
            else if (ch == ')') {
                while ((char)operatorStack.top() != '(')
                    expPost +=operatorStack.pop();
            operatorStack.pop();}
            else if (ch == ' ') {
            }
        }
        while (!operatorStack.isEmpty())
            expPost += operatorStack.pop();

        System.out.println(expPost);
        pw.println(expPost);
        operatorStack.clear();
        return expPost;

    }
    /**
     * Determines priority of mathematical operation.
     * @param op Operand passed as character to determine its priority.
     * @return int Priority of operand
     */
    public int priority(char op) {
        switch (op) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default : return 0;
        }
    }
}
