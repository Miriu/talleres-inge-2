package org.autotest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests3 extends MutationAnalysisRunner {
    @Override
    protected boolean useVerboseMode() {
        return false;
    }

    // Tests de StackTests2.java
    public void testSizeIncreasesByOne() throws Exception {
        Stack stack = createStack();
        assertEquals(0, stack.size());
        stack.push(42);
        assertEquals(1, stack.size());
    }

    public void testDefaultConstructor() throws Exception {
        Stack stack = createStack();
        assertTrue(stack.isEmpty());
    }

    public void testConstructorWithSpecifiedCapacity() throws Exception {
        Stack stack = createStack(5);
    }

    public void testConstructorWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            Stack stack = createStack(-1);
        });
    }

    public void testIsEmptyMethod() throws Exception {
        Stack stack = createStack();
        assertTrue(stack.isEmpty());
        stack.push(42);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    public void testIsFullMethod() throws Exception {
        Stack stack = createStack(1);
        assertFalse(stack.isFull());
        stack.push(42);
        assertTrue(stack.isFull());
        stack.pop();
        assertFalse(stack.isFull());
    }

    public void testToStringMethod() throws Exception {
        Stack stack = createStack(2);
        assertEquals("[]", stack.toString());
        stack.push(42);
        assertEquals("[42]", stack.toString());
        stack.push(43);
        assertEquals("[42,43]", stack.toString());
    }

    // COMPLETAR
    public void testCapacity() throws Exception {
        Stack stack = createStack(0);
        assertEquals("[]", stack.toString());
        assertTrue(stack.isEmpty());
        assertTrue(stack.isFull());
    }

    public void testVacioNoEsNull() throws Exception {
        Stack stack = createStack(3);
        assertFalse(stack.equals(null));
    }

    public void testCompararStacks() throws Exception {
        Stack stack1 = createStack(1);
        Stack stack2 = createStack(2);
        Stack stack3 = createStack(1);
        stack1.push(4);
        stack2.push(4);
        assertFalse(stack1.equals(stack2));
        stack2.push(5);
        assertFalse(stack1.equals(stack2));
        stack3.push(4);
        assertTrue(stack1.equals(stack3));
        assertTrue(stack1.equals(stack1));
        assertFalse(stack2.equals(1));
    }

    public void testCapacidadDefault() throws Exception {
        Stack stack = createStack();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);

        assertTrue(stack.isFull());
        assertThrows(IllegalStateException.class, () -> {
            stack.push(1);
        });
    }

    public void testPopYTopVacio() throws Exception {
        Stack stack = createStack();
        assertThrows(IllegalStateException.class, () -> {
            stack.pop();
        });
        assertThrows(IllegalStateException.class, () -> {
            stack.top();
        });
    }

    public void testTopYPop() throws Exception {
        Stack stack = createStack();
        stack.push(1);
        assertEquals(stack.top(), 1);
        assertEquals(stack.pop(), 1);
        assertTrue(stack.isEmpty());
    }

    public void testReadIndexDiferente() throws Exception {
        Stack stack1 = createStack(5);
        Stack stack2 = createStack(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.pop();

        assertFalse(stack2.equals(stack1));
    }

    public void testHashTest() throws Exception {
        Stack stack1 = createStack(5);
        Stack stack2 = createStack(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        assertEquals(stack1.hashCode(), stack2.hashCode());

        Object[] e = new Object[1];
        e[0] = 0;

        Object[] q = new Object[1];
        q[0] = 1;


        System.out.println(Arrays.hashCode(e));
        System.out.println(Arrays.hashCode(q));
        System.out.println(5/2);
        assertEquals(stack1.hashCode(), stack2.hashCode());
        stack2.push(4);
        stack2.pop();
        assertNotEquals(stack1.hashCode(), stack2.hashCode());
    }

    public void testHashTest2() throws Exception {
        Stack stack1 = createStack(1);
        Stack stack2 = createStack(1);
        stack1.push(0);
        stack2.push(1);
        stack2.pop();
        assertNotEquals(stack1.hashCode(), stack2.hashCode()); //este test es para el caso prime = 1

    }

    public void testHashTest3() throws Exception {
        Stack stack1 = createStack(1);
        Stack stack2 = createStack(1);
        stack1.push(1);
        stack2.push(0);
        stack2.pop();
        assertNotEquals(stack1.hashCode(), stack2.hashCode()); //este test es para el caso prime = 0

    }
}
