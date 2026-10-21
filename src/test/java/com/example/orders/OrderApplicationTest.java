package com.example.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderApplicationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void listsRecentCustomerOrders() throws Exception {
        mvc.perform(get("/api/customers/42/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1002));
    }

    @Test
    void returnsProductDetailsAndPurchaseTotals() throws Exception {
        mvc.perform(get("/api/customers/42/orders/summaries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[1].items[0].productName").value("USB-C dock"))
                .andExpect(jsonPath("$[1].total").value(188.90));
    }

    @Test
    void returnsAnEmptyListForUnknownCustomers() throws Exception {
        mvc.perform(get("/api/customers/999/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void listsOrdersWithoutAContactEmail() throws Exception {
        mvc.perform(get("/api/customers/99/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1004));
    }
}
