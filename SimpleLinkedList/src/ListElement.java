public class ListElement {
    private Object content;
    private ListElement next;

    public ListElement(Object content, ListElement next) {
        this.content = content;
        this.next = next;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }
}