package edu.wctc.driverLicense;

import org.apache.commons.codec.language.Soundex;

public class LastNameUtility {
    private Soundex soundex = new Soundex();

    public String encodedLastName(String lastName) throws MissingNameException {

        if (lastName.isBlank()){
            throw new MissingNameException(lastName);
        }
        else {
            return soundex.encode(lastName);
        }
    }

}
