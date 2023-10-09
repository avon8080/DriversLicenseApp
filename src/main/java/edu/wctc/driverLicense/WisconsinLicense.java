package edu.wctc.driverLicense;

public class WisconsinLicense extends DriversLicenseState {
    private final DriversLicense driversLicense;
    public WisconsinLicense(DriversLicense userDriversLicense){
        driversLicense = userDriversLicense;
    }
    @Override
    public String formatDrivesLicense() {
        int yearString = driversLicense.getYy();

        String yearSplit = String.format(String.valueOf(yearString));
        String yearSplitFirst = "";
        String yearSplitSecond = "";
        if (yearString < 10){
            yearSplitFirst = "0";
            yearSplitSecond = yearSplit;

        }
        else {
            yearSplitFirst = String.valueOf(yearSplit.charAt(0));
            yearSplitSecond = String.valueOf(yearSplit.charAt(1));

        }
        String ddd = String.format(String.valueOf(driversLicense.getDdd()));
        if(driversLicense.getDdd() < 100){
            ddd = "0" + ddd;
        } else if (driversLicense.getDdd() < 10) {
            ddd = "00" + ddd;
        }
        return String.format("%s-%d%d-%d%s-%d",  driversLicense.getSsss(), driversLicense.getFff(),
                Integer.parseInt(yearSplitFirst), Integer.parseInt(yearSplitSecond), ddd,driversLicense.getNn());
    }
}
