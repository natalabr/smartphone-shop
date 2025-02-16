package persistence;

import java.time.LocalDate;

public class Client {

    public String id;
    public String salutation;
    public String firstname;
    public String lastname;
    public String privatePhoneNumber;
    public String mobilePhoneNumber;
    public String emailAdress;
    public LocalDate dateOfBirth;
    public String username;
    public String password;
    public Adress adress;

    public String toString() {
        return id + ": " + salutation + " " + lastname + " " + firstname;
    }
}
