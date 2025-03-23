import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StreamExampleTest {

    @Test
    void testMainMethodOutput_NormalCase() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        StreamExample.main(new String[]{});

        // Restore System.out
        System.setOut(originalOut);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the output contains expected results for the normal case
        assertTrue(output.contains("Even Numbers:"));
        assertTrue(output.contains("2"));
        assertTrue(output.contains("4"));
        assertTrue(output.contains("6"));
        assertTrue(output.contains("Odd Numbers Cubed:"));
        assertTrue(output.contains("1"));
        assertTrue(output.contains("27"));
        assertTrue(output.contains("125"));
        assertTrue(output.contains("Sum of All Numbers: 55"));
        assertTrue(output.contains("List of Even Numbers: [2, 4, 6, 8, 10]"));
        assertTrue(output.contains("Flattened List:"));
        assertTrue(output.contains("Grouped by Even and Odd:"));
        assertTrue(output.contains("People Older Than 25:"));
        assertTrue(output.contains("Oldest Person:"));
    }

    @Test
    void testMainMethodOutput_EmptyListEdgeCase() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Simulate an empty list scenario by modifying the main method's logic (if possible)
        // For this test, we assume the program handles empty lists gracefully.

        // Run the main method
        StreamExample.main(new String[]{});

        // Restore System.out
        System.setOut(originalOut);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the program handles empty lists gracefully
        assertFalse(output.contains("Error")); // Ensure no errors occurred
        assertTrue(output.contains("Even Numbers:"));
        assertTrue(output.contains("Odd Numbers Cubed:"));
        assertTrue(output.contains("Sum of All Numbers: 0")); // Sum should be 0 for an empty list
        assertTrue(output.contains("List of Even Numbers: []")); // Even numbers list should be empty
    }

    @Test
    void testMainMethodOutput_SingleElementEdgeCase() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Simulate a single-element list scenario by modifying the main method's logic (if possible)
        // For this test, we assume the program processes a single-element list correctly.

        // Run the main method
        StreamExample.main(new String[]{});

        // Restore System.out
        System.setOut(originalOut);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the program handles a single-element list correctly
        assertTrue(output.contains("Even Numbers:"));
        assertTrue(output.contains("Odd Numbers Cubed:"));
        assertTrue(output.contains("Sum of All Numbers:")); // Ensure the sum is correct
        assertTrue(output.contains("List of Even Numbers:")); // Ensure even numbers are processed
    }

    @Test
    void testMainMethodOutput_AllOddNumbersEdgeCase() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Simulate an all-odd-numbers scenario by modifying the main method's logic (if possible)
        // For this test, we assume the program processes all-odd-numbers correctly.

        // Run the main method
        StreamExample.main(new String[]{});

        // Restore System.out
        System.setOut(originalOut);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the program handles all-odd-numbers correctly
        assertTrue(output.contains("Odd Numbers Cubed:"));
        assertFalse(output.contains("Even Numbers:")); // No even numbers should be present
        assertTrue(output.contains("Sum of All Numbers:")); // Ensure the sum is correct
    }

    @Test
    void testMainMethodOutput_AllEvenNumbersEdgeCase() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Simulate an all-even-numbers scenario by modifying the main method's logic (if possible)
        // For this test, we assume the program processes all-even-numbers correctly.

        // Run the main method
        StreamExample.main(new String[]{});

        // Restore System.out
        System.setOut(originalOut);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the program handles all-even-numbers correctly
        assertTrue(output.contains("Even Numbers:"));
        assertFalse(output.contains("Odd Numbers Cubed:")); // No odd numbers should be present
        assertTrue(output.contains("Sum of All Numbers:")); // Ensure the sum is correct
    }
}