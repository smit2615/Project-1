import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MyLinkedListTest {

    @Test
    public void Next_Retrieves_The_Node_After_The_Calling_Node() {
        //setup
        MyLinkedList<Integer> head = new MyLinkedList<>(Arrays.asList(1, 2));
        MyLinkedList<Integer> expected = new MyLinkedList<>(2);

        //execute
        ILinkedList<Integer> actual = head.next();

        //assert
        Assert.assertTrue(expected.areEqual((MyLinkedList) actual));
    }

    public void Next_Returns_Null_On_Empty_List() {
        //setup
        MyLinkedList<Integer> head = new MyLinkedList<>();

        //execute
        MyLinkedList<Integer> actual = (MyLinkedList) head.next();

        //assert
        Assert.assertNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void Next_Throws_Exception_On_Null_Node() {
        //setup
        MyLinkedList<Integer> actual = null;

        //execute
        actual.next();
    }


    @Test
    public void Last_Retrieves_The_Last_Element_In_The_List() {
        //setup
        MyLinkedList<Integer> head = new MyLinkedList<>(Arrays.asList(1, 2, 3, 4));
        MyLinkedList<Integer> expected = new MyLinkedList<>(4);

        //execute
        ILinkedList<Integer> actual = head.last();

        //assert
        Assert.assertTrue(expected.areEqual((MyLinkedList) actual));
    }

    @Test(expected = NullPointerException.class)
    public void Last_Throws_Exception_On_Null_Node() {
        //setup
        MyLinkedList<Integer> head = null;

        //execute
        ILinkedList<Integer> actual = head.last();
    }

    @Test
    public void After_Retrieves_Nth_Element_In_List() {
        //setup
        MyLinkedList<Integer> head = new MyLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        int nPosition = 2;
        MyLinkedList<Integer> expected = new MyLinkedList<>(Arrays.asList(3, 4, 5));

        //execute
        ILinkedList<Integer> actual = head.after(nPosition);

        //assert
        Assert.assertTrue(expected.areEqual((MyLinkedList) actual));
    }

    @Test(expected = NullPointerException.class)
    public void After_Throws_Exception_When_N_Is_Out_Of_Bounds() {
        //setup
        MyLinkedList<Integer> head = new MyLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        int nPosition = 500;

        //execute
        ILinkedList<Integer> actual = head.after(nPosition);
    }

    @Test
    public void After_Incorrectly_Retrieves_First_Element_When_N_Is_Negative() {
        //setup
        MyLinkedList<Integer> head = new MyLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        MyLinkedList<Integer> expected = new MyLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        int nPosition = -1;

        //execute
        ILinkedList<Integer> actual = head.after(nPosition);

        //assert
        Assert.assertTrue(expected.areEqual((MyLinkedList) actual));
    }

    @Test
    public void Detach_Retrieves_Previously_Next_Element() {
        //setup
        MyLinkedList<Character> head = new MyLinkedList<>(Arrays.asList('a', 'b', 'c'));
        MyLinkedList<Character> expected = new MyLinkedList<>(Arrays.asList('b', 'c'));

        //execute
        ILinkedList<Integer> actual = head.detach();

        //assert
        Assert.assertTrue(expected.areEqual((MyLinkedList) actual));
    }

    @Test
    public void Detach_Retrurns_Null_On_Empty_List() {
        //setup
        MyLinkedList<Character> head = new MyLinkedList<>();

        //execute
        ILinkedList<Integer> actual = head.detach();

        //assert
        Assert.assertNull(actual);
    }

    @Test
    public void Detach_Sets_Previously_Next_Element_To_Null() {
        //setup
        MyLinkedList<Character> head = new MyLinkedList<>(Arrays.asList('a', 'b', 'c'));

        //execute
        head.detach();

        //assert
        Assert.assertNull(head.next());
    }

    @Test
    public void Get_Retrieves_Current_Node_Data() {
        //setup
        MyLinkedList<Character> head = new MyLinkedList<>(Arrays.asList('a', 'b', 'c'));
        char expected = 'a';

        //execute
        char actual = head.get();

        //assert
        Assert.assertTrue(expected == actual);
    }

    @Test
    public void Get_Returns_Null_On_Empty_List() {
        //setup
        MyLinkedList<Integer> head = new MyLinkedList<>();

        //execute
        Integer actual = head.get();

        //assert
        Assert.assertNull(actual);
    }

    @Test
    public void Set_Sets_Current_Node_Data() {
        //setup
        MyLinkedList<Integer> expected = new MyLinkedList<>(15);
        MyLinkedList<Integer> actual = new MyLinkedList<>();

        //execute
        actual.set(15);

        //assert
        Assert.assertTrue(expected.areEqual(actual));
    }

    @Test(expected = NullPointerException.class)
    public void Set_Throws_Exception_On_Null_Node() {
        //setup
        MyLinkedList<Integer> actual = null;

        //execute
        actual.set(1);
    }

    @Test
    public void SetNext_Adds_A_Link_To_The_List() {
        //setup
        MyLinkedList<Character> expected = new MyLinkedList<>(Arrays.asList('a', 'b'));
        MyLinkedList<Character> actual = new MyLinkedList<>('a');
        MyLinkedList<Character> link = new MyLinkedList<>('b');

        //execute
        actual.setNext(link);

        //assert
        Assert.assertTrue(expected.areEqual(actual));
    }

    @Test(expected = NullPointerException.class)
    public void SetNext_Throws_Exception_On_Null_Node() {
        //setup
        MyLinkedList<Integer> actual = null;

        //execute
        actual.setNext(new MyLinkedList<>());
    }

    @Test
    public void Append_Adds_To_The_End_Of_The_List() {
        //setup
        MyLinkedList<Character> expected = new MyLinkedList<>(Arrays.asList('a', 'b', 'c'));
        MyLinkedList<Character> actual = new MyLinkedList<>(Arrays.asList('a', 'b'));
        MyLinkedList<Character> link = new MyLinkedList<>('c');

        //execute
        actual.append(link);

        //assert
        Assert.assertTrue(expected.areEqual(actual));
    }

    @Test(expected = NullPointerException.class)
    public void Append_Throws_Exception_On_Null_Node() {
        //setup
        MyLinkedList<Integer> actual = null;

        //execute
        actual.append(new MyLinkedList<>());
    }

    @Test
    public void Insert_Adds_To_The_Beginning_Of_The_List() {
        //setup
        MyLinkedList<Character> expected = new MyLinkedList<>(Arrays.asList('a', 'b', 'c'));
        MyLinkedList<Character> link = new MyLinkedList<>(Arrays.asList('b', 'c'));
        MyLinkedList<Character> actual = new MyLinkedList<>('a');

        //execute
        link.insert(actual);

        //assert
        Assert.assertTrue(expected.areEqual(actual));
    }

    @Test(expected = NullPointerException.class)
    public void Insert_Throws_Exception_On_Null_Node() {
        //setup
        MyLinkedList<Integer> actual = null;

        //execute
        actual.insert(new MyLinkedList<>());
    }
}
