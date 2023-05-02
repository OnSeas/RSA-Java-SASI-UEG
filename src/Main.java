public class Main {
    public static void main(String[] args) throws Exception {
        String m;
        byte [] c;

        RSA rsa = new RSA();
        c = rsa.encript("Olá mundo", rsa.publicKey);
        System.out.println("\n\nMensagem Cifrada: " + c);
        m = rsa.decript(c);
        System.out.println("Mensagem decriptada: " + m);
    }
}
