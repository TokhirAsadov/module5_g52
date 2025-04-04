package uz.javatuz;

import java.util.Arrays;
import java.util.Base64;

public class EncodingExample {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getMimeEncoder();
        Base64.Decoder decoder = Base64.getMimeDecoder();

        String str = "Agar encoding natijasida `/` yoki `+` ishtirok etishi kerak bo'lsa, Base64 encoding dan foydalanish eng yaxshi usul bo'ladi. Quyidagi Java kod Base64 orqali matnni kodlaydi:  \n" +
                "\n" +
                "```java\n" +
                "import java.util.Base64;\n" +
                "\n" +
                "public class EncodingHelper {\n" +
                "    public static void main(String[] args) {\n" +
                "        String originalString = \"yoki + ishtirok etadigan\"; // Original string\n" +
                "        String encodedString = encode(originalString); // Encoded string\n" +
                "        System.out.println(\"Encoded string: \" + encodedString);\n" +
                "    }\n" +
                "\n" +
                "    public static String encode(String input) {\n" +
                "        return Base64.getEncoder().encodeToString(input.getBytes());\n" +
                "    }\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "### **Natija (Misol):**\n" +
                "Agar kiritilgan matn **`\"yoki + ishtirok etadigan\"`** bo'lsa, kodlangan natija quyidagicha chiqadi:  \n" +
                "**`eW9raSArIGlzaHRpcm9rIGV0YWRpZ2Fu`**  \n" +
                "\n" +
                "Base64 kodlash jarayonida natijada `/` yoki `+` belgilar ham chiqishi mumkin. Agar bu belgilarning ko'proq chiqishini xohlasangiz, qo'shimcha o'zgarishlar kiritish mumkin. Shu kabi muammo bo'lsa, xabar bering! \uD83D\uDE0A";

        System.out.println(encoder.encodeToString(str.getBytes()));


    }

    private static void urlEncoder(){
        Base64.Encoder encoder = Base64.getUrlEncoder();
        Base64.Decoder decoder = Base64.getUrlDecoder();

        byte[] bytes = "\'a_?".getBytes();
        System.out.println(encoder.encodeToString(bytes));

        System.out.println(new String(decoder.decode(encoder.encodeToString(bytes))));
    }

    private static String decoded(String extracted) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(extracted));
    }

    private static String extracted() {
        Base64.Encoder encoder = Base64.getEncoder();
        String originalString = "Hello, World!";
        byte[] bytes = encoder.encode(originalString.getBytes());
        return encoder.encodeToString(originalString.getBytes());
    }
}
