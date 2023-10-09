package edu.wctc.driverLicense;
import org.apache.commons.codec.language.Soundex;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static final DriversLicense driversLicense = new DriversLicense();
    private static final WisconsinLicense wisconsinLicense = new WisconsinLicense(driversLicense);
    private static final FloridaLicense floridaLicense = new FloridaLicense(driversLicense);
    public static void main(String[] args) {
        firstMiddleName();
        lastName();
        genderBirthday();
        System.out.println(wisconsinLicense.formatDrivesLicense());
        System.out.println(floridaLicense.formatDrivesLicense());
    }

    private static void firstMiddleName(){

        FirstNameUtility firstNameUtility = new FirstNameUtility();
        try { System.out.println("Enter First name: ");
            String first = input.nextLine();
            if (first.isEmpty()){
                throw new  MissingNameException(first);
            }
            System.out.println("Enter Middle name: ");
            String middle = input.nextLine();
            if (middle.isEmpty()){
                throw new  MissingNameException(middle);
            }
            driversLicense.setFff(firstNameUtility.firstNameEncoder(first,middle));
        } catch (MissingNameException e) {
            System.out.println(e.getMessage() + " Please restart program");
            System.exit(0);
        }

    }
    private static void genderBirthday(){

        try {
            System.out.println("Enter your gender (M | F):  ");

            char gender = input.next().toUpperCase().charAt(0);
            System.out.println("Enter your birthday using numbers--\nDay: ");
            int day = input.nextInt();
            System.out.println("Month: ");
            int month = input.nextInt();
            System.out.println("Year: ");
            int year = input.nextInt();
            LocalDate birthday = LocalDate.of(year, month,day);

            if (birthday == null){
                throw new InvalidBirthdayException(birthday.toString());
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
            String yearFormatted = birthday.format(formatter);
            int yearsFormat = Integer.parseInt(yearFormatted);
            driversLicense.setYy(yearsFormat);
            MonthDayGenderUtility monthDayGenderUtility = new MonthDayGenderUtility();
            driversLicense.setDdd(  monthDayGenderUtility.encodeMonthDayGender(gender, month, day, year));
        } catch (UnknownGenderException | InvalidBirthdayException e) {
            System.out.println(e.getMessage() + " Please restart program");
            System.exit(0);
        }
    }

    private static void lastName(){
        try {
            System.out.println("Enter Last name: ");
            String last = input.nextLine();
            LastNameUtility lastNameUtility = new LastNameUtility();
            driversLicense.setSsss(lastNameUtility.encodedLastName(last));
        } catch (MissingNameException e) {
            System.out.println(e.getMessage() + " Please restart the program");
            System.exit(0);
        }
    }
}
