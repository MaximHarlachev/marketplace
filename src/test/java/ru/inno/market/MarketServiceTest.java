package ru.inno.market;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.inno.market.core.MarketService;
import ru.inno.market.model.Client;
import ru.inno.market.model.Order;

import static org.junit.jupiter.api.Assertions.*;

public class MarketServiceTest {
    MarketService service;
    Client client = new Client(1, "Max");

    @BeforeEach
    public void setUp() {
        service = new MarketService();
    }

    @Test
    @Tag("Bug")
    @DisplayName("Проверка, что Не создаваётся заказ с пустым клиентом")
    public void testNotCreateOrderWithNullClient() {
        assertThrows(NullPointerException.class, () -> service.createOrderFor(null));
    }

    @Test
    @DisplayName("Проверка создания заказа для клиента")
    public void testCreateOrderForClient() {
        int orderId = service.createOrderFor(client);
        Order order = service.getOrderInfo(orderId);
        assertEquals(orderId, order.getId());
        assertEquals(client, order.getClient());
    }

    @Test
    @DisplayName("Проверка, что создаются разные заказы для одного клиента")
    public void testCreateDifferentOrdersForAClient() {
        int idOrder1 = service.createOrderFor(client);
        int idOrder2 = service.createOrderFor(client);
        assertNotEquals(idOrder1, idOrder2);
    }
}
