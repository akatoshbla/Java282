/*
Student Name: David Kopp
Date: 9-8-14
Class: Comp282
Project 1: This class is the object student which has the fields studentID, name, unitsEarned, and major. 
           There is also a toString() method override for the print out of the object. 
*/

public class Student 
{

   private int studentID;
   private String name;
   private int unitsEarned;
   private String major;


   public Student(int id, String student, int units, String maj) {
      studentID = id;
      name = student;
      unitsEarned = units;
      major = maj;
   }

   public String toString() {
   return "Student ID: " +studentID +", Name: " +name +", Units Earned: " +unitsEarned +", Major: " +major;
   }
}