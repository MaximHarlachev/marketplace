package ru.inno.market;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.market.core.Catalog;
import ru.inno.market.model.Client;
import ru.inno.market.model.Item;
import ru.inno.market.model.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    Order order;
    final int orderId = 1;
    final Client client = new Client(1, "Max");
    Catalog catalog = new Catalog();

    @BeforeEach
    public void setUp(){
        order = new Order(this.orderId, this.client);
    }

    @Test
    @DisplayName("Проверка id заказа")
    public void testGetId() {
        assertEquals(orderId, order.getId());
    }

    @Test
    @DisplayName("Проверка клиента заказа")
    public void testGetClient() {
        assertEquals(client, order.getClient());
    }

    @Test
    @DisplayName("Проверка, что корзина пуста")
    public void testEmptyCart() {
        assertEquals(0, order.getCart().size());
    }

    @Test
    @DisplayName("Проверка, что нет скидки, пока не добавили товар")
    public void testNotDiscount() {
        assertEquals(false, order.isDiscountApplied());
    }

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    public void testAddItem() {
        Item item = catalog.getItemById(5);
        order.addItem(item);
        assertEquals(1, order.getCart().size());
    }

}
