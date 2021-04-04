package fil_rouge;

public class Activity {

	protected String description;
	protected int durée;

	//constructeur de Activity
	// activity est définie par une description et une durée 
	public Activity(String description, int durée) {
		super();
		this.description = description;
		this.durée = durée;
	}

//Methode toString
	@Override
	public String toString() {
		return "--Activity-- :\n"+ description + ", durée=" + durée+"\n"  ;
	}

//methose hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + durée;
		return result;
	}

//methode equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (durée != other.durée)
			return false;
		return true;
	}















}
