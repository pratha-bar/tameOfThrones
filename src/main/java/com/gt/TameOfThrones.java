package com.gt;

import com.gt.model.Universe;
import com.gt.util.StringUtil;
import java.util.Scanner;

/**
 * Created on 04/09/2019, 2:54 PM
 * TameOfThrones.java
 *
 * @author prathabarsaiyan
 */
public class TameOfThrones {

    static Universe universe = new Universe();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String str = scanner.nextLine();
            if("exit".equalsIgnoreCase(str)){
                break;
            }
            fetchAnswers(str);
        }

    }

    static void fetchAnswers(String question){
        if(StringUtil.isEmpty(question)){
            //System.out.println("EMPTY question");
            return;
        }
        question = question.toLowerCase().trim();
        if("who is the ruler of southeros?".equals(question)){
            System.out.println(universe.getRuler());
            return;
        }

        if("allies of ruler?".equals(question) || "allies of king shan".equals(question)){
            System.out.println(universe.getRulerAllies());
            return;
        }
        universe.decodeSecretMessage(question);
    }

}
