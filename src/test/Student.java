/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.regex.*;
/**
 *
 * @author Muhammad Adnan Mohib
 */
public class Student {
    // date Members
    private String studentName;
    private String registrationNumber;
    private Date dateOfBirth;
    private double CGPA;
    private String CNIC;
    
    // constructors
    
    // constructorr with no parameters
    Student()
    {
        this.studentName = "";
        this.registrationNumber = "";
        this.dateOfBirth = null;
        this.CGPA = 0.0;
        this.CNIC = "";
    }
    // constructor with two parameters
    Student(String name, String RegNo)
    {
        if(this.isValidName(name) && this.isValidRegNo(RegNo)){
            this.studentName = name;
            this.registrationNumber = RegNo;
        }
        
    }
    

    // setter getter functions for Data members 
    
    // setter for Name
    void setStudentName(String name){
        try{
            if(isValidName(name))
            {
                this.studentName = name;
            }
            else 
            {
                throw new Exception();
            }
        }
        catch(Exception e ){
            System.out.println("Invalid Name");
        }
    }
    // getter for name
    public String getName(){
        return this.studentName;
    }
    // setter for Registration Number
    public void setRegNumber(String RegNo)
    {
        try
        {
            if(this.isValidRegNo(RegNo))
            {
                this.registrationNumber = RegNo.toUpperCase();
            }
            else
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Registration Number");
        }
        
    }
    //getter for Registratio Number
    public String getRegNumber(){
        return this.registrationNumber;
    }
    // setter for CNIC
    public void setCNIC(String cnic){
        try
        {
            if(this.isValidCNIC(cnic))
            {
                this.CNIC = cnic.toUpperCase();
            }
            else
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid CNIC Number");
        }
    }
    // getter for CNIC
    public String getCNIC(){
        return this.CNIC;
    }
    //setter for Date of Birth
    public void setDOB(String dob){
       
        
            try{
                
                if(isValidDOB(dob) == false)
                {
                    throw new Exception();
                }
                else
                {
                    SimpleDateFormat dobformat = new SimpleDateFormat("MMMM/dd/yyyy");
                    this.dateOfBirth = dobformat.parse(dob);
                }
            }
            catch(Exception e){
                System.out.println("Invalid Date Format used.....");
            }
        
        
    }
    // getter for Date of Birth
    public Date getDOB(){
        return this.dateOfBirth;
    }
    //setter for CGPA
    public void setCGPA(double cgpa){
        try{
            if(isValidCGPA(cgpa)){
                this.CGPA = cgpa;
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("CGPA is not valid it must be between 0-4");
        }
    }
    // getter for CGPA
    public double getCGPA(){
        return CGPA;
    }
    // function to check valid Name
    private boolean isValidName(String name){
        if(name.length()>0){
        Pattern p = Pattern.compile("[^A-Za-z ]");
        Matcher m = p.matcher(name);
        boolean b = m.find();
        if (b == true)
            return false;
        else
         return true;
        }
        return false;
    }
    // function to check valid Reistration Number
    private boolean isValidRegNo(String RegNo){
        if(RegNo.length() >= 8){
            String year = "";// = ""+ RegNo.charAt(0) + RegNo.charAt(1) + RegNo.charAt(2) + RegNo.charAt(3);
            String dept = "";
            String regN = "";
            boolean dashDetect = false;

            for(int i =0; i< RegNo.length(); i++){
                if(RegNo.charAt(i) == '-')
                {
                    while(RegNo.charAt(i+1)!= '-' ){
                        dept += RegNo.charAt(i+1);
                        i++;
                    }
                    i += 2;
                    dashDetect = true;
                }
                if(dashDetect == false){
                    year += RegNo.charAt(i);
                }
                if(dashDetect == true){
                    regN += RegNo.charAt(i);
                }
            }
         if(Pattern.matches("\\d+", year) && 
            Pattern.matches("\\d+", regN) && 
            isValidName(dept) && 
            year.length()==4 && 
            dept.length() >1 && 
            regN.length()>0)
         {
                    return true;
         }
        }
        
        return false;
    }
    // function to check valid CNIC
    private boolean isValidCNIC(String cnic){
        // condition to check whether CNIC contains any alphabets and CNIC has length of 13
        
        if(Pattern.matches("[a-zA-Z]+", cnic) == false && cnic.length() == 13)
        {
                   return true;
        }
        else
        return false;
    }
    //function to check valid Date of Birth
    private boolean isValidDOB(String dob){
        
        if(dob.length()>0){
            // cheking if date is less than 1st jan 2005 and greater than 31st Dec, 1990
            String year = "";
            year += dob.charAt(dob.length()-4);
            year += dob.charAt(dob.length()-3);
            year += dob.charAt(dob.length()-2);
            year += dob.charAt(dob.length()-1);
            
            // conversion of string to integer
            int yearInt = Integer.parseInt(year);
            if(yearInt >1990 && yearInt < 2005)
                return true;
        }
        return false;
    }
    // function to check valid CGPA
    private boolean isValidCGPA(double cgpa){
        if(cgpa >= 0 && cgpa <= 4.0)
            return true;
        return false;
                  
    }
    // function to calculate age of the Student
    public Period getAge(){
        try{
        if(this.dateOfBirth != null){
            LocalDate localDate = this.dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year  = localDate.getYear();
            int month = localDate.getMonthValue();
            int day   = localDate.getDayOfMonth();
            // get the current date 
            LocalDate today = LocalDate.now();
            Period age = Period.between(localDate, today);
//            System.out.println(age.getDays());
//            System.out.println(age.getMonths());
//            System.out.println(age.getYears());
            return age;
        }
        else{
            throw new Exception();
        }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Set the Date of Birth First......");
        }
        return null;
    }
    // function to tell the status of Student
    public String getStatus(){
        //int cgpa = Integer.parseInt("" + CGPA);
        if(CGPA < 2.0){
            return "Suspended";
        }
        else if(CGPA < 2.5){
            return "Below Average";
        }
        else if(CGPA < 3.3){
            return "Average";
        }
        else if(CGPA < 3.5){
            return "Below Good";
        }
        else if(CGPA > 3.5){
            return "Good";
        }
        return "";
    }
    // function to count the number of words in the Name
    public int numberOfWordsInName(){
        if(this.studentName.length()>0){
            int size = this.studentName.split(" ").length;
//            System.out.println(size);
            return size;
        }
        return 0;
    }
   // function to check the gender on the bases of CNIC number
    public String getGender(){
        if(this.CNIC.length() > 0){
            // get the last number from the string of CNIC and parse that to integer
            int lastNumber = Integer.parseInt(""+CNIC.charAt(CNIC.length()-1));
            // check whether last number is even or Odd
            if((lastNumber % 2) != 0 ){
                return "Male";
            }
            else
                return "Female";
        }
        return "";
    }
    // final function to display the Values in Data members
    public void displayStudent(){
        if(studentName != "" && CNIC != "" && dateOfBirth != null && registrationNumber != ""){
            System.out.println("Name: " + this.getName() + " (Contain "+this.numberOfWordsInName() + " words)");
            System.out.println("Registration Number: " + this.getRegNumber());
            System.out.println("CGPA: " + this.getCGPA() + " " + this.getStatus());
            SimpleDateFormat formator = new SimpleDateFormat("MMMM dd, yyyy");
            Period age = this.getAge();
            System.out.println("Date of Birth: " + formator.format(getDOB()) + 
                    " (Age is " + age.getYears() + " years " + 
                    age.getMonths() + " months " + age.getDays() + " days)");
            System.out.println("CNIC: "+ this.getCNIC());
            System.out.println("Gender: "+this.getGender());
        }
        else{
            System.out.println("Incomplete information of Student Provided....");
        }
    } 
    // overriding garbage collector to bahve as destructor   
    @Override
    protected void finalize(){
        System.out.println("destructor called");
    };
    
}
