package edu.wctc.driverLicense;

public class MissingNameException extends Exception {
    public MissingNameException (String name){
        super(name + "is not valid. Letters only--");
    }
}
