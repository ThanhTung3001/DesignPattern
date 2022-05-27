package com.example.springweb.utilscheck;

import org.springframework.stereotype.Component;

@Component
public class NumberCheck {

    public boolean isNumber(String sData){

        for (int i = 0; i < sData.length(); i++) {
            if (Character.isLetter(sData.charAt(i))) {
                return false;
            }
            if (i + 1 == sData.length()) {
               return true;
            }
        }
        return true;
    }
}
