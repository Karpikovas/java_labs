import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class file4
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int cnt = Integer.parseInt(args[0]);
		int[] f = new int[cnt];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < cnt; i++) {
    		f[i] = f[i - 1] + f[i - 2];
		}
		for (int i = 0; i < cnt; i++) {
    		System.out.print(f[i]);
    		System.out.print(", ");
		}    
	}
}