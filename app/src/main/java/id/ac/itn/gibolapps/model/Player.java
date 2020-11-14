package id.ac.itn.gibolapps.model;

public class Player{
	private String firstName;
	private Object lastName;
	private String lastUpdated;
	private String nationality;
	private String countryOfBirth;
	private Object shirtNumber;
	private String name;
	private String dateOfBirth;
	private int id;
	private String position;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(Object lastName){
		this.lastName = lastName;
	}

	public Object getLastName(){
		return lastName;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
	}

	public void setCountryOfBirth(String countryOfBirth){
		this.countryOfBirth = countryOfBirth;
	}

	public String getCountryOfBirth(){
		return countryOfBirth;
	}

	public void setShirtNumber(Object shirtNumber){
		this.shirtNumber = shirtNumber;
	}

	public Object getShirtNumber(){
		return shirtNumber;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPosition(String position){
		this.position = position;
	}

	public String getPosition(){
		return position;
	}
}
