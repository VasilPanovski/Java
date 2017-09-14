package pr4_Telephony;

/**
 * Created by mm on 11.7.2016 г..
 */
public class Smartphone implements Callable, Brawsable {
    private String numberToCall;
    private String siteToBrowse;

    public Smartphone(String numberToCall, String siteToBrowse) {
        this.setNumberToCall(numberToCall);
        this.setSiteToBrowse(siteToBrowse);
    }

    private void setNumberToCall(String numberToCall) {
        if (!numberToCall.matches("[0-9]+")) {
            throw new IllegalArgumentException("Invalid number!");
        }
        this.numberToCall = numberToCall;
    }

    private void setSiteToBrowse(String siteToBrowse) {
        if (siteToBrowse.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Invalid URL!");
        }
        this.siteToBrowse = siteToBrowse;
    }

    @Override
    public void browseSite() {
        System.out.println("Browsing: " + this.siteToBrowse + "!");;
    }

    @Override
    public void callPhoneNumber() {
        System.out.println("Calling... " + this.numberToCall);
    }
}
