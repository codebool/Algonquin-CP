package Week07_File;

import java.io.*; // Import classes for IO and serialization operations

// Define a class named 'Person' which implements the 'Serializable' interface
// This allows 'Person' objects to be serialized (converted into a byte stream) and deserialized (reconstructed from a byte stream)
class Person implements Serializable {

    // Step 1: Declare a serial version UID, which is used for version control in a Serializable class.
    @Serial
    private static final long serialVersionUID = 1L;

    // Step 2: Define the properties of the 'Person' class.
    // 'name' and 'age' are fields of the 'Person' class.
    String name;
    int age;

    // Step 3: Create a constructor to initialize the 'Person' object.
    // This constructor takes 'name' and 'age' as parameters and assigns them to the class fields.
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Define a public class named 'SerializationExample'
public class SerializationExample {

    // The main method is the entry point of a Java application.
    public static void main(String[] args) {

        // Step 4: Create a 'Person' object to be serialized.
        Person person = new Person("John", 30);

        // Step 5: Serialize the 'Person' object using 'ObjectOutputStream'.
        // 'ObjectOutputStream' is used to write objects to an OutputStream.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            // The 'writeObject' method serializes the specified object and writes it to the OutputStream.
            out.writeObject(person);

            // Print a message to the console to indicate that the object has been serialized successfully.
            System.out.println("Person object serialized!");
        } catch (IOException e) { // This block catches any IOExceptions that may be thrown during the serialization process.

            // Print the stack trace to the console if an exception occurs.
            e.printStackTrace();
        }

        // Step 6: Deserialize the 'Person' object using 'ObjectInputStream'.
        // 'ObjectInputStream' is used to read objects from an InputStream.
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            // The 'readObject' method deserializes an object from the InputStream and returns it.
            // We need to typecast the object to 'Person' as it is returned as a generic 'Object'.
            Person deserializedPerson = (Person) in.readObject();

            // Print the deserialized object's properties to the console.
            System.out.println("Deserialized Person: " + deserializedPerson.name + ", Age: " + deserializedPerson.age);
        } catch (IOException | ClassNotFoundException e) { // This block catches IOExceptions and ClassNotFoundExceptions.

            // Print the stack trace to the console if an exception occurs.
            e.printStackTrace();
        }
    }
}