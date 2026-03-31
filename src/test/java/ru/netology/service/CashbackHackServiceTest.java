package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CashbackHackServiceTest {
    private final CashbackHackService service = new CashbackHackService();

    @Test
    public void testRemain_AmountLessThanBoundary() {
        int amount = 500;
        int actual = service.remain(amount);
        int expected = 500; // 1000 - 500 % 1000 = 1000 - 500 = 500
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testRemain_AmountEqualToBoundary() {
        int amount = 1000;
        int actual = service.remain(amount);
        int expected = 0; // 1000 - 1000 % 1000 = 1000 - 0 = 1000, но на границе remain должен возвращать 0
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testRemain_AmountGreaterThanBoundary() {
        int amount = 1500;
        int actual = service.remain(amount);
        int expected = 500; // 1000 - 1500 % 1000 = 1000 - 500 = 500
        Assert.assertEquals(actual, expected);
    }
}
