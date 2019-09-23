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

public class RecursionS19 {

    /**
     * returns the number of ways to make a specified target, by combining weights,  where each
     * weight may be used an arbitrary number of times: 0 (not used), 1 (used once), 2, etc. weights
     * should therefore not contain any duplicate values
     */
    public static int subsetSumCountHelper(int target, int[] weights, int currentIndex) {

        // base case 1:
        if (target == 0) // we achieve goal
            return 1;
        // base case 2
        if (currentIndex == weights.length)
            return 0; // run out of weight -> this leaf fails
        // base case 3
        if (weights[currentIndex] > target) // if a weight is bigger than the target
            return subsetSumCountHelper(target, weights, currentIndex + 1); // skip that weight

        // recursive part
        // number of ways we use the current weight
        int use = subsetSumCountHelper(target - weights[currentIndex], weights, currentIndex);
        // number if ways we don't use the current weight
        int notUse = subsetSumCountHelper(target, weights, currentIndex + 1);
        return use + notUse; // we want the sum
    }

    public static int subsetSumCount(int target, int[] weights) {
        return subsetSumCountHelper(target, weights, 0);
    }

    // returns the length of the longest palindrome subsequence in the given string s
    public static int lpsLength(String s) {
        // base case 1
        if (s.length() <= 1) // if a string is empty or has only 1 character
            return s.length();
        // base case 2
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) // if a string has 2 identical characters
            return 2; // then string itself is the lps

        // recursive part
        // if the first and last character are the same
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return 2 + lpsLength(s.substring(1, s.length() - 1)); // add 2 to our final result
        else { // if the first and last character of the string are NOT the same
            return Math.max(lpsLength(s.substring(0, s.length() - 1)),
                            lpsLength(s.substring(1))); // recursively call the method on substrings
        }
    }


    // Returns one longest palindrome subsequence in the given string s.
    // If there are multiple LPSs in s, return any one of them.
    public static String lps(String s) {
        // base cases
        if (s.length() == 0) // empty string
            return "";
        if (s.length() == 1) // 1 letter string
            return s;

        // recursive part
        // if first and last character of the string are the same
        if (s.charAt(0) == s.charAt(s.length() - 1))
            // our lps will have those 2 letters at 2 ends and then we call lps again on the middle part
            return s.charAt(0) + lps(s.substring(1, s.length() - 1)) + s.charAt(s.length() - 1);

        // if first and last character of the string are NOT the same
        String first = lps(s.substring(1)); // either call lps on substring 1
        String second = lps(s.substring(0, s.length() - 1)); // or substring 0 to length -1
        if (first.length() >= second
                .length()) // return which ever case that gives us a longer result
            return first;
        else
            return second;
    }


    public static boolean shuffle(String s1, String s2, String s3) {
        // base case for true
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) // all string are empty -> goal achieved
            return true;
        // one string is empty and the other and the target string are identical
        if ((s1.equals(s3) && s2.isEmpty()) || (s2.equals(s3) && s1.isEmpty()))
            return true;

        // base case for false
        // we have to create 2 booleans because s1 and s2 can both start with a character
        // as s3 starts with
        boolean str1 = false;
        boolean str2 = false;
        // if both s1 and s2 don't start with the same character as s3
        if ((s3.charAt(0) != s1.charAt(0)) && (s3.charAt(0) != s2.charAt(0)))
            return false;
        else if (s3.charAt(0) == s1.charAt(0)) // recursive part
            str1 = shuffle(s1.substring(1), s2, s3.substring(1));
        else if (s3.charAt(0) == s2.charAt(0))
            str2 = shuffle(s1, s2.substring(1), s3.substring(1));
        // we have to create two boolean because there will be cases where both
        // s1 and s2 start with the same character that s3 starts with
        // then, we have to call shuffle on both cases and return whichever case
        // that is true
        return str1 || str2;
    }


    public static void main(String[] args) {
    }

}
