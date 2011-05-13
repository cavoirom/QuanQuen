package quanquen.model;

public class Address{
	private String province;
	private String district;
	private String street;
	private String houseNumber;
	
	public Address() {
	}

	public Address(String province, String district, String street,
			String houseNumber) {
		super();
		this.province = province;
		this.district = district;
		this.street = street;
		this.houseNumber = houseNumber;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	public String toString(){
		return this.province +", " + this.district + ", " + this.houseNumber;
	}
}
