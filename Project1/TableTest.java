/*
Student Name: David Kopp
Date: 9-8-14
Class: Comp282
Project 1: This is the main program that tests the table class's methods. There is also 
           a try and catch example and also the main only runs calls the tabletest class. 
*/

public class TableTest 
{ 

   public TableTest()
   {
   
      Table<Integer, Student> mytable = new Table<Integer, Student>();
      System.out.println("Start of test program:");
      System.out.println("Is the data structure empty? " +mytable.isEmpty());
      System.out.println("Current size of the data structure? " +mytable.size());
      
      // These inserts are safe and there are no exceptions expected.
      try
      {
         mytable.tableInsert(100001, new Student(100001, "David Kopp", 132, "Computer Science"));
         mytable.tableInsert(100003, new Student(100003, "Hank Landry", 255, "History"));
         mytable.tableInsert(100007, new Student(100007, "George S. Hammond", 134, "History"));
         mytable.tableInsert(100002, new Student(100002, "Samantha Carter", 255, "Astrophysics"));
         mytable.tableInsert(100006, new Student(100006, "Jack O'niell", 155, "Kinesiology"));
         mytable.tableInsert(100008, new Student(100008, "Daniel Jackson", 255, "Archaeology"));
         mytable.tableInsert(100009, new Student(100009, "Teal'c", 155, "Kinesiology"));
         mytable.tableInsert(100011, new Student(100011, "Vala Mal Doran", 155, "Buisness"));
         mytable.tableInsert(100010, new Student(100010, "Cameron Mitchell", 155, "Kinesiology"));
         mytable.tableInsert(100012, new Student(100012, "Jonas Quinn", 255, "Mathematics"));
      }
      
      catch (TableException e) 
      { 
         System.out.println(e);
      }
      
      // This try is made to purposely trigger a TableException.
      try 
      {
         System.out.println("Testing TableException Error:");
         mytable.tableInsert(100012, new Student(100012, "Jonas Quinn", 255, "Mathematics"));
      }
      
      catch (TableException e)
      {
         System.out.println(e);
      }
      
      System.out.println();
      System.out.println("Data entries after Inserts:");
      mytable.printTable();
      System.out.println();
      System.out.println("Test of operations on data structure:");
      System.out.println("Current Size of data structure: " +mytable.size());
      System.out.println("Deleted id 100001? " +mytable.tableDelete(100001));
      System.out.println("Deleted id 999999? " +mytable.tableDelete(999999));
      System.out.println("Retrieving id 100008: " +mytable.tableRetrieve(100008));
      System.out.println("Current Size of data structure: " +mytable.size());
      System.out.println();
      System.out.println("Data entries after operations:");
      mytable.printTable();
   }
   
   // Main program makes only one call to tabletest.
   public static void main(String[] arg) throws TableException
   {
      TableTest test = new TableTest();
   }
}