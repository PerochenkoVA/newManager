package manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTesting {

    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "Отци и дети", 500, "Тургенев И.С.");
    private Book book2 = new Book(2, "Мастер и Маргарита", 200, "Булгаков М.Ф.");
    private Book book3 = new Book(325, "Сто лет одиночества", 200, "Маркес Г.Г.");
    private Book book4 = new Book(445, "Атлант расправил плечи", 300, "Рэнд А.");
    private Book book5 = new Book(547, "Важные годы", 300, "Мэг Джэй");
    private Smartphone samsung = new Smartphone(1, "Galaxy", 1, "Samsung");
    private Smartphone iPhone = new Smartphone(2, "IPhone11", 1, "Apple");
    private Smartphone honor = new Smartphone(3, "HonorA10", 1, "Honor");


    @Test
    public void shouldSaveOneItem() {
        repository.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSeveralItem() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);

        Product[] expected = new Product[]{book1, book2, book3, book4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndSavelItem() {

        repository.save(samsung);
        repository.save(iPhone);
        repository.save(honor);
        repository.save(book1);

        Product[] expected = new Product[]{samsung, iPhone, honor, book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundExaption() {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(500);
        });
    }

    @Test
    public void shouldDeleteExistElement() throws NotFoundException {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);

        repository.removeById(1);

        Product[] expected = new Product[]{book2, book3, book4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
