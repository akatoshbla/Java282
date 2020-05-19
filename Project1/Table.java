/*
Student Name: David Kopp
Date: 9-8-14
Class: Comp282
Project 1: This class is a Table which contains two fields: key and item. The container for the tables is a 
           Binary Search Tree, methods and constructor from JCF. Custom methods are isEmpty(), size(), tableInsert(),
           tableDelete(), tableRetrieve(), and printTable(). In addition, this class and subsequent classes is a 
           good example of generics in java. 
*/

import java.util.TreeMap;

public class Table<K extends Comparable<K>, T>
{

   private TreeMap<K,T> mytree = new TreeMap<K,T>();

   public Table() { }

   public boolean isEmpty() 
   {
      return mytree.isEmpty(); 
   }

   public int size() 
   {
      return mytree.size(); 
   }

   public void tableInsert(K key, T item) throws TableException 
   { 
      if (mytree.containsKey(key) == true) 
      {
         throw new TableException
            ("Error: Trying to insert a Student ID that already exists.");
      }
      
      else
      {
         mytree.put(key, item); 
      }
   }

   public boolean tableDelete(K key) 
   {
      if (mytree.containsKey(key) == true)
      {
         mytree.remove(key);
         return true;
      }
      
      else
      {
         return false;
      }
   }

   public T tableRetrieve(K key) 
   {  
      return mytree.get(key);
   }

   public void printTable() 
   { 
      TreeMap backuptree = new TreeMap();
      backuptree = (TreeMap) mytree.clone();
   
      while (!backuptree.isEmpty())
      {
         System.out.println(backuptree.pollFirstEntry());
      }
   }
}