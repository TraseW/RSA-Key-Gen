import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;

public class test
{
	public static void main(String args[])
	{

		keyGen();


	}

	public static int randPrime(int range)
	{
		int rand = (int)(Math.random() * range + 1);
		int dir = (int)(Math.random() * 2)==0?-1:1;

		while (!isPrime(rand))
		{
			rand += dir;
			if (rand < 1) rand = (int)(Math.random() * range + 1);
		}
		return rand;

	}

	public static boolean isPrime(int test)
	{
		if (test%2 == 0 || test==1)
			return false;

		for (int i = 3; i<Math.sqrt(test); i += 2)
		{
			if (test%i==0) return false;
		}
		return true;
	}

	public static boolean relPrime(int one, int two)
	{
		ArrayList<Integer> oneList = divBy(one);
		ArrayList<Integer> twoList = divBy(two);

		for (Integer i: oneList)
			for (Integer o: twoList)
				if (i.intValue()==o.intValue())
					return false;
		return true;

	}

	public static ArrayList<Integer> divBy(int check)
	{
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int i = 2; i <= check; i++)
		{
			if (check%i==0)
			{
				out.add(new Integer(i));
			}
		}
		return out;
	}

	public static void keyGen()
	{
		int pOne = randPrime(100);
		int pTwo = randPrime(100);
		System.out.println(pOne + "  " + pTwo);
		while (pOne==pTwo)
		{
			pTwo = randPrime(10000);
		}

		int n = pOne * pTwo;
		int z = (pOne-1)*(pTwo-1);

		int k = (int)(Math.random()*z);//k is e in example bookmarked
		while (k>=z || !relPrime(n, k))
			k = randPrime(z);
		int d = mkD(k, z);
		System.out.println("e" + k);
		System.out.println("z" + z);
		System.out.println("n" + n);
		System.out.println("d" + d);
		System.out.println("");
	}

	static public int mkD(int k, int z)
	{
		int d = (int)(Math.random()*500);
		while ((d*k)%z!=1)
		{
			d++;
		}
		int x = d - 1;
		while ((x*k)%z!=1 && x != 0)
		{
			x--;
		}
		return x>1?x:d;
	}
} // a b c    1 1141 37    1 2