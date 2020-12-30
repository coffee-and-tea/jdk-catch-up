package coffee_and_tea.jdk8.jep135_base64;

import java.util.Base64;
import java.util.UUID;

public class Base64EncodingDecoding {

    public static void main(String[] args) {

        // basic Base64 encoder & decoder
        playWithBasicBase64EncoderDecoder();

        // url encoder & decoder
        playWithUrlBase64EncoderDecoder();

        // mime encoder & mime decoder
        playWithMimeEncoderDecoder();
    }

    private static void playWithMimeEncoderDecoder() {
        UUID random = UUID.randomUUID();
        String base64UUID = new String(Base64.getMimeEncoder().encode(random.toString().getBytes()));
        String recoverUUID = new String(Base64.getMimeDecoder().decode(base64UUID.getBytes()));

        System.out.println("UUID: " + random);
        System.out.println("Base64 UUID: " + base64UUID);
        System.out.println("Decoded from base64 UUID: " + recoverUUID);
        System.out.println("UUID not change: " + random.toString().equals(recoverUUID));
    }

    private static void playWithUrlBase64EncoderDecoder() {
        String urlText = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
        String base64UrlText = new String(Base64.getUrlEncoder().encode(urlText.getBytes()));
        String recoveredUrlText = new String(Base64.getUrlDecoder().decode(base64UrlText));

        System.out.println("Text: " + urlText);
        System.out.println("Base64 text: " + base64UrlText);
        System.out.println("Decoded from base64 text: " + recoveredUrlText);
        System.out.println("Url not change: " + urlText.equals(recoveredUrlText));
    }

    private static void playWithBasicBase64EncoderDecoder() {
        String text = "random text with some special character: *<>/";
        String base64Text = new String(Base64.getEncoder().encode(text.getBytes()));
        String recoveredText = new String(Base64.getDecoder().decode(base64Text));

        System.out.println("Text: " + text);
        System.out.println("Base64 text: " + base64Text);
        System.out.println("Decoded from base64 text: " + recoveredText);
        System.out.println("Text not changed: " + text.equals(recoveredText));
    }

}
