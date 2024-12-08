### Class Name:
**`DossierContact`**

---

### Purpose:
The `DossierContact` class provides functionality for managing contact information, including:
- Adding new contacts.
- Retrieving a specific contact by name.
- Deleting contacts.
- Updating contact phone numbers.

Contacts are stored in the `./contacts/` directory, with each contact's name as the file name and the phone number as the file content.

---

### Attributes:
1. **`contacts`** (`List<Map<String, String>>`):  
   A list to store contact details in memory. Each contact is represented as a map with two keys:
    - **`nom`**: Contact name.
    - **`numero`**: Contact number.

2. **`contactsPath`** (`String`):  
   The path to the directory where contact files are stored. Default is `./contacts/`.

---

### Constructor:
- **`DossierContact()`**:  
  Initializes the class and ensures the contacts directory exists.
    - If the directory exists and contains files, it loads the contact data into the `contacts` list by reading each file's name and content.
    - If the directory does not exist, it attempts to create it and prints the result.

---

### Methods:

#### 1. **`getContact(String name)`**
- **Parameters**:
    - `name` (`String`): The name of the contact to retrieve.
- **Return Type**: `Map<String, String>`
- **Description**:  
  Searches for and returns the contact details (name and number) for the given name. Returns `null` if the contact is not found.

---

#### 2. **`addContact(String name, String number)`**
- **Parameters**:
    - `name` (`String`): The contact's name.
    - `number` (`String`): The contact's phone number.
- **Throws**: `IOException`
- **Description**:
    - Adds a new contact by creating a file named after the contact and writing the phone number into the file.
    - Updates the in-memory `contacts` list.
    - Ensures duplicate phone numbers or file names are not allowed.

---

#### 3. **`deleteContact(String name)`**
- **Parameters**:
    - `name` (`String`): The name of the contact to delete.
- **Description**:
    - Deletes the contact's file from the `contacts` directory.
    - Removes the contact from the in-memory `contacts` list.
    - Prints an error message if the contact does not exist.

---

#### 4. **`updateContactNumber(String name, String newContactNumber)`**
- **Parameters**:
    - `name` (`String`): The name of the contact to update.
    - `newContactNumber` (`String`): The new phone number to associate with the contact.
- **Description**:
    - Deletes the old contact file and creates a new one with the updated number.
    - Updates the in-memory `contacts` list.

---

### Example Usage:

```java
public class Main {
    public static void main(String[] args) throws IOException {
        DossierContact dossier = new DossierContact();

        // Add contacts
        dossier.addContact("Alice", "123456789");
        dossier.addContact("Bob", "987654321");

        // Retrieve a contact
        System.out.println(dossier.getContact("Alice"));

        // Update a contact's number
        dossier.updateContactNumber("Alice", "111222333");

        // Delete a contact
        dossier.deleteContact("Bob");
    }
}
```

---

### Key Features:
1. **Persistent Storage**:  
   Contact data is saved in individual text files, ensuring persistence across program executions.

2. **In-Memory Management**:  
   Contact data is also loaded into memory for efficient operations.

3. **CRUD Operations**:  
   Supports adding, retrieving, updating, and deleting contacts.

4. **Directory Management**:  
   Automatically creates the contacts directory if it does not exist.

---

### Notes:
- The `contactsPath` can be made configurable to allow the use of different directories.
- Error handling could be enhanced for edge cases such as invalid input or file system errors.
- Consider using a JSON or database solution for scalability if managing many contacts.



### Class Name:
**`Main`**

---

### Purpose:
The `Main` class provides a user-friendly, menu-driven interface for managing contacts. It allows users to:
1. Find contacts.
2. Add new contacts.
3. Delete contacts.
4. Update contact phone numbers.
5. Exit the program.

---

### Workflow:

1. **Initialization**:
    - An instance of `DossierContact` is created to manage contacts.
    - A `Scanner` object is used to capture user input.

2. **Menu Loop**:
    - The program presents a menu of options to the user in a loop.
    - The user enters their choice, and the corresponding operation is performed.
    - The loop exits when the user selects option 5 (`EXIT`).

3. **Menu Options**:
    - **1. FIND CONTACT**:
        - Prompts the user to enter a contact's name.
        - Calls `getContact(name)` on the `DossierContact` instance and prints the result.
    - **2. ADD CONTACT**:
        - Prompts the user to enter a contact's name and number.
        - Calls `addContact(contactName, contactNumber)` to add the new contact.
        - Handles duplicates by relying on the `DossierContact` implementation to avoid overwriting.
    - **3. DELETE CONTACT**:
        - Prompts the user to enter a contact's name.
        - Calls `deleteContact(contactToDelete)` to remove the contact.
    - **4. UPDATE CONTACT**:
        - Prompts the user to enter the contact's name and new phone number.
        - Calls `updateContactNumber(contactToUpdate, newNumber)` to update the phone number.
    - **5. EXIT**:
        - Exits the loop and prints a farewell message.

4. **Error Handling**:
    - The program prints "Invalid choice" for invalid menu inputs.
    - Relies on `DossierContact` methods to handle specific errors, such as nonexistent contacts.

5. **Scanner Closure**:
    - The `Scanner` is closed after the loop to release system resources.

---

### Example Interaction:

```plaintext
1-FIND CONTACT
2-ADD CONTACT
3-DELETE CONTACT
4-UPDATE CONTACT
5-EXIT
Enter your choice: 2
Enter the name of the contact: Alice
Enter the number of the contact: 123456789

1-FIND CONTACT
2-ADD CONTACT
3-DELETE CONTACT
4-UPDATE CONTACT
5-EXIT
Enter your choice: 1
Enter the name of the contact: Alice
{nom=Alice, numero=123456789}

1-FIND CONTACT
2-ADD CONTACT
3-DELETE CONTACT
4-UPDATE CONTACT
5-EXIT
Enter your choice: 5
Goodbye!
```

---

### Features:
1. **Interactive Menu**:
    - Guides the user through various operations step-by-step.

2. **Dynamic Input**:
    - Accepts user input for contact details dynamically during execution.

3. **Efficient Contact Management**:
    - Leverages `DossierContact` to manage persistent contact storage seamlessly.

4. **Error Handling**:
    - Ensures invalid menu options do not crash the program.

---

### Suggested Enhancements:
1. **Input Validation**:
    - Validate user input to prevent invalid names or numbers (e.g., non-numeric phone numbers).
2. **Display All Contacts**:
    - Add an option to list all saved contacts for easier browsing.
3. **Improved Error Messages**:
    - Provide more descriptive error messages for operations like finding or deleting nonexistent contacts.
4. **Exit Confirmation**:
    - Prompt the user to confirm before exiting.

---

This CLI-based program is a simple and effective way to demonstrate the functionality of the `DossierContact` class, offering a hands-on approach to managing contacts.