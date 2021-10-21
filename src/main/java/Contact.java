public class Contact {
    private int personID;
    private String lastName;
    private String firstName;
    private String adres;
    private String city;

    public Contact(int persoID, String lastName, String firstName, String adres, String city) {
        this.personID = persoID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.adres = adres;
        this.city = city;
    }

    public int getPersoID() {
        return personID;
    }

    public void setPersoID(int persoID) {
        this.personID = persoID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
