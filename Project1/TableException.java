/*
Student Name: David Kopp
Date: 9-8-14
Class: Comp282
Project 1: This class is the custom exception TableException that extends Exception for the table class. 
           It also houses the test run from tabletest. 
*/

public class TableException extends Exception
{

   public TableException(String message)
   {
      super(message);
   }
}

// Start of test program:
// Is the data structure empty? true
// Current size of the data structure? 0
// Testing TableException Error:
// TableException: Error: Trying to insert a Student ID that already exists.
// 
// Data entries after Inserts:
// 100001=Student ID: 100001, Name: David Kopp, Units Earned: 132, Major: Computer Science
// 100002=Student ID: 100002, Name: Samantha Carter, Units Earned: 255, Major: Astrophysics
// 100003=Student ID: 100003, Name: Hank Landry, Units Earned: 255, Major: History
// 100006=Student ID: 100006, Name: Jack O'niell, Units Earned: 155, Major: Kinesiology
// 100007=Student ID: 100007, Name: George S. Hammond, Units Earned: 134, Major: History
// 100008=Student ID: 100008, Name: Daniel Jackson, Units Earned: 255, Major: Archaeology
// 100009=Student ID: 100009, Name: Teal'c, Units Earned: 155, Major: Kinesiology
// 100010=Student ID: 100010, Name: Cameron Mitchell, Units Earned: 155, Major: Kinesiology
// 100011=Student ID: 100011, Name: Vala Mal Doran, Units Earned: 155, Major: Buisness
// 100012=Student ID: 100012, Name: Jonas Quinn, Units Earned: 255, Major: Mathematics
//    
// Test of operations on data structure:
// Current Size of data structure: 10
// Deleted id 100001? true
// Deleted id 999999? false
// Retrieving id 100008: Student ID: 100008, Name: Daniel Jackson, Units Earned: 255, Major: Archaeology
// Current Size of data structure: 9
//    
// Data entries after operations:
// 100002=Student ID: 100002, Name: Samantha Carter, Units Earned: 255, Major: Astrophysics
// 100003=Student ID: 100003, Name: Hank Landry, Units Earned: 255, Major: History
// 100006=Student ID: 100006, Name: Jack O'niell, Units Earned: 155, Major: Kinesiology
// 100007=Student ID: 100007, Name: George S. Hammond, Units Earned: 134, Major: History
// 100008=Student ID: 100008, Name: Daniel Jackson, Units Earned: 255, Major: Archaeology
// 100009=Student ID: 100009, Name: Teal'c, Units Earned: 155, Major: Kinesiology
// 100010=Student ID: 100010, Name: Cameron Mitchell, Units Earned: 155, Major: Kinesiology
// 100011=Student ID: 100011, Name: Vala Mal Doran, Units Earned: 155, Major: Buisness
// 100012=Student ID: 100012, Name: Jonas Quinn, Units Earned: 255, Major: Mathematics