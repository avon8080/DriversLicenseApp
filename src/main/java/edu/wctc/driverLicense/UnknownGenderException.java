package edu.wctc.driverLicense;

public class UnknownGenderException extends Exception{

    public UnknownGenderException(char gender){
        super(gender + "is not valid");
    }

}
