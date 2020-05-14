package club.bangju.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author 黑马程序员
 */
public class RsaUtils {

    private static final int DEFAULT_KEY_SIZE = 2048;
    private static final String RSA_KEY_SECRET = "法外狂徒张三";
    private static final String PUBLIC_KEY_FILE_PATH = "C:\\Users\\orangecat\\IdeaProjects\\BangJuBlog\\src\\main\\resources\\rsa\\publickey.rsa";
    private static final String PRIVATE_KEY_FILE_PATH = "C:\\Users\\orangecat\\IdeaProjects\\BangJuBlog\\src\\main\\resources\\rsa\\privatekey.rsa";
    /**
     * 从文件中读取公钥
     *
     * @return 公钥对象
     * @throws Exception
     */
    public static PublicKey getPublicKey() throws Exception {
        String filename = PUBLIC_KEY_FILE_PATH;
        byte[] bytes = readFile(filename);
        return getPublicKey(bytes);
    }

    /**
     * 从文件中读取密钥
     *
     * @return 私钥对象
     * @throws Exception
     */
    public static PrivateKey getPrivateKey() throws Exception {
        String filename = PRIVATE_KEY_FILE_PATH;
        byte[] bytes = readFile(filename);
        return getPrivateKey(bytes);
    }

    /**
     * 获取公钥
     *
     * @param bytes 公钥的字节形式
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    /**
     * 获取密钥
     *
     * @param bytes 私钥的字节形式
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }

    /**
     * 根据密文，生存rsa公钥和私钥,并写入指定文件
     *
     */
    public static void generateKey(int keySize) throws Exception {
        String publicKeyFilename = PUBLIC_KEY_FILE_PATH;
        String privateKeyFilename = PRIVATE_KEY_FILE_PATH;
        String secret = RSA_KEY_SECRET;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(Math.max(keySize, DEFAULT_KEY_SIZE), secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        // 获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        writeFile(publicKeyFilename, publicKeyBytes);
        // 获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFilename, privateKeyBytes);
    }

    private static byte[] readFile(String fileName) throws Exception {
        return Files.readAllBytes(new File(fileName).toPath());
    }

    private static void writeFile(String destPath, byte[] bytes) throws IOException {
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Files.write(dest.toPath(), bytes);
    }
}