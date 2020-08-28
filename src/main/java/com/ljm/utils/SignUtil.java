package com.ljm.utils;

import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author Created by liangjiaming on 2020/6/16
 * @title
 * @Desc
 */
public class SignUtil {

    /**
     * 私钥
     */
    private RSAPrivateKey privateKey;

    /**
     * 公钥
     */
    private RSAPublicKey publicKey;

    /**
     * 加载私钥
     * @param privateKeyStr
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws IOException
     */
    public static PrivateKey loadPrivateKey(String privateKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        //获取KeyFactory，指定RSA算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        //将BASE64编码的私钥字符串进行解码
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] encodeByte = decoder.decodeBuffer(privateKeyStr);

        //将BASE64解码后的字节数组，构造成PKCS8EncodedKeySpec对象，生成私钥对象
        PrivateKey privatekey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodeByte));

        return privatekey;
    }

    /**
     * 加载公钥
     * @param publicKeyStr
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws IOException
     */
    public static PublicKey loadPublicKey(String publicKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        //获取KeyFactory，指定RSA算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //将BASE64编码的公钥字符串进行解码
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] encodeByte = decoder.decodeBuffer(publicKeyStr);
        //将BASE64解码后的字节数组，构造成X509EncodedKeySpec对象，生成公钥对象
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodeByte));

        return publicKey;
    }


    /**
     * 从.pem文件中取得私钥
     * @param filePath 文件路径
     * @return 私钥
     */
    public static String getPrivateKeyFromFile(String filePath){
        String strPrivateKey = "";
        try {
            BufferedReader privateKey = new BufferedReader(new FileReader(filePath));
            String line = "";
            while((line = privateKey.readLine()) != null){
                strPrivateKey += line;
            }
            privateKey.close();
            strPrivateKey = strPrivateKey.replace("-----BEGIN PRIVATE KEY-----","").replace("-----END PRIVATE KEY-----","");
        }catch (Exception e){
            e.printStackTrace();
        }
        return strPrivateKey;
    }

    /**
     * 从.pem文件中取得公钥
     * @param filePath 文件路径
     * @return 公钥
     */
    public static String getPublicKeyFromFile(String filePath){
        String strPublicKey = "";
        try {
            BufferedReader publicKey = new BufferedReader(new FileReader(filePath));
            String line = "";
            while((line = publicKey.readLine()) != null){
                strPublicKey += line;
            }
            publicKey.close();
            strPublicKey = strPublicKey.replace("-----BEGIN PUBLIC KEY-----","").replace("-----END PUBLIC KEY-----","");
        }catch (Exception e){
            e.printStackTrace();
        }
        return strPublicKey;
    }

    /**
     * rsa签名
     * @param data  待签名的字符串
     * @param priKey  rsa私钥字符串
     * @return 签名结果
     * @throws Exception    签名失败则抛出异常
     */
    public static byte[] rsaSign(byte[] data, RSAPrivateKey priKey) throws SignatureException {
        try {
            Signature signature = Signature.getInstance("SHA512withRSA");
            signature.initSign(priKey);
            signature.update(data);

            byte[] signed = signature.sign();
            return signed;
        } catch (Exception e) {
            throw new SignatureException("RSAcontent = " + data
                    + "; charset = ", e);
        }
    }

    /**
     * rsa验签
     * @param data  被签名的内容
     * @param sign   签名后的结果
     * @param pubKey   rsa公钥
     * @return 验签结果
     * @throws SignatureException 验签失败，则抛异常
     */
    public static boolean verify(byte[] data, byte[] sign, PublicKey pubKey) throws SignatureException {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(pubKey);
            signature.update(data);
            return signature.verify(sign);

        } catch (Exception e) {
            e.printStackTrace();
            throw new SignatureException("RSA验证签名[content = " + data
                    + "; charset = " + "; signature = " + sign + "]发生异常!", e);
        }
    }

    /**
     * 文件读成byte
     * @param path
     * @return
     */
    public static byte[] readFileContext(String path) {
        File file = new File(path);
        FileChannel channel = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            channel = fis.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            channel.read(byteBuffer);
            return byteBuffer.array();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

}
