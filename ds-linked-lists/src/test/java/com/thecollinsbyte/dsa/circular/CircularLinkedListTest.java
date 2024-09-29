package com.thecollinsbyte.dsa.circular;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.thecollinsbyte.dsa.circular.CircularLinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class CircularLinkedListTest {

    CircularLinkedList<Integer> integerList;
    CircularLinkedList<String> stringList;

    @BeforeEach
    public void setUp() {
        integerList = new CircularLinkedList<>();
        stringList = new CircularLinkedList<>();
    }

    @Test
    public void testSize() {
        integerList.insertAtBeginning(10);
        integerList.insertAtBeginning(20);
        integerList.insertAtBeginning(30);

        assertEquals(3, integerList.size());
    }

    @Test
    public void testInsertionAtBeginning() {
        integerList.insertAtBeginning(10);
        integerList.insertAtBeginning(20);
        integerList.insertAtBeginning(30);

        List<Integer> result = integerList.traverse();

        assertEquals(List.of(30, 20, 10), result);
    }
}