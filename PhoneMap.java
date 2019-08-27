import java.util.*;

/**
 * Creates a Map listing devices and which employees have been assigned each device.
 *
 * @author Pl4typusRex 
 * @version 1.0
 */
public class PhoneMap
{
   // instance variables - replace the example below with your own
   private Map<String,Set<String>> phones;

   /**
    * Constructor for objects of class PhoneMap
    */
   public PhoneMap()
   {
      // initialise instance variables
      phones = new TreeMap<>();
   }

   /**
    * populates the map with test data
    */
   public void populate()
   {
      Set<String> phone1Staff = new TreeSet<>();
      phone1Staff.add("John Smith");
      phone1Staff.add("Jane Smith");
      Set<String> phone2Staff = new TreeSet<>();
      phone2Staff.add("Adam Green");
      phone2Staff.add("Alex Green");
      Set<String> phone3Staff = new TreeSet<>();
      phone3Staff.add("Amy Green");
      phone3Staff.add("Karen Smith");
      Set<String> phone4Staff = new TreeSet<>();
      phone4Staff.add("Lucy Green");
      phone4Staff.add("Martin Smith");

      phones.put("iPhone 6", phone1Staff);
      phones.put("Google Pixel",phone2Staff);
      phones.put("Samsung Galxy S9",phone3Staff);
      phones.put("iPhone SE",phone4Staff);
   }

   /**
    * delees the given key and its associated value from the map
    * if the key exists returns true
    * otherwise returns false
    */
   public boolean deleteEntry(String phone)
   {
      boolean success = true;
      if (phones.remove(phone) == null)
      {
         success = false;
      }
      return success;
   }

   /**
    * adds the given name to the value of the given phone
    */
   public void addToValue(String phone, String name)
   {
      Set<String> currentNames = phones.get(phone);
      currentNames.add(name);
      phones.put(phone, currentNames);
   }

   /**
    * returns a collection of either Android or iOS phones
    */
   public Set<String> selectKeys(String osType)
   {
      Set<String> osPhones = new TreeSet<>();
      if (osType.equals("Android"))
      {
         for (String phone : phones.keySet())
         {
            if (!phone.contains("iPhone"))
            {
               osPhones.add(phone);
            }
         }
      }
      else if (osType.equals("iOS"))
      {
         for (String phone : phones.keySet())
         {
            if (phone.contains("iPhone"))
            {
               osPhones.add(phone);
            }
         }
      }
      else
      {
         System.out.println("Error: given OS not available, please choose ither Android or iOS");
      }
      return osPhones;
   }

   /**
    * prints the map keys and values
    */
   public void printMap()
   {
      for(String phone : phones.keySet())
      {
         System.out.println("Device: " + phone + " | Staff: " + phones.get(phone));
      }
   }

   /**
    * prints out the given key and it's value if it exists
    * otherwise prints an error message
    */
   public void printMapValue(String phone)
   {
      if (phones.get(phone) != null)
      {
         System.out.println("Device: " + phone + " | Staff: " + phones.get(phone));
      }
      else
      {
         System.out.println("Error: Phone not found");
      }
   }

   /**
    * adds a new entry to the phone map
    * overwrites the existing value if the key already exists
    */
   public void addMapEntry(String phone, Set<String> nameSet)
   {
      phones.put(phone, nameSet);
   }
}
