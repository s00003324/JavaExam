interface PrintStrategy {
    void print(CategoryComponent component);
}

class SimplePrintStrategy implements PrintStrategy {
    @Override
    public void print(CategoryComponent component) {
        component.print();
    }
}

class UpperCasePrintStrategy implements PrintStrategy {
    @Override
    public void print(CategoryComponent component) {
        System.out.println("[UPPERCASE VIEW]");
        component.print();
    }
}