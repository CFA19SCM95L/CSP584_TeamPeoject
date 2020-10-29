public class Book {
	private String id;
	private String name;
	private String time;
	private String note;

	public Book(String id, String name, String time, String note) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.note = note;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
