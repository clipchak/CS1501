

public class StringTable {

    LinkedHashEntry[] stringTable;
    String[] listOfEnteredStrings;
    int size;
    int numberOfEntries;
    double loadFactor = .75;


    public StringTable(){
        //starting at size 3 gives smallest amount of buckets
        size = 3;
        numberOfEntries = 0;
        stringTable = new LinkedHashEntry[size];
        listOfEnteredStrings = new String[size];
    }


//adds a string to the hash table
    public void insert(String s){
        LinkedHashEntry newEntry = new LinkedHashEntry(s);

        //hash function (borrowed from algorithms book)
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (31 * hash + s.charAt(i)) % size;
        }

        //if there is already a value at this hash (collision), add to the linked list located there (separate chaining)
        if(stringTable[hash] != null){
            if(stringTable[hash].getNext()==null){
                stringTable[hash].setNext(newEntry);
                listOfEnteredStrings[numberOfEntries] = s;
                numberOfEntries++;
            }
            else{
                LinkedHashEntry temp = stringTable[hash];
                while(temp.getNext()!=null){
                    temp = temp.getNext();
                }
                temp.setNext(newEntry);
                listOfEnteredStrings[numberOfEntries] = s;
                numberOfEntries++;
            }
        }
        else {
            //else it is the first item at hash to be located there
            //keep track of the strings that have been entered to make rehash easy
            //put the string into the hash table
            //increase number of entries
            listOfEnteredStrings[numberOfEntries] = s;
            stringTable[hash] = newEntry;
            numberOfEntries++;
        }

        //rehash table if load factor is met
        if(( (1.0 * numberOfEntries) / size) >= loadFactor){
            rehash();
        }

    }


    //checks if a given string is in the table
    public boolean contains(String s){
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (31 * hash + s.charAt(i)) % size;
        }


        //if the value at the string once hashed exists, traverse linked list
        if(stringTable[hash]!=null){
            if(stringTable[hash].getWord().equals(s)){
                return true;
            }
            else{
                LinkedHashEntry temp = stringTable[hash];
                while(temp.getNext()!=null){

                    temp = temp.getNext();
                    if(temp.getWord().equals(s)) return true;
                }
            }

        }
        return false;
    }


    //call if load factor is met, rehash
    public void rehash() {
        //size doubles
        numberOfEntries = 0;
        size = size * 2;
       // System.out.println(size);
        stringTable = new LinkedHashEntry[size];
        String[] newListOfEnteredStrings = new String[size];

        //loop that goes through previously entered strings and hashes them again
        for(int i = 0; i< listOfEnteredStrings.length; i++){
            if(listOfEnteredStrings[i] == null) break;
            insert(listOfEnteredStrings[i]);
        }

        //copies and resizes array of entered strings
        for(int i = 0; i<listOfEnteredStrings.length;i++) newListOfEnteredStrings[i] = listOfEnteredStrings[i];

        // set list of entered strings to the newly sized list
        listOfEnteredStrings = newListOfEnteredStrings;

    }

    //printing used for debugging
    public void printEnteredStrings(){
        for (int i = 0; i< listOfEnteredStrings.length;i++){
            System.out.println(listOfEnteredStrings[i]);
        }
    }

    public void printHashTable()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print("\nBucket "+ (i + 1) +" : ");
            LinkedHashEntry entry = stringTable[i];
            while (entry != null)
            {
                System.out.print(entry.getWord() +" ");
                entry = entry.getNext();
            }
        }
    }

}
