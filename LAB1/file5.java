import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class file5
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int cnt = Integer.parseInt(args[0]);
		int result = 1;
		for (int i = 1; i <= cnt; i++){
			result = result * i;
		}
		System.out.print(result);
	}
}