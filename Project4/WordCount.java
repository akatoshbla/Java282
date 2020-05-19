/**
* Programmer: David Kopp
* Project #4: Hash Table -- Word Counter
* Date: 11/7/14
* Description: This program takes a input file or words and stores each as a key into a JCF HashMap the 
*              value is a WordInfo object that holds the word, occurence count, and line found on. It has
*              multiple ways to print the HashMap out: HashOrder, Alphabetic, Frequency, and Top Ten.
*              Only issues are 3 warnings do-to the use of collections with unsafe types.
*/

// Imported Classes
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

// WordInfo Starts here
class WordInfo
{
// Variables
   private String word;
   private int count;
   private String lines;

   public WordInfo(String w, int ct, int ln)
   {
      word = w;
      count = ct;
      lines = Integer.toString(ln);
   }

// Public getter Methods
   public String getWord()
   {
      return word;
   }

   public int getCount()
   {
      return count;
   }

   public String getLines()
   {
      return lines;
   }

   public String toString()
   {
      return String.format("%-20s",word) + "count: " +count +"    Line List: " +lines;
   }

// Need These to be Private setter Methods
   public void setCount(int ct)
   {
      count = ct;
   }

   public void setLines(String ln)
   {
      lines = ln;                                                                                                       
   }
}

// WordCount class Starts here
public class WordCount
{

// Variables
   File file;
   HashMap<String,WordInfo> hmap = new HashMap<String,WordInfo>();

// Public Methods
   public WordCount(String infileName)
   {
      file = new File(infileName);
   }

// Must be called before the printout of the HashTable
   public void start()
   {
   
      try 
      {
         Scanner input = new Scanner(file);
         int line = 1;
         while (input.hasNextLine() != false)
         {
            StringTokenizer t = new StringTokenizer(input.nextLine());
            while (t.hasMoreTokens())
            {
               String w = t.nextToken();
               if (hmap.containsKey(w) == false)
               {
                  hmap.put(w, new WordInfo(w,1,line));
               }
               else
               {
                  update(hmap.get(w),line);
               }
            }
            line++; 
         }
         input.close();
      }
      catch (FileNotFoundException e)
      {
         System.out.println(e);
         System.exit(1);
      }
   }

   public void printHashTableOrder()
   {
      if (hmap.size() == 0)
      {
         System.out.println("Error: The HashTable is empty! Can not print HashTableOrder!");
         System.exit(1);
      }
      else {
         System.out.println("HashTable Order Print");
         System.out.println("Number of Unique Words: " +hmap.size());
         Collection c = hmap.values();
         Iterator itr = c.iterator(); //Gives a warning
         while (itr.hasNext())
         {
            System.out.println(itr.next());
         }
      }
   }

   public void printAlphaOrder()
   {
      if (hmap.size() == 0)
      {
         System.out.println("Error: The HashTable is empty! Can not print AlphaOrder!");
         System.exit(1);
      }
      else {
         ArrayList<WordInfo> alist = new ArrayList<WordInfo>(); 
         System.out.println("\nAlphabetic Order Print");
         System.out.println("Number of Unique Words: " +hmap.size());
         Collection c = hmap.values();
         Iterator itr = c.iterator(); //Gives a warning
         alist.addAll(c);
         sortListAlph(alist);
         printList(alist, alist.size());
      }
   }

   public void printFrequencyOrder()
   {
      if (hmap.size() == 0)
      {
         System.out.println("Error: The HashTable is empty! Can not print FrequencyOrder!");
         System.exit(1);
      }
      else {
         ArrayList<WordInfo> alist = new ArrayList<WordInfo>(); 
         System.out.println("\nFrequency Order Print");
         System.out.println("Number of Unique Words: " +hmap.size());
         Collection c = hmap.values();
         Iterator itr = c.iterator(); //Gives a warning
         alist.addAll(c);
         sortListFreq(alist);
         printList(alist, alist.size());
      }
   }

   public void printTopTen()
   {
      if (hmap.size() == 0)
      {
         System.out.println("Error: The HashTable is empty! Can not print TopTen!");
         System.exit(1);
      }
      else {
         ArrayList<WordInfo> alist = new ArrayList<WordInfo>(); 
         System.out.println("\nTop Ten Print");
         System.out.println("Number of Unique Words: " +hmap.size());
         Collection c = hmap.values();
         alist.addAll(c);
         Iterator itr = c.iterator();
         sortListFreq(alist);
      
      //This if/else makes sure that the list prints 10 or less depending on the size of unique words
         if (alist.size() < 10)
         {
            printList(alist, alist.size());
         }
         else
         {
            printList(alist, 10);
         }
      }
   }

// Private Methods all sort methods use insert sort
// Update method updates the WordInfo object fields
   private void update(WordInfo w, int ln)
   {
      w.setCount(w.getCount() + 1);
      w.setLines(w.getLines() + "," +Integer.toString(ln)); 
   }

// This method puts the list in alphabetic order
   private ArrayList<WordInfo> sortListAlph(ArrayList<WordInfo> a)
   {
      for (int i = 1; i < a.size(); i++) 
      {
         WordInfo next = a.get(i);
         int j = i;
         while (j > 0 && a.get(j - 1).getWord().compareTo(next.getWord()) > 0) 
         {
            a.set(j, a.get(j - 1));
            j--;
         }
         a.set(j, next);
      }
      return a;
   }

// This method puts the list in frequency order
   private ArrayList<WordInfo> sortListFreq(ArrayList<WordInfo> a)
   {
      for (int i = 1; i < a.size(); i++) 
      {
         WordInfo next = a.get(i);
         int j = i;
         while (j > 0 && a.get(j - 1).getCount() < next.getCount()) 
         {
            a.set(j, a.get(j - 1));
            j--;
         }
         a.set(j, next);
      }
      tieBreakers(a);
      return a;
   }

// This method puts the tiebreakers in alphabetic order
   private ArrayList<WordInfo> tieBreakers(ArrayList<WordInfo> a)
   {
      for (int i = 1; i < a.size(); i++)
      {
         WordInfo next = a.get(i);
         int j = i;
         if (a.get(j - 1).getCount() == next.getCount())
         {
            while (j > 0 && a.get(j - 1).getCount() == next.getCount() && a.get(j - 1).getWord().compareTo(next.getWord()) > 0)
            {
               a.set(j, a.get(j - 1));
               j--;
            }
         }
         else { }
         a.set(j, next);
      }
      return a;
   }

// Universal print method
   private void printList(ArrayList<WordInfo> a, int size)
   {
      for (int i = 0;  i < size; i++)
      {
         System.out.println(a.get(i)); 
      }
   }
}