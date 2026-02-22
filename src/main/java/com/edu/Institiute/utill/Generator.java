package com.edu.Institiute.utill;
import org.springframework.stereotype.Service;

@Service
public class Generator {

    public static String generateFourNumbers(){
        String randomId = "";
        for (int i = 0; i < 4; i++) {
            int digit = (int) (Math.random() * 10);
            randomId += digit;
        }
        return randomId;
    }

    public static String generateOneNumeber(){
        String randomInstanceId = "";
        for (int i = 0; i < 1; i++) {
            int digit = (int) (Math.random() * 10);
            randomInstanceId += digit;
        }
        return randomInstanceId;
    }

    public static Long generateFourLongNumbers() {
        Long randomId = 0L;  // Initialize with 0 instead of null
        for (int i = 0; i < 4; i++) {
            int digit = (int) (Math.random() * 10);
            randomId = randomId * 10 + digit;  // Build the number properly
        }
        return randomId;
    }

}




