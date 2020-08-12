package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashFunction {
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b1:b) {
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        }
        System.out.println(sb.toString());
        String hash = sb.toString();
        return hash;
    }

//    public static void main(String[] args) {
//        String password="password";
//        System.out.println(password);
//        try {
//            System.out.println(hashPassword(password));
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(HashFunction.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//    }
    
}
