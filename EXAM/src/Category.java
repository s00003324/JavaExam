import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category extends CategoryComponent implements Serializable {
    private String name;
    private List<CategoryComponent> components = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    @Override
    public void add(CategoryComponent component) {
        components.add(component);
    }

    @Override
    public void remove(CategoryComponent component) {
        components.remove(component);
    }

    @Override
    public CategoryComponent getChild(int i) {
        return components.get(i);
    }

    @Override
    public void print() {
        System.out.println("Category: " + name);
        for (CategoryComponent component : components) {
            component.print();
        }
    }
}