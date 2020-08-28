package com.ljm;

import com.ljm.utils.SignUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeCounterGenerator;
import jdk.nashorn.internal.runtime.Source;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
        int count = 0;
        System.out.println(recursion(4, count));

    }

    public static int recursion(int n, int count) {
        if (n == 1) {
            for (int j=0; j<2; j++) {
                count++;
            }
            return count;
        }
        for (int i=0; i<2; i++) {
            count =+ recursion(n-1, count);
        }
        return count;
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
