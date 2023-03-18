
package rfid_based_smartshoppingsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int DATA_EMAIL_IDX = 1;
    private static final int DATA_NAME_IDX = 0;
    private static final int DATA_ADD_IDX = 3;
    private static final int DATA_CITY_IDX = 4;
    private static final int DATA_GENDER_IDX = 2;
    private static final int DATA_DOB_IDX= 5;
    private static String filename="C:\\RFID_Based_SmartShoppingSystem\\data\\data.txt";
    
     String name,gender,dob,add,city,email; 
    public CSV(){}
    
    public CSV(String name,String email,String gender,String add,String city,String dob){
        this();
        this.name=name;
        this.city=city;
        this.gender=gender;
        this.dob=dob;
        this.add=add;
        this.email=email;
   
    }
    //CSV file header
   // private static final String FILE_HEADER = "name,email,gender,add,city,dob";
 
                 
    public CSV readCsvFile() {
        //System.out.println("IN READ()");
        BufferedReader fileReader = null;
        CSV data;
        String a="",b="",c="",d="",e="",f=""; 
        try {
             
            //Create a new list of student to be filled by CSV file data
           // List<Student> students = new ArrayList<Student>();
             
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(filename));
             
            //Read the CSV file header to skip it
            fileReader.readLine();
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    data = new CSV(tokens[DATA_NAME_IDX], tokens[DATA_EMAIL_IDX], tokens[DATA_GENDER_IDX], tokens[DATA_ADD_IDX], tokens[DATA_CITY_IDX], tokens[DATA_DOB_IDX]);
                    a=tokens[DATA_NAME_IDX];
                    b=tokens[DATA_EMAIL_IDX];
                    c=tokens[DATA_GENDER_IDX];
                    d=tokens[DATA_ADD_IDX];
                    e=tokens[DATA_CITY_IDX];
                    f=tokens[DATA_DOB_IDX];
                    return new CSV(a,b,c,d,e,f);
                }
            }
           
            //Print the new student list
            //for (Student student : students) {
            //System.out.println(data.toString());
            //}
        }
        catch (Exception e1) {
            System.out.println("Error in CsvFileReader !!!");
            e1.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e1) {
                System.out.println("Error while closing fileReader !!!");
                e1.printStackTrace();
            }
        }
        return new CSV(a,b,c,d,e,f);
    }

    /* @return the id
     */
    public String getname() {
        return name;
    }
    /**
     * @param id the id to set
     */
    public void setname(String name) {
        this.name = name;
    }
    public String getdob() {
        return dob;
    }
    /**
     * @param id the id to set
     */
    public void setdob(String dob) {
        this.dob = dob;
    }
    /**
     * @return the firstName
     */
    public String getcity() {
        return city;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setcity(String city) {
        this.city = city;
    }
    /**
     * @return the lastName
     */
    public String getadd() {
        return add;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setadd(String add) {
        this.add = add;
    }
    /**
     * @return the gender
     */
    public String getgender() {
        return gender;
    }
    /**
     * @param gender the gender to set
     */
    public void setgender(String gender) {
        this.gender = gender;
    }
    /**
     * @return the age
     */
    public String  getemail() {
        return email;
    }
    /**
     * @param age the age to set
     */
    public void setemail(String email) {
        this.email = email;
    }
     
    @Override
    public String toString() {
        return "Student [name=" + name + ", email=" + email + ", gender=" + gender
                + ", add=" + add + ", city=" + city + ", dob="
                + dob + "]";
    }
    
    public  void writeCsvFile() throws IOException {
         
        //Create new students objects
        //Create a new list of student objects
        //List<Student> students = new ArrayList<Student>();
        //students.add(student1);
         
        FileWriter fileWriter = null;
                 
        try {
            fileWriter = new FileWriter(filename);
            //Write Header to File
            fileWriter.append("name;email;gender;add;city;dob");
            fileWriter.append(NEW_LINE_SEPARATOR);
            
            
            //Write a new student object list to the CSV file
            //for (Data data : datas) {
                
                fileWriter.append(String.valueOf(this.getname()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(this.getemail()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(this.getgender()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(this.getadd()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(this.getcity()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(this.getdob()));
                fileWriter.append(NEW_LINE_SEPARATOR);
//            }
 
            //System.out.println("CSV file was created successfully !!!");
             
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
       } finally {

            fileWriter.flush();
            fileWriter.close();

        }

    }
    
    
    /*public static void main(String[] args) throws Exception{
        
        String s[]=new String[]{"Kevin patel","patelkvin04@gmail.com","MALE","H-503, Shangrila Luxury Appt.","Vadodara","04-09-1999"};
        CSV csv=new CSV(s[0],s[1],s[2],s[3],s[4],s[5]);
        csv.writeCsvFile();
        csv.readCsvFile();
        System.out.println(""+csv.toString());
    }*/

}


    
    
    

