import Database.ObjectMapper;

import java.util.*;
import java.io.*;
//import com.fasterxml.jackson.databind.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;

 class JSONSerializationHelper{

    public static void serialiseToFile(Object object,String filePath)throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        FileOutputStream fos = new FileOutputStream(filePath);
        //objectMapper.writeValue(fos, object);
        fos.flush();
        fos.close();
    }


    public static <T> T deserializeFromFile(String filePath,Class<T> clazz)throws IOException, ClassCastException, ClassNotFoundException{
        //ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        // return (T) objectMapper.readValue(file, clazz);
        return null;
    }
}



class userV{


    public static final String regex = "^[a-zA-Z][a-zA-Z0-9_]{2,19}$*" ;
}
class validateSur{


    public static final String rege = "^[a-zA-Z][a-zA-Z0-9_]{2,19}$*" ;
}
class validateEmail{


    public static final String reg = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+?\n" +
            ")*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
}

public class UserDatabase extends JSONSerializationHelper {
    public void display_menu() {

        System.out.println ( "1. Add User\n2. Delete User\n3. Update a user\n4. List users\n0. to Exit");

    }



    private String name;
    private String surname;
    private String email;
    private String date;
    private String email2;
    private String email3;

    public UserDatabase() {

        Scanner in = new Scanner ( System.in );


        ArrayList<String> user = new ArrayList<String>();
        //user.add(new String());


        int option = 0;

        do{


            display_menu();

            option = in.nextInt();

            switch (option) {
                case 1:
                    Scanner inN = new Scanner ( System.in );
                    System.out.print("Enter your name: ");
                    name=inN.nextLine();
                    //user.add(name);


                    Scanner inS = new Scanner ( System.in );
                    System.out.print("Enter your surname: ");
                    surname = inS.nextLine();
                    //user.add(surname);

                    if(name.matches(userV.regex)) {

                    } else {
                        System.out.println("invalid name");
                    }
                    if (surname.matches(validateSur.rege)){
                        System.out.println("");
                    } else {
                        System.out.println("invalid surname");
                    }

                    Scanner inE = new Scanner ( System.in );
                    System.out.print("Enter your email: ");
                    email = inE.nextLine();
                    //user.add(email);
                    if (email.matches(validateEmail.reg)){
                        System.out.println("");
                    } else {
                        System.out.println("invalid email address");
                    }

                    Scanner inD = new Scanner ( System.in );

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdf.setLenient(false);
                    System.out.println("Please enter your date of birth: (yyyy-MM-dd)");
                    date = inD.nextLine();
                    //user.add(date);

                    try{
                        Date d1 = sdf.parse(date);
                        System.out.println(" ");
                    } catch (Exception e) {
                        System.out.println("Invalid date of birth");

                    }

                    String userInformation = "Name: " + name +"   "+ "Surname: " + surname + "   "+ "Email: " + email +"   " + "Date of birth: " + date;

                    user.add(userInformation);


                    System.out.println("Hello" +" " + name+ " "+surname +", your details have been saved to the database");


                    break;

                case 2:
                    Scanner iEmail = new Scanner ( System.in );
                    System.out.print("Enter your email: ");
                    email3 = iEmail.nextLine();
                    //user.add(email);
                    if (email3.matches(validateEmail.reg)){
                        System.out.println("");
                    } else {
                        System.out.println("invalid email address");
                    }


                    for(int i = 0; i < user.size();i++){
                        if(email.equals(email3)){
                            user.remove(i);
                        }else {
                            System.out.println ("error"  );
                        }
                    }
                    break;
                case 3:
                    Scanner inEmail = new Scanner ( System.in );
                    System.out.print("Enter your email: ");
                    email2 = inEmail.nextLine();
                    //user.add(email);
                    if (email2.matches(validateEmail.reg)){
                        System.out.println("");
                    } else {
                        System.out.println("invalid email address");
                    }

                    for(int i = 0; i < user.size();i++){
                        if(email.equals(email2)){

                            Scanner inName = new Scanner ( System.in );
                            System.out.print("Enter your name: ");
                            name=inName.nextLine();

                            Scanner inSu = new Scanner ( System.in );
                            System.out.print("Enter your surname: ");
                            surname = inSu.nextLine();

                            Scanner inDa = new Scanner ( System.in );

                            SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
                            sdff.setLenient(false);
                            System.out.println("Please enter your date of birth: (yyyy-MM-dd)");
                            date = inDa.nextLine();
                            //user.add(date);

                            try{
                                Date d1 = sdff.parse(date);
                                System.out.println(" ");
                            } catch (Exception e) {
                                System.out.println("Invalid date of birth");

                            }

                        }else {
                            System.out.println ("error"  );
                        }

                    }
                    String userInformation2 = "Name: " + name +"   "+ "Surname: " + surname + "  "+ " Email: " + email + "  "+ "Date of birth: "+ date;
                    //serialiseToFile(new Users("Name: " + name +"   "+ "Surname: " + surname + "  "+ " Email: " + email + "  "+ "Date of birth: "+ date),filePath:"abc.ser");
                    user.add(userInformation2);
                    break;
                case 4:
                    for(int i = 0; i < user.size();i++){
                        System.out.println(user.get(i));
                    }
                    break;
                default:
                    System.err.println (  );
                    break;

            }


        }while(option != 0);


    }


    public static int getAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        return Period.between(dob, curDate).getYears();
    }

    public static void main ( String[] args ) {
        new UserDatabase();

    }



}