package com.imitadvisory;

import java.util.*;
class Solution{

    private static boolean enableDebug = true;
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            debug("Evaluating: " + input);
            Stack<Character> st = new Stack<Character>();
            for(int i=0; i<input.length(); i++){
                debug("   Checking: " + input.charAt(i));
                if(st.empty()){
                    st.push(input.charAt(i));
                    debug("     Empty Stack, pushed: " + st.peek());
                }
                else {
                    debug("     Top of stack is: " + st.peek());
                    debug("     Checking if '" + input.charAt(i) + "'  is a closing to: " + st.peek());
                    String expectedClosingChar = getClosingChar(st.peek());
                    debug("     Expected closing char of '" + st.peek() + "'  is: " + expectedClosingChar);
                    if(expectedClosingChar.equals(input.charAt(i) + "")){
                        char poppedValue = st.pop();
                        debug("     Hazzaaahh!! Match! Popped value is: " + poppedValue);
                        debug("     Moving on..");

                    }
                    //if(getClosingChar(st.peek()).equals(input.charAt(i))){
                    //}
                }

            }
            debug("Done, Result: ");

            if(st.empty()){
                //Empty Stack means its balanced!!!
                System.out.println("true");
            }
            else {
                // Sad. There's still stuff left over!
                System.out.println("false");
            }
        }

    }
    private static String getClosingChar(char openingChar){
        switch(openingChar){
            case '{':
                return "}";
            case '(':
                return ")";
            case '[':
                return "]";
            case '<':
                return ">";
            default:
                return "**";
        }
    }
    private static void debug(Object obj){
        if(enableDebug){
            System.out.println(obj);
        }
    }
}
