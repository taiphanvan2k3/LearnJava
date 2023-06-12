
public class SapXepChon implements SapXepInterface{

	@Override
	public void sapXepTang(double[] a) {
		int n=a.length;
		for(int i=0;i<n-1;i++) {
			int vt=i;
			for(int j=i+1;j<n;j++)
				if(a[j]<a[vt])
					vt=j;
			double tam=a[i];
			a[i]=a[vt];
			a[vt]=tam;
		}
	}

	@Override
	public void sapXepGiam(double[] a) {
		int n=a.length;
		for(int i=0;i<n-1;i++) {
			int vt=i;
			for(int j=i+1;j<n;j++)
				if(a[j]>a[vt])
					vt=j;
			double tam=a[i];
			a[i]=a[vt];
			a[vt]=tam;
		}
	}

}
