import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class file2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		for (int i = 1; i < 501; i++){
			if (i % 5 == 0){
				if (i % 7 == 0)
					System.out.println("fizzbuzz");
				else
					System.out.println("fizz");
			}
			else if (i % 7 == 0){
				System.out.println("buzz");
			}
			else
				System.out.println(i);
		}
	}
}