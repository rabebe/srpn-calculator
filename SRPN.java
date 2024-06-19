import java.util.Stack;
import java.lang.Integer;


/**
 Saturated Reverse Polish Calculator
 Java program that matches the functionality of SRPN as closely as possible.
 */

public class SRPN {

    long n1;
    long n2;
    // Variables that store numbers entered by user
    // Long type allows for inputs larger than Integer.MAX_VALUE() in order to apply saturation


    private Stack<String> stack = new Stack<>();
    // stack created to store and call operands in the calculator


    public void processCommand(String s) {
        R_List list = new R_List();
        // Object that allows the use of getNextvalue method when r is encountered

        for (String input: s.replaceAll("(?<=\\p{L})(?=\\p{L})|(?<=[^\\d-\\n])(?=-?\\d)|(?<=\\w)(?=[^\\w\\s])|(?<=\\W)(?=[+\\-*/%])", " ").split("\\n+|\\s+"))
        /* This regular expression is used to split a string by adding spaces between consecutive letters and symbols.
         The replaceAll replaces those strings with the same values in the string where consecutive non digits and
         digits,letters and symbols are replaced with the same values separated by spaces so that they can be split by
         the whitespace delimiter.
         */
        {

            try {
                /* Tries all the characters that have if else statements and will print an error message
                using the catch statement
                 */
                if (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/") &&
                        !input.equals("%") && !input.equals("^") && !input.contains("#") && !input.contains("=")
                        && !input.contains("d") && !input.equals("r") && !input.equals("")) {

                    if (Long.parseLong(input) >= Integer.MAX_VALUE){
                        stack.push(String.valueOf(Integer.MAX_VALUE));
                    }
                    else if (Long.parseLong(input) <= Integer.MIN_VALUE) {
                        stack.push(String.valueOf(Integer.MIN_VALUE));
                    }
                    else {
                        stack.push(input);
                    }
                    /* If the input is greater than the Integer.MAX_VALUE (2147483647), it will apply saturation and
                    add 2147483647 to the stack. If the input is less than the Integer.MIN_VALUE (-2147483648),
                    it will apply saturation and return -2147483648
                     saturation by adding 2147483647 to the stack
                     */

                    /* If else statements for '+' '-' '*' '/' '%' '/':
                    This section checks if the following operators are inputted. If they are, it tests if the stack is
                    empty and will print "Stack underflow." If the stack is full, it will print "Stack overflow." If
                    neither of those conditions are met, it will pop the last number in the stack.
                    If only one number is entered it be saved into the stack. Otherwise if other numbers are inputted,
                    the calculation depending on the operator used will done. If the result is greater than the
                    Integer.MAX_VALUE, the Integer.MAX_VALUE will be pushed to the stack. If the result is less than
                    the Integer.MIN_VALUE, the Integer.MIN_VALUE will be pushed on the stack. It the result does not fit
                    either of those conditions, the result will be pushed on the stack.
                     */
                }
                else if (input.equals("+")) { // addition
                    if (stack.empty()) {
                        System.err.println("Stack underflow.");
                    }
                    else if (stack.size() >= 23) {
                        System.err.println("Stack overflow.");
                    }
                    else {
                        n2 = Long.parseLong(stack.pop());
                        if (stack.empty()) {
                            System.err.println("Stack underflow.");
                            stack.push(String.valueOf(n2));
                        }
                        else {
                            n1 = Long.parseLong(stack.pop());
                            if (n1 + n2 > Integer.MAX_VALUE) {
                                stack.push(String.valueOf(Integer.MAX_VALUE));
                            }
                            else if (n1 + n2 < Integer.MIN_VALUE) {
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else {
                                stack.push(String.valueOf(n1 + n2));
                            }
                        }
                    }
                }
                else if (input.equals("-")) { // subtraction
                    if (stack.empty()) {
                        System.err.println("Stack underflow.");
                    }
                    else if (stack.size() >= 23) {
                        System.err.println("Stack overflow.");
                    }
                    else {
                        n2 = Long.parseLong(stack.pop());
                        if (stack.empty()) {
                            System.err.println("Stack underflow.");
                            stack.push(String.valueOf(n2));

                        } else {
                            n1 = Long.parseLong(stack.pop());
                            if (n1 - n2 < Integer.MIN_VALUE) {
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else {
                                stack.push(String.valueOf(n1 - n2));
                            }
                        }
                    }
                } else if (input.equals("*")) { // multiplication
                    if (stack.empty()) {
                        System.err.println("Stack underflow.");
                    }
                    else if (stack.size() >= 23) {
                        System.err.println("Stack overflow.");
                    }
                    else {
                        n2 = Long.parseLong(stack.pop());
                        if (stack.empty()) {
                            System.err.println("Stack underflow.");
                            stack.push(String.valueOf(n2));

                        } else {
                            n1 = Long.parseLong(stack.pop());
                            if (n1 * n2 > Integer.MAX_VALUE) {
                                stack.push(String.valueOf(Integer.MAX_VALUE));
                            } else if (n1 * n2 < Integer.MIN_VALUE) {
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else {
                                stack.push(String.valueOf(n1 * n2));
                            }
                        }
                    }
                } else if (input.equals("/")) { // division
                    if (stack.empty()) {
                        System.err.println("Stack underflow.");
                    }
                    else if (stack.size() >= 23) {
                        System.err.println("Stack overflow.");
                    }
                    else {
                        n2 = Long.parseLong(stack.pop());
                        if (stack.empty()) {
                            System.err.println("Stack underflow.");
                            stack.push(String.valueOf(n2));
                        }
                        else {
                            n1 = Long.parseLong(stack.pop());
                            if (n1 / n2 > Integer.MAX_VALUE) {
                                stack.push(String.valueOf(Integer.MAX_VALUE));
                            } else if (n1 / n2 < Integer.MIN_VALUE) {
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else {
                                stack.push(String.valueOf(n1 / n2));
                            }
                        }
                    }
                } else if (input.equals("%")) { // modulo
                    if (stack.empty()) {
                        System.err.println("Stack underflow.");
                    }
                    else if (stack.size() >= 23) {
                        System.err.println("Stack overflow.");
                    }
                    else {
                        n2 = Long.parseLong(stack.pop());
                        if (stack.empty()) {
                            System.err.println("Stack underflow.");
                            stack.push(String.valueOf(n2));
                        }
                        else {
                            n1 = Long.parseLong(stack.pop());
                            if (n1 % n2 > Integer.MAX_VALUE) {
                                stack.push(String.valueOf(Integer.MAX_VALUE));
                            } else if (n1 % n2 < Integer.MIN_VALUE) {
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else {
                                stack.push(String.valueOf(n1 % n2));
                            }
                        }
                    }
                }
                else if (input.equals("^")) { // power
                    if (stack.empty()) {
                        System.err.println("Stack underflow.");
                    }
                    else if (stack.size() >= 23) {
                        System.err.println("Stack overflow.");
                    }
                    else {
                        n2 = Long.parseLong(stack.pop());
                        if (stack.empty()) {
                            System.err.println("Stack underflow.");
                            stack.push(String.valueOf(n2));
                        }
                        else {
                            n1 = Long.parseLong(stack.pop());
                            if (n2 < 0) {
                                System.err.println("Negative power.");
                            }
                            else if (stack.empty()) {
                                stack.push(String.valueOf((int)Math.pow(n1, n2)));
                            }
                            else if (Math.pow(n1, n2) > Integer.MAX_VALUE) {
                                stack.push(String.valueOf(Integer.MAX_VALUE));
                            } else if (Math.pow(n1, n2) < Integer.MIN_VALUE) {
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else {
                                stack.push(String.valueOf((int)Math.pow(n1, n2)));
                            }
                        }
                    }
                } else if (input.contains("d")) {
                    /* If the letter 'd' is encountered, first it will check if the stack empty and will print
                    Integer.MIN_VALUE. Otherwise, it will print the entire stack.
                     */
                    if (stack.size() == 0) {
                        System.out.println(-2147483647);
                    } else {
                            stack.forEach(System.out::println);
                    }
                }
                /* If the letter 'r' is encountered, first it checks if the stack full and prints the error message
                if that condition is true. If r is used in a calculation its value could become greater the
                Integer.MAX_VALUE or less than the Integer.MIN_VALUE. When this is the case, saturation will be applied
                and that saturated number will be added to the stack. Otherwise, it will use the getNextValue function
                from the R_List class to get the value of r.
                 */
                else if (input.equals("r")) {
                    if (stack.size() >= 23) {
                        System.err.println("Stack overflow.");
                    }
                    else {
                        int current = list.getNextValue();
                        if (current > Integer.MAX_VALUE) {
                            stack.push(String.valueOf(Integer.MAX_VALUE));
                        } else if (current < Integer.MIN_VALUE) {
                            stack.push(String.valueOf(Integer.MIN_VALUE));
                        } else {
                            stack.push(Integer.toString(current));
                        }
                    }
                }

                else if (input.contains("=")) {
                    /* If the letter '=' is encountered it will first check if the stack is empty and print stack empty.
                If the stack is full, it will print stack overflow. Otherwise it will retrieve the element at the top
                of the stack
                 */
                    if (stack.empty()) {
                        System.err.println("Stack empty.");
                    } else {
                        if (stack.size() >= 23) {
                            System.err.println("Stack overflow.");
                        } else {
                            System.out.println(stack.peek());
                        }
                    }
                }
                else if (input.equals("")) { // when input is null
                    break;
                }
                else if (input.contains("#")){ // when input contains #
                    break;
                }
            }
            catch(Exception e){
                // catch will run if a character is encountered that is not defined in the try statement
                char quote = '"';
                System.err.println("Unrecognised operator or operand " + quote + input + quote + ".");
            }
        }
    }
}
  
    

  
