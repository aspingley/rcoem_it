// This code is intented to provide examples of static polymorphism

import java.util.ArrayList;


class Base{
		public void test1(){}
		public void test2(){}
}

class Derived extends Base{
		public Derived(){}
		public Derived(int r){}
		public void test2(){}
}


public class test{
		public static void main(){

				// parameterization via templates is an example of static polymorphism
				ArrayList al = new ArrayList();
				ArrayList<String> alInt = new ArrayList<String>();
				ArrayList<test> alTest = new ArrayList<test>();

				Derived d = new Derived();
				Derived d2 = new Derived(100);
				d.test1();
				d.test2();
				d2.test1();
				d2.test2();

				//double b = someClass.add(5.0, 6.0);
				//int r = someClass.add(5, 6);
		}	

		// commented code below is example of static polymorphism via method overloading

		//public int add(int a, int b){}
		//public double add(double a, double b){}
		//public double add(double a, double b, double c){}
		//public someClass add(someClass a, someClass b){}

}