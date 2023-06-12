
public class MyMath {
	public int Min(int a,int b) {
		return (a>b)?b:a;
	}
	public int Min(int a,int b,int c ) {
		int min=a;
		if(b<min) min=b;
		if(c<min) min=c;
		return min;
	}
	
	public int Sum(int []a) {
		int s=0;
		for(int x:a)
			s+=x;
		return s;
	}
	public double Sum(double []a) {
		double s=0;
		for(double x:a)
			s+=x;
		return s;
	}
	public int Sum(int a,int b) {
		return a+b;
	}
}
