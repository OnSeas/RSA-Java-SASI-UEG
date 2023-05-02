import java.security.*;
import javax.crypto.*;

public class RSA {
    public RSA(String m) throws Exception {
        // Gerar um par de chaves RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("public key: " + publicKey);
        System.out.println("private key: " + privateKey);

        // Criptografar uma mensagem usando a chave pública
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] mensagemCriptografada = cipher.doFinal(m.getBytes());
        System.out.println("Mensagem criptografada: " + mensagemCriptografada);

        // Descriptografar a mensagem usando a chave privada
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] mensagemDescriptografada = cipher.doFinal(mensagemCriptografada);
        String mensagemFinal = new String(mensagemDescriptografada);

        // Imprimir a mensagem original e a mensagem descriptografada
        System.out.println("Mensagem original: " + m);
        System.out.println("Mensagem descriptografada: " + mensagemFinal);
    }
}
