import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * Instructions:
 * This is a Java class called JanesStampsJava
 *
 * Please provide your implementation for the challenge in the `spareStamps` method below.
 *
 * Recommended way to work on this:
 * - Use Android Studio and import the folder containing this file as a project
 *
 * Please note the following:
 * - Do not change the signature of the main method `public static int[] spareStamps(int[] stamps)`
 * - Do not change the signature of the main class `JanesStampsJava`
 * - You can make any changes you see fit in the class itself (methods, properties, etc). Mind the rules above
 * - We'll test your code using a larger set of test scenarios. Be sure to deal with edge cases.
 * - The main objective here is getting the solution right. But performance and code quality matters too!
 *
 * Good luck!
 */
class TradableList
{
    private Map<Integer, Integer> stampMap = new TreeMap<>();
    private List<Integer> tradableStamps = new ArrayList<>();

    public void fillMap(int[] stamps)
    {
        for(int i = 0; i < stamps.length; i++)
        {
            if(!stampMap.containsKey(stamps[i]))
            {
                stampMap.put(stamps[i], 1);
            }
            else
            {
                stampMap.put(stamps[i], stampMap.get(stamps[i])+1);
            }
        }
    }

    public void generateTradableList()
    {
        for(Map.Entry<Integer, Integer> entry : stampMap.entrySet())
        {
            for(int i = 0; i < entry.getValue() - 2; i++)
            {
                tradableStamps.add(entry.getKey());
            }
        }
    }

    public int[] getTradableStamps()
    {
        int[] tradableStampsArray = new int[tradableStamps.size()];

        for(int i = 0; i<tradableStamps.size(); i++)
        {
            tradableStampsArray[i] = tradableStamps.get(i);
        }
        return tradableStampsArray;
    }
}


public class JanesStampsJava {

    public static int[] spareStamps(int[] stamps) {
        // TODO: Your implementation here

        TradableList list = new TradableList();

        list.fillMap(stamps);
        list.generateTradableList();

        return list.getTradableStamps();
    }

    // Sample tests for guidance below. Feel free to change or add your own:
    @Test
    public void testSpareStamps() {
        int[] testCase1 = JanesStampsJava.spareStamps( new int[] { 1, 2, 3, 4, 1, 2, 4, 1, 2, 3, 2 });
        Arrays.sort(testCase1);
        assertArrayEquals(new int[] { 1, 2, 2 }, testCase1);

        int[] testCase2 = JanesStampsJava.spareStamps( new int[] { 1, 1, 2, 2, 1 });
        Arrays.sort(testCase2);
        assertArrayEquals(new int[] { 1 }, testCase2);

        int[] testCase3 = JanesStampsJava.spareStamps( new int[] { 7, 7, 7, 7 });
        Arrays.sort(testCase3);
        assertArrayEquals(new int[] { 7, 7 }, testCase3);

        int[] testCase4 = JanesStampsJava.spareStamps( new int[] { 5, 5, 4, 4, 1, 2 });
        Arrays.sort(testCase4);
        assertArrayEquals(new int[] { }, testCase4);

        int[] testCase5 = JanesStampsJava.spareStamps( new int[] { 3 });
        Arrays.sort(testCase5);
        assertArrayEquals(new int[] { }, testCase5);
    }
}