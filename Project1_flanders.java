/*
This program is intended to receive arguments from the command line in the form of "integer value:integer radix"
For example, 10110110:2 means a value of 10110110 in binary (radix 2)
The program converts each argument into a decimal value (radix 10) and prints the original value and radix as well as
the decimal conversion to the user
 */
public class Project1_flanders {
    public static void main (String[] args){
        int split_index, decimal, radix_int;
        String value, radix_str;

        for (String arg:args){
            split_index = arg.indexOf(':');
            //finds location of : seperator
            //prints error message and moves on to next argument if argument does not contain a : symbol
            if (split_index == -1){
                System.out.println("MALFORMED STRING ERROR!"+arg+" does not contain the \":\" character");
                continue;
            }
            //argument is split at : seperator into a value string and a radix string
            value = arg.substring(0,split_index);
            radix_str = arg.substring(split_index+1);
            //program attempts to convert argument to its equivalent decimal value and print the results to the user
            try {
                radix_int = Integer.parseInt(radix_str);
                decimal = Integer.parseInt(value, radix_int);
                System.out.println(value+" base "+radix_int+" is "+decimal+" base 10");
            }
            //if the argument cannot be converted to decimal, the user is informed with an error message
            catch (Exception e) {
                System.out.println("BAD CONVERSION ERROR! The argument "+arg+" could not be converted to base 10");
            }
        }

    }
}