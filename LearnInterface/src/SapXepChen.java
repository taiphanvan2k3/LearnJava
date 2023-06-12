
public class SapXepChen implements SapXepInterface{

	@Override
	public void sapXepTang(double[] a) {
		int n=a.length;
		for(int i=1;i<n;i++) {
			int j=i-1;
			double val=a[i];
			while(j>=0 && a[j]>=val) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=val;
		}
	}

	@Override
	public void sapXepGiam(double[] a) {
		int n=a.length;
		for(int i=1;i<n;i++) {
			int j=i-1;
			double val=a[i];
			while(j>=0 && a[j]<=val) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=val;
		}
	}

}
