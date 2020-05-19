import java.io.*;


public class TestingProject4
{
    public static void main( String[] args) throws Exception
   {
      System.out.println("\nTest A");
      WordCount wcounter = new WordCount("gradedP4Testcase.txt");
      wcounter.start();
      System.out.println("\nTest Hash table order");
      wcounter.printHashTableOrder();
      System.out.println("\nTest Alpha order");
      wcounter.printAlphaOrder();
      System.out.println("\nTest Frequency order");
      wcounter.printFrequencyOrder();
      System.out.println("\nTest Top Ten");
      wcounter.printTopTen();
    
      System.out.println("\nTest B");
      WordCount wcounter2 = new WordCount("colors.txt");
      wcounter2.start();System.out.println("\nTest Top Ten");
      wcounter2.printTopTen();
         		
   }	

}

/* ------Sample Run ------------- 
  Note: Your hash table order may be a bit different
   ----jGRASP exec: java TestingProject4
 
 
 Test A
 
 Test Hash table order
 HashTable Order. Number of Unique Words:  14
 orange		Count: 8	Line List: 5,6,7,7,7,10,14,14
 purple		Count: 5	Line List: 1,1,6,6,7
 green		Count: 5	Line List: 5,5,11,16,18
 silver		Count: 2	Line List: 4,15
 white		Count: 1	Line List: 7
 lime		Count: 5	Line List: 7,11,13,16,16
 yellow		Count: 4	Line List: 3,8,8,13
 teale		Count: 3	Line List: 5,6,7
 red		Count: 7	Line List: 2,7,7,8,12,13,17
 blue		Count: 2	Line List: 7,7
 pink		Count: 1	Line List: 9
 gold		Count: 2	Line List: 7,9
 navy		Count: 1	Line List: 7
 lemon		Count: 4	Line List: 2,5,7,11
 
 Test Alpha order
 Alpha Sorted. Number of Unique Words:  14
 blue		Count: 2	Line List: 7,7
 gold		Count: 2	Line List: 7,9
 green		Count: 5	Line List: 5,5,11,16,18
 lemon		Count: 4	Line List: 2,5,7,11
 lime		Count: 5	Line List: 7,11,13,16,16
 navy		Count: 1	Line List: 7
 orange		Count: 8	Line List: 5,6,7,7,7,10,14,14
 pink		Count: 1	Line List: 9
 purple		Count: 5	Line List: 1,1,6,6,7
 red		Count: 7	Line List: 2,7,7,8,12,13,17
 silver		Count: 2	Line List: 4,15
 teale		Count: 3	Line List: 5,6,7
 white		Count: 1	Line List: 7
 yellow		Count: 4	Line List: 3,8,8,13
 
 
 Test Frequency order
 Frequency Sorted. Number of Unique Words:  14
 orange		Count: 8	Line List: 5,6,7,7,7,10,14,14
 red		Count: 7	Line List: 2,7,7,8,12,13,17
 green		Count: 5	Line List: 5,5,11,16,18
 lime		Count: 5	Line List: 7,11,13,16,16
 purple		Count: 5	Line List: 1,1,6,6,7
 lemon		Count: 4	Line List: 2,5,7,11
 yellow		Count: 4	Line List: 3,8,8,13
 teale		Count: 3	Line List: 5,6,7
 blue		Count: 2	Line List: 7,7
 gold		Count: 2	Line List: 7,9
 silver		Count: 2	Line List: 4,15
 navy		Count: 1	Line List: 7
 pink		Count: 1	Line List: 9
 white		Count: 1	Line List: 7
 
 
 Test Top Ten
 Ten Most Frequent Words 
 orange		Count: 8	Line List: 5,6,7,7,7,10,14,14
 red		Count: 7	Line List: 2,7,7,8,12,13,17
 green		Count: 5	Line List: 5,5,11,16,18
 lime		Count: 5	Line List: 7,11,13,16,16
 purple		Count: 5	Line List: 1,1,6,6,7
 lemon		Count: 4	Line List: 2,5,7,11
 yellow		Count: 4	Line List: 3,8,8,13
 teale		Count: 3	Line List: 5,6,7
 blue		Count: 2	Line List: 7,7
 gold		Count: 2	Line List: 7,9
 silver		Count: 2	Line List: 4,15
 
 Test B
 
 Test Top Ten
 Ten Most Frequent Words 
 red		Count: 3	Line List: 1,1,2
 blue		Count: 2	Line List: 1,3
 green		Count: 1	Line List: 3
 white		Count: 1	Line List: 2
 yellow		Count: 1	Line List: 4
 
  ----jGRASP: operation complete.
*/