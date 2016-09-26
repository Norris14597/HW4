import org.junit.Test;
import org.junit.Assert;
import HW3Package.*;

/**
 * Created by jennasowers on 9/26/16.
 */
public class TestTriple {
    @Test
    public void testIDS()
    {
        //given
        Integer one = new Integer(1);
        Double two = new Double(2.2);
        String three = new String("three");
        //when
        Triple<Integer,Double,String> triple = new Triple<>(one, two, three);
        //then
        Assert.assertEquals("Error Int one", Integer.valueOf(1), triple.getLeft());
        Assert.assertEquals("Error Double two", Double.valueOf(2.2), triple.getMiddle());
        Assert.assertEquals("Error String three", String.valueOf("three"), triple.getRight());

    }

    @Test
    public void testSetIDS()
    {
        //given
        Integer one = new Integer(1);
        Double two = new Double(2.2);
        String three = new String("three");
        //when
        Triple<Integer,Double,String> triple = new Triple<>(one, two, three);
        triple.setLeft(11);
        triple.setMiddle(12.2);
        triple.setRight("thirteen");
        //then
        Assert.assertEquals("Error Int one", Integer.valueOf(11), triple.getLeft());
        Assert.assertEquals("Error Double two", Double.valueOf(12.2), triple.getMiddle());
        Assert.assertEquals("Error String three", String.valueOf("thirteen"), triple.getRight());

    }
    @Test
    public void testIII()
    {
        //given
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        Integer three = new Integer(3);
        //when
        Triple<Integer, Integer, Integer> triple = new Triple<>(one, two, three);
        //then
        Assert.assertEquals("Error Int one", Integer.valueOf(1), triple.getLeft());
        Assert.assertEquals("Error Int two", Integer.valueOf(2), triple.getMiddle());
        Assert.assertEquals("Error Int three", Integer.valueOf(3), triple.getRight());

    }
    @Test
    public void testDDD()
    {
        //given
        Double one = new Double(1.1);
        Double two = new Double(2.2);
        Double three = new Double(3.3);
        //when
        Triple<Double,Double,Double> triple = new Triple<>(one, two, three);
        //then
        Assert.assertEquals("Error Double one", Double.valueOf(1.1), triple.getLeft());
        Assert.assertEquals("Error Double two", Double.valueOf(2.2), triple.getMiddle());
        Assert.assertEquals("Error Double three", Double.valueOf(3.3), triple.getRight());

    }
    @Test
    public void testSSS()
    {
        //given
        String one = new String("one");
        String two = new String("two");
        String three = new String("three");
        //when
        Triple<String,String,String> triple = new Triple<>(one, two, three);
        //then
        Assert.assertEquals("Error String one", String.valueOf("one"), triple.getLeft());
        Assert.assertEquals("Error String two", String.valueOf("two"), triple.getMiddle());
        Assert.assertEquals("Error String three", String.valueOf("three"), triple.getRight());

    }
}
