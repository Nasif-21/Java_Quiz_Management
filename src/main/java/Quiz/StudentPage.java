package Quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class StudentPage {
    public  StudentPage() throws IOException, ParseException {
        giveExam();
    }

    public static void giveExam() throws IOException, ParseException {
        String quizfile="./src/main/resources/quiz.json";
        JSONParser parser=new JSONParser();
        JSONArray jsonArray=(JSONArray) parser.parse(new FileReader(quizfile));

        Scanner sc=new Scanner(System.in);
        char startExam=sc.next().charAt(0);
        sc.nextLine();

        while(startExam=='s')
        {
            int marks=0;
            Random random=new Random();
            int questionNumber=Math.min(10, jsonArray.size());

            for(int i=0;i<10;i++)
            {
                int randomIndex=random.nextInt(jsonArray.size());
                JSONObject jsonObject=(JSONObject) jsonArray.get(randomIndex);
                String question=(String) jsonObject.get("question");
                String option1=(String)jsonObject.get("option 1");
                String option2=(String)jsonObject.get("option 2");
                String option3=(String)jsonObject.get("option 3");
                String option4=(String)jsonObject.get("option 4");
                long answerKey=(long) jsonObject.get("answerkey");


                System.out.println("[Question "+(i+1)+"] "+question);
                System.out.println("1. " + option1);
                System.out.println("2. " + option2);
                System.out.println("3. " + option3);
                System.out.println("4. " + option4);
                int studentAnswer=sc.nextInt();

                if(studentAnswer==answerKey)
                {
                    marks++;
                }

            }


            if(marks>=8)
            {
                System.out.println("Excellent! You have got "+ marks +" out of 10");
            } else if (marks>=5) {
                System.out.println("Good. You have got "+ marks +" out of 10");
                
            } else if (marks>=3) {
                System.out.println("Very poor! You have got "+ marks +" out of 10");
                
            }
            else
            {
                System.out.println("Very sorry you are failed. You have got "+ marks +" out of 10");
            }
            System.out.println("Would you like to start again? Press 's' for start or 'q' for quit");
            startExam=sc.next().charAt(0);

        }

    }
}
