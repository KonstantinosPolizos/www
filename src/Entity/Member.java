package Entity;

import javax.persistence.*;

@Entity
@Table(name="member")

public class Member {
	@Id
	@Column(name="barcode")
	String barcode;
	
	@Column(name="name")
	String name;
	
	@Column(name="color")
	String color;
	
	@Column(name="description")
	String description;
	
	public Member() {
		super();
	}

	public Member(String barcode, String name, String color, String description) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.color = color;
		this.description = description;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}