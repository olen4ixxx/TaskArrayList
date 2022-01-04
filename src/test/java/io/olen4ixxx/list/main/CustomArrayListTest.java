package io.olen4ixxx.list.main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    List<Integer> testList;

    @BeforeEach
    void setUp() {
        testList = new CustomArrayList<>();
        testList.add(0);
        testList.add(1);
    }

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void testAdd() {
        var expected = 2;
        testList.add(2);
        var actual = testList.get(2);
        assertEquals(expected, actual);
    }

    @Test
    void testRemove() {
        var expected = 1;
        testList.remove(0);
        var actual = testList.get(1);
        assertEquals(expected, actual);

    }

    @Test
    void testAddIndex() {
    }

    @Test
    void testRemoveIndex() {
    }
}