package pr3_CardsWithPower;

import pr3_CardsWithPower.enums.CardRank;
import pr3_CardsWithPower.anotations.CustomAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

/**
 * Created by mm on 20.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class cardRank = CardRank.class;
        Annotation[] annotations = cardRank.getAnnotations();

        String result = null;
        for (Annotation annotation : annotations) {
            if (annotation instanceof CustomAnnotation) {
                CustomAnnotation customAnnotation = (CustomAnnotation) annotation;
                result = String.format("Type = %s, Description = %s",
                        customAnnotation.type(),
                        customAnnotation.description());
            }
        }

        String input = reader.readLine();
        System.out.println(result);
    }
}
