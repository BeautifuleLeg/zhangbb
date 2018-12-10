package com.dnkx.util.certUtils;



import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.*;
import java.util.Enumeration;

/**
 * Created by zhangbb on 2018/8/14.
 */
public class CertKeyUtil {

    public static final String KEYSTORE_PKCS12 = "PKCS12";

    public static final String ROOT_ALIAS = "root";

    /**
     * 私钥
     */
    private static PrivateKey privateKey = null;

    /**
     * 公钥
     */
    private static PublicKey publicKey = null;
    public static void main(String[] args) {
        init("C:\\Users\\Administrator\\Desktop\\49490000\\49490000.pfx","111111","C:\\Users\\Administrator\\Desktop\\123.cer");
    }

    public static void init(String cert_path_pfx, String cert_pwd, String cert_path_cer) {
        try {
            System.out.println(cert_path_pfx + "," + cert_path_cer);
            KeyStore clientKeyStore = getKeyStore(
                    KEYSTORE_PKCS12,
                    new FileInputStream(cert_path_pfx),
                    cert_pwd.toCharArray());
            privateKey = (PrivateKey) getPrivateKey(clientKeyStore, cert_pwd);
            // 加载服务端公钥
            java.security.cert.Certificate serverCertificate = getCertificate(new FileInputStream(cert_path_cer));
            publicKey = serverCertificate.getPublicKey();
            System.out.println("public key = " + Base64.encodeBase64String(publicKey.getEncoded()));
            System.out.println("private key = " + Base64.encodeBase64String(privateKey.getEncoded()));
        } catch (Exception e) {
            throw new RuntimeException("初始化公私钥异常", e);
        }
    }

    /**
     * 获取keystore
     *
     * @param type
     * @param in
     * @param password
     * @return
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     * @throws NoSuchProviderException
     */
    public static KeyStore getKeyStore(String type, InputStream in, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException, NoSuchProviderException {
        try {
            KeyStore store = KeyStore.getInstance(type);
            store.load(in, password);
            return store;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }


    /**
     * 获取私钥
     *
     * @param store
     * @param password
     * @return
     * @throws UnrecoverableKeyException
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     */
    public static java.security.Key getPrivateKey(KeyStore store, String password)
            throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        Key key = store.getKey(ROOT_ALIAS, password.toCharArray());
        if (null == key) {
            Enumeration<String> keys = store.aliases();
            while (keys.hasMoreElements()) {
                String name = keys.nextElement();
                return store.getKey(name, password.toCharArray());
            }
        }
        return key;
    }


    /**
     * 获取证书
     *
     * @param
     * @return
     * @throws KeyStoreException
     */
    public static java.security.cert.Certificate getCertificate(InputStream in) throws KeyStoreException {
        try {
            CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
            java.security.cert.Certificate certificate = certificatefactory.generateCertificate(in);
            return certificate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }



}
