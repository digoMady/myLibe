package br.mylibe.model.negocio;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author mady
 */
public class Hash {
    
    public String md5(String str) {
         MessageDigest m = null;
         String md5hash = null;
         try {
             m = MessageDigest.getInstance("MD5");
         } catch (NoSuchAlgorithmException e) {
                  e.printStackTrace();
         }
            
         if(m != null) {
               m.update(str.getBytes(),0,str.length());
               BigInteger i = new BigInteger(1, m.digest());
               md5hash = String.format("%1$032x", i);
           }
        return md5hash;
    }
}
