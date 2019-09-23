/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

public class RecursionS19Tests {

    /**
     * runs the lps methods in RecursionS19 with the examples given in the assignment description
     */

    public static void testSubsetCount() {
        int[] test = { 5, 2, 3 };
        int target = 10;
        int actualCount = RecursionS19.subsetSumCount(target, test);
        int expectedCount = 4;
        StdOut.println(
                "Test weights and target of " + target + " have subset count of: " + actualCount);
        if (actualCount == expectedCount)
            StdOut.println("Correct");
        else
            StdOut.println("Wrong Answer! Expected:" + expectedCount);
    }

    public static void testLPSExamples() {
        String[] lpsTests = {
                "aba",
                "zryxadavr", "abcdefg", "aaxyz", "axbzay",
                "abcxcybza", "ATGCATCATTGACCA"
        };
        int[] expectedLpsLengths = { 3, 5, 1, 2, 3, 7, 10 };
        int numLpsTests = lpsTests.length;
        for (int i = 0; i < numLpsTests; i++) {
            int actualLpsLength = RecursionS19.lpsLength(lpsTests[i]);
            StdOut.println(lpsTests[i] + ", computed LPS length: "
                                   + actualLpsLength);
            if (actualLpsLength == expectedLpsLengths[i])
                StdOut.println(" Correct!");
            else
                StdOut.println(" Wrong Answer! Expected: " + expectedLpsLengths[i]);

            String actualLPS = RecursionS19.lps(lpsTests[i]);
            StdOut.printf(" Computed LPS String: %s, and its length: %d  \n\n",
                          actualLPS, actualLPS.length());
        }
    }

    public static void testShuffle() {
        String[] tests = { "spa", "sm", "rchi", "ichbo" };
        String[] results = { "spasm", "richboi" };
        boolean expectResult1 = true;
        boolean expectResult2 = false;

        // test 1
        boolean actualResult1 = RecursionS19.shuffle(tests[0], tests[1], results[0]);
        StdOut.println(
                "The shuffle of " + tests[0] + " and " + tests[1] + " can be " + results[0] + " : "
                        + actualResult1);
        if (actualResult1)
            StdOut.println("Correct");
        else
            StdOut.println("Wrong! The answer should be " + expectResult1);

        // test 2
        boolean actualResult2 = RecursionS19.shuffle(tests[2], tests[3], results[1]);
        StdOut.println(
                "The shuffle of " + tests[2] + " and " + tests[3] + " can be " + results[1] + " : "
                        + actualResult2);
        if (!actualResult2)
            StdOut.println("Correct");
        else
            StdOut.println("Wrong! The answer should be " + expectResult2);
    }

    public static void main(String[] args) {
        testSubsetCount();
        testLPSExamples();
        testShuffle();
    }
}
