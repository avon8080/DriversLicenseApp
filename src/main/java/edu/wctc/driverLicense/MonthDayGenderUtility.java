package edu.wctc.driverLicense;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MonthDayGenderUtility {
    private final 	int MOD_MALE = 0;
    private 	final 	int 	MOD_FEMALE = 500;
    private 	final 	char 	CODE_MALE =	'M';
    private 	final 	char 	CODE_FEMALE = 'F';

    public int encodeMonthDayGender(char gender, int month, int day, int year) throws UnknownGenderException, InvalidBirthdayException{
        String birthdayString = String.format("%d/%d/%d", day, month, year);
        if (gender != CODE_FEMALE && gender != CODE_MALE){
            throw new UnknownGenderException(gender);
        }
        LocalDate birthday = LocalDate.of(year, month, day);
        if (birthday == null) {
        throw new InvalidBirthdayException(birthdayString);
        }
        if (gender == CODE_MALE){
            return (month - 1) * 40 + day + MOD_MALE;
        } else if (gender == CODE_FEMALE) {
            return ((month - 1) * 40) + day + MOD_FEMALE;
        }
        return 000;
    }
}
