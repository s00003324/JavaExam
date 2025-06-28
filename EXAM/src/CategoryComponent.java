import java.io.Serializable;

public abstract class CategoryComponent implements Serializable {
    public void add(CategoryComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(CategoryComponent component) {
        throw new UnsupportedOperationException();
    }

    public CategoryComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}