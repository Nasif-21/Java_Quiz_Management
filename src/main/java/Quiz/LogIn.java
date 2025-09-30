package Quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogIn {
    public static void main(String[] args) throws IOException, ParseException {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your username :");
        String username=sc.nextLine();
        System.out.print("Enter your password :");
        String password=sc.nextLine();
        JSONObject userCredencials=loginJson(username,password);
        String role=(String) userCredencials.get("role");
        if(userCredencials.isEmpty())
        {
            System.out.println("Invalid username or password");

        } else if (role.equals("admin")) {
            System.out.println("Welcome "+username+"! Please create new questions in the question bank.");
            AdminPage admin=new AdminPage();


            
        } else if (role.equals("student")) {
            System.out.println("Welcome "+username+"to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
            StudentPage std=new StudentPage();
            
        }
        else
        {
            System.out.println("No user found");
        }


    }
    public static JSONObject loginJson(String user,String psw) throws IOException, ParseException {
        String userfilePath="./src/main/resources/user.json";
        //String quizfilePath="./src/main/resources/quiz.json";

        JSONParser parser=new JSONParser();
        JSONArray jsonArray=(JSONArray) parser.parse(new FileReader(userfilePath));

        for(Object obj: jsonArray)
        {
            JSONObject loginObject=(JSONObject) obj;
            String username=(String) loginObject.get("username");
            String password=(String) loginObject.get("password");

            if(username.equals(user) && password.equals(psw)){
                return loginObject;

            }

        }

       return new JSONObject();

    }
}
