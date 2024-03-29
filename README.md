# AndroidFetch
Native Android app in Java

Files and Description:

1. Interface FetchHiringApi.java - This file defines how to fetch a list of Item objects from the hiring.json endpoint of a REST API.
   
3. Item.java - The Item class has setter methods (setId(int id), setListId(int listId), and setName(String name)) for each of these fields. These methods are used to set the values of the fields.
   
5. ItemAdapter.java - This is the ItemAdapter class for a RecyclerView in Android, which displays a list of Item objects, where each item's listId and name are shown in a TextView.
   
7. MainActivity.java - The MainActivity class in this Android application sets up a list view using a RecyclerView and makes a network request to fetch a list of Item objects. The fetched items are filtered, sorted, and displayed in the list view. Error handling is provided for unsuccessful network requests.
   
9. activity_main.xml - This XML layout file for an Android app's MainActivity contains a TextView at the top and a RecyclerView below it, which displays a list of data items.
    
11. item_view.xml - This XML layout defines a ConstraintLayout with three TextView elements stacked vertically. The first TextView (listIdTextView) is at the top, the second TextView (textView) displays "Hello World!" and is below the first, and the third TextView (nameTextView) is at the bottom, below the second TextView.



