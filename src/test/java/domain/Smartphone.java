package domain;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

public class Smartphone extends Product {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Smartphone();
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
        }
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Smartphone();
        product.toString();
    }
}
