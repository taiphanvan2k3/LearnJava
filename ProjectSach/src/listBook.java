public class listBook {
	private book list[];
	private int id;
	public listBook() {
		this.list=new book[100];
		this.id=0;
	}
	public book[] getList() {
		return list;
	}
	public void insertBook(book a) {
		list[id++]=a;
	}
}
