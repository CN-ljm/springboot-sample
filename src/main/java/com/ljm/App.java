package com.ljm;

import com.ljm.utils.FullSort;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

public class App {
    public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException, IOException, InvalidKeySpecException, SignatureException {

       /* String keyStr = SignUtil.getPrivateKeyFromFile("D:/key/icbc/private_pkcs8.pem");

        PrivateKey privateKey = SignUtil.loadPrivateKey(keyStr);

        String pubKeyStr = SignUtil.getPublicKeyFromFile("D:/key/icbc/public_pkcs8.pem");

        PublicKey publicKey = SignUtil.loadPublicKey(pubKeyStr);

        byte[] signBytes = SignUtil.readFileContext("D:/key/icbc/logo.sign");

        byte[] srcBytes = SignUtil.readFileContext("D:/key/icbc/logo.jpg");

        boolean verify = SignUtil.verify(srcBytes, signBytes, publicKey);

        System.out.println(verify);*/

//        System.out.println(publicKey);

        /*String str = "fbsakhgopahg.jpg";
        System.out.println(str.substring(0, str.lastIndexOf(".")));*/
//        int count = 0;
//        System.out.println(recursion(4, count));

        // 这里就是我改的，测试一下git合并问题

        int[] arr = new int[]{1, 2, 3, 4};
        FullSort.sort(arr, 0, arr.length);
    }

    public static int recursion22(int n, int count) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                count++;
            }
        }
        return count;
    }
}
