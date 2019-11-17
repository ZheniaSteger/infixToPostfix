//ObjectStackInterface.java

/**
 *
 * @author Zhenia Steger
 *
 */
public interface ObjectStackInterface
{
    boolean isFull();  //determines if the stack is full
    boolean isEmpty();  //determines if the stack is empty
    void clear();  //clears the stack of objects
    void push(Object o);  //pushes and Object onto the stack
    Object pop();  //pops Object on top of stack
    Object top();  //returns Object at top of stack
}
