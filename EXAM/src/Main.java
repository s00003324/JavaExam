public class Main {
    public static void main(String[] args) {
        try {
            NotificationCenter notifications = new NotificationCenter();
            notifications.registerObserver(message -> LoggerSingleton.getLogger().info("[Observer] " + message));

            Category root = new Category("Libri per bambini");
            PrintStrategy printStrategy = new SimplePrintStrategy();

            Category alimentazione = new Category("Alimentazione");
            Category allattamento = new Category("Allattamento");
            Category emozioni = new Category("Emozioni");
            Category fattoria = new Category("Fattoria");
            Category linguaggio = new Category("Linguaggio");

            alimentazione.add(new BookLeaf(BookFactory.createBook("Gnam! A me piace...", "Yusuke Yonezu", "La Coccinella", 2016, "Italiano")));
            allattamento.add(new BookLeaf(BookFactory.createBook("Mamma, latte! Adesso no, però…", "Giorgia Cozza", "Il Leone Verde", 2021, "Italiano")));
            emozioni.add(new BookLeaf(BookFactory.createBook("In famiglia", "Sandro Natalini", "Fatatrac", 2019, "Italiano")));
            fattoria.add(new BookLeaf(BookFactory.createBook("Fattoria", "Benedetta Nigelli", "Dami Editore", 2018, "Italiano")));
            linguaggio.add(new BookLeaf(BookFactory.createBook("Il mio primo dizionario visuale – In campagna", "Yoyo Books", "Yoyo Books", 2020, "Italiano")));

            root.add(alimentazione);
            root.add(allattamento);
            root.add(emozioni);
            root.add(fattoria);
            root.add(linguaggio);

            printStrategy.print(root);
            notifications.notifyObservers("Struttura stampata con successo");

            FileManager.saveBooks(java.util.List.of(root), "books.dat");
            FileManager.loadBooks("books.dat");

        } catch (Exception e) {
            LoggerSingleton.getLogger().severe("Errore critico: " + e.getMessage());
        }
    }
}