public class LinkedHashEntry {
    private String word;
    private LinkedHashEntry next;

    LinkedHashEntry(String word) {
        this.word = word;
        this.next = null;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public LinkedHashEntry getNext() {
        return next;
    }

    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }
}