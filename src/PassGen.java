import javax.swing.*;
import java.util.Random;

public class PassGen {

    public  int watchwordLength = 10;
    public String stringGen(JRadioButton letters, JRadioButton capitalLetters, JRadioButton spChars) {

        String charPool = "1234567890";
        if(letters.isSelected()) {
            charPool += "abcdefghijklmnopqrstuvwxyz";
        }
        if(capitalLetters.isSelected()) {
            charPool += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if(spChars.isSelected()) {
            charPool += "!@#$%^&*()_+=-<>?:";
        }

        return charPool;
    }

    public String passGen(String strPool) {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < watchwordLength; i++) {
            int index = random.nextInt(strPool.length());
            char randomChar = strPool.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        System.out.println(randomString);
        System.out.println(watchwordLength);
        return randomString;

    }

    public String increase() {
        if(watchwordLength < 30) watchwordLength++;
            return Integer.toString(watchwordLength);
    }

    public String decrease() {
        if(watchwordLength > 0) watchwordLength--;
            return Integer.toString(watchwordLength);
    }



}
