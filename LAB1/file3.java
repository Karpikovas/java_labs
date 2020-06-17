import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class file3
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String reverse = "";
		for(int i = args.length - 1; i >= 0; i--) {
            for (int j = args[i].length() - 1; j >=0; j--){
            		reverse += args[i].charAt(j);
            }
            reverse += " ";
        }
        System.out.println(reverse);
	}
}