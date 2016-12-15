package Resurses;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Nikolay on 12/14/2016.
 */
public class Crypting {
    private static MessageDigest md;

    public static String cryptWithMD5(String pass){
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean equal(String pass1,String pass2){
        if(pass1.equals(pass2))
            return true;
        return false;
    }
}
