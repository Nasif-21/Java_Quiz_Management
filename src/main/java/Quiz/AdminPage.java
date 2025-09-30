package Quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class AdminPage {

    public  AdminPage() throws IOException, ParseException {
        writeQuestion();
    }
    public static void writeQuestion() throws IOException, ParseException {
        String quizfile="./src/main/resources/quiz.json";
        JSONParser parser=new JSONParser();
        JSONArray jsonArray=(JSONArray) parser.parse(new FileReader(quizfile));

        System.out.println("Press s to write question, press q to quit");
        Scanner sc=new Scanner(System.in);
        char startstop=sc.next().charAt(0);
        sc.nextLine();
        while(startstop=='s')
        {
            JSONObject jsonObject=new JSONObject();
            System.out.println("Input Question");
            String question=sc.nextLine();
            jsonObject.put("question",question);
            System.out.println("Input option 1 ");
            String option1=sc.nextLine();
            jsonObject.put("option 1",option1);
            System.out.println("Input option 2");
            String option2=sc.nextLine();
            jsonObject.put("option 2",option2);
            System.out.println("Input option 3");
            String option3=sc.nextLine();
            jsonObject.put("option 3",option3);
            System.out.println("Input option 4");
            String option4=sc.nextLine();
            jsonObject.put("option 4",option4);
            System.out.println("Whats the amswer key ?");
            int anskey=sc.nextInt();
            jsonObject.put("answerkey",anskey);

            jsonArray.add(jsonObject);
            System.out.println("Saved successfully");

            System.out.println("Do you want to add more questions? (press 's' to start, 'q' to quit)");
            startstop = sc.next().charAt(0);
            sc.nextLine();
        }
        FileWriter fw=new FileWriter(quizfile);
        fw.write(jsonArray.toJSONString());
        fw.flush();
        fw.close();

    }
}
