public class List implements ListInterface {
    private ListElement anchor;
    private ListElement current;

    @Override
    public boolean isEmpty() {
        return anchor == null;
    }

    @Override
    public boolean hasAccess() {
        return current != null;
    }

    @Override
    public void next() {
        if (!isEmpty() && hasAccess() && current.getNext() != null) {
            current = current.getNext();
        } else {
            current = null;
        }
    }

    @Override
    public void toFirst() {
        if (!isEmpty()) {
            current = anchor;
        }
    }

    @Override
    public void toLast() {
        if (!isEmpty()) {
            while (current.getNext() != null) {
                current = current.getNext();
            }
        }
    }

    @Override
    public Object getObject() {
        if (hasAccess()) {
            return current.getContent();
        } else {
            return null;
        }
    }

    @Override
    public void setObject(Object pObject) {
        if (hasAccess() && pObject != null) {
            current.setContent(pObject);
        }
    }

    @Override
    public void append(Object pObject) {
        if (pObject != null) {
            if (isEmpty()) {
                anchor = new ListElement(pObject, null);
            } else {
                ListElement temp = anchor;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(new ListElement(pObject, null));
            }
        }
    }

    @Override
    public void insert(Object pObject) {
        if (pObject != null) {
            if (this.isEmpty()) {
                anchor = new ListElement(pObject, null);
            } else if (this.hasAccess()) {
                ListElement temp = new ListElement(pObject, current);
                if (current == anchor) {
                    anchor = temp;
                } else {
                    ListElement prev = anchor;
                    while (prev.getNext() != current) {
                        prev = prev.getNext();
                    }
                    prev.setNext(temp);
                }
                current = temp;
            }
        }
    }


    @Override
    public void concat(List pList) {
        if (pList != null && !pList.isEmpty()) {
            if (isEmpty()) {
                anchor = pList.anchor;
            } else {
                ListElement temp = anchor;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(pList.anchor);
            }
        }
    }


    @Override
    public void remove() {
        if (this.hasAccess()) {
            if (current == anchor) {
                anchor = anchor.getNext();
            } else {
                ListElement temp = anchor;
                while (temp.getNext() != current) {
                    temp = temp.getNext();
                }
                temp.setNext(current.getNext());
            }
            if (current.getNext() != null) {
                current = current.getNext();
            } else {
                current = null;
            }
        }
    }
}
