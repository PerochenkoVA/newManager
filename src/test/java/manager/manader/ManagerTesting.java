package manager.manader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTesting {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Отци и дети", 500, "Тургенев И.С.");
    private Book book2 = new Book(2, "Мастер и Маргарита", 200, "Булгаков М.Ф.");
    private Book book3 = new Book(325, "Сто лет одиночества", 200, "Маркес Г.Г.");
    private Book book4 = new Book(445, "Мастер и Маргарита", 300, "Булгаков М.Ф.");
    private Book book5 = new Book(547, "Важные годы", 300, "Мэг Джэй");
    private Smartphone samsung = new Smartphone(1, "Galaxy", 1, "Samsung");
    private Smartphone iPhone = new Smartphone(2, "IPhone11", 1, "Apple");
    private Smartphone honor = new Smartphone(3, "HonorA10", 1, "Honor");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(samsung);
        manager.add(iPhone);
        manager.add(honor);
    }

    @Test

    public void shouldSearcyBySmartphone() {

        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searcyBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearcyByAuthor() {

        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searcyBy("Тургенев И.С.");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearcyByManufactory() {

        Product[] expected = new Product[]{iPhone};
        Product[] actual = manager.searcyBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearcyByBookName() {

        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searcyBy("Сто лет одиночества");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearcyByNotExistBook() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searcyBy("Важные годы");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearcyByMoreBook() {

        Product[] expected = new Product[]{book2, book4};
        Product[] actual = manager.searcyBy("Мастер и Маргарита");
        assertArrayEquals(expected, actual);
    }
}
