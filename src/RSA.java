import javax.crypto.Cipher;
import java.security.*;

public class RSA {
    private PrivateKey privateKey;
    public PublicKey publicKey;

    public RSA() throws Exception {
        // Gerar um par de chaves RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); // Objeto usado para gerar chave, define algoritmo
        keyPairGenerator.initialize(2048); // Define tamanho da chave
        KeyPair keyPair = keyPairGenerator.generateKeyPair(); // Gera as chaves
        publicKey = keyPair.getPublic(); //pega as chave publica
        System.out.println("\npublic key: " + publicKey);
        privateKey = keyPair.getPrivate();//pega a chave privada
        System.out.println("\nprivate key: " + privateKey);
    }

    byte[] encript(String m, PublicKey publicKey) throws Exception {
        // Criptografar uma mensagem usando a chave pública
        // A cifragem é feita com RSA, Electronic Codebook (divide em blocos e usa a mesma chave em todos) e PKCS1Padding para preencher os blocos se não tiver o suficiente.
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // Definindo a maneira de criptografia
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); // Ativa o modo de encriptação
        byte[] mCifrada = cipher.doFinal(m.getBytes()); // Transforma a mensagem em bytes e encripta
        return mCifrada;
    }

    String decript(byte[] mCifrada) throws Exception {
        // Descriptografar a mensagem usando a chave privada
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // Definindo a maneira de criptografia
        cipher.init(Cipher.DECRYPT_MODE, privateKey); // Ativa o modo de decriptação
        byte[] mDecriptada = cipher.doFinal(mCifrada); // Recebe a mensagem cifrada e decripta
        String m = new String(mDecriptada);
        return m;
    }

}
