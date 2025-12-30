
import java.util.*;

public class OTPCheck {

    //Method to generate a 6-digit otp using Math.random()
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    //Method to check whether all generated otps are unique
    public static boolean isUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //Main method
    public static void main(String[] args) {

        int[] otps = new int[10];

        //Generate otp numbers and store in array
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
            System.out.println("otp " + (i + 1) + " : " + otps[i]);
        }

        //Check whether all otps are unique
        boolean unique = isUnique(otps);
        System.out.println("all otps are unique: " + unique);
    }
}
