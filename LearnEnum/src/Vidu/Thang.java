package Vidu;

public enum Thang {
	Jan(31),Feb(29),Mar(31),April(30),May(31),June(30),July(31),Agust(31),Sep(30),Oct(31),Nov(30),Dec(31);
	private int soNgay;
	Thang(int soNgay){
		this.soNgay=soNgay;
	}
	public int getSoNgay() {
		return this.soNgay;
	}
}
