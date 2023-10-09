package edu.wctc.driverLicense;

public class InvalidBirthdayException extends Exception{

public InvalidBirthdayException(String birthday){
    super(birthday + "is not valid");
}
}
