/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


/**
 *
 * @author Muhammad Adnan Mohib
 */
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // decalring Objects of Student Class
        Student std = new Student();;
        Student HafizAslam = new Student("Hafiz Muhammad Aslam", "2017-CS-999");
        try{
        
        std.setStudentName("Sarfraz Ahmad");
        std.setRegNumber("2017-CS-999");
        std.setCGPA(2.9);
        std.setDOB("December/27/1999");
        std.setCNIC("3567912356781");
        std.displayStudent();
        
        System.out.println();
        
        HafizAslam.setCGPA(3.4);
        HafizAslam.setDOB("November/27/1999");
        HafizAslam.setCNIC("3567912356781");
        HafizAslam.displayStudent();

        // catching any errors 
        } catch (Throwable t) {
            throw t;
        }
        // calling destructor
        finally {
            std.finalize();
            HafizAslam.finalize();
        }
    }
    
}
