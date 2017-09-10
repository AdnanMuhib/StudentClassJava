# StudentClassJava
## Assignment
Write a Java program in which you are required to define a class named **Student**. The
class must include the following three data members.
  * **Student Name** //data type should be String (name should be alphabetic, special
    characters and numbers are not allowed)

 * **Registration Number** //data type should be String (Format should be like this:
  2015-CS-888, any other format should be handled in setter function )
 * **Date of Birth** //data type should be Date (Date of birth should be less than 1st
    January 2005 and greater than 31st December 1990, add conditions for invalid
    data)
 * **CGPA** // data type should be double ( should be between 0 and 4)
 * **CNIC** //data type should be String (only numbers are allowed with valid CNIC)
1. Your Program should define two constructors for the class **Student**
  * a constructor with **no parameter**
  * a constructor with **two parameters** (Name, Registration Number)
All of these three constructors are meant to initialize their respective objects.
2. Define getter setter for each data member
3. Apart from getter, setter and constructor, define the following function
 * i. **getAge()** – it should calculate age of student upto current date.
 * ii. **getStatus()** – function should tell the status of student in the following
cases
    * a. IF CGPA less than 2.0 - Status is Suspended
    * b. IF CGPA between 2.0 and 2.5 - Status is Below Average
    * c. IF CGPA between 2.5 and 3.3 - Status is Average
    * d. IF CGPA between 3.3 and 3.5 - Status is Below Good
    * e. IF CGPA greater than 3.5 – Status is Excellent
* iii. **numberOfWordsInName()** – it should return number of words in
students name
* iv. **getGender()** – if last digit of CNIC is odd then it should return MALE
otherwise FEMALE
4. Declare two objects (1 for each type of constructor) in **main**.
5. Write a function in class **Student** to display the initialized data members for each
object.
6. Write **destructor** for the class **Student**. Display a message that says **“destructor
called”** in the destructor body

## Output
Your output should be like the following with same formatting <br />
<br />
Name: Sarfraz Ahmed (Contain 2 words) <br />
Registration Number: 2017-CS-999 <br />
CGPA: 2.9 Average <br />
Date of Birth: December 27, 1999 (Age is 17 years 8 months and 12 days) <br />
CNIC: 3567912356781 <br />
Gender: Male <br />

Name: Hafiz Muhammad Aslam (Contain 3 words) <br />
Registration Number: 2017-CS-999 <br />
CGPA: 3.4 Good <br />
Date of Birth: November 27, 1999 (Age is 18 years 9 months and 12 days) <br />
CNIC: 3567912356785 <br />
Gender: Male <br />
