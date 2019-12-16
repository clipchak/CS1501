public class LCS {

    public static String findLCS(String word1, String word2)
    {
        //length of words to use in DP array/table
        int w1Length = word1.length();
        int w2Length = word2.length();

        //table has 1 extra row and column for values of 0
        int[][] dpTable = new int[w1Length+1][w2Length+1];

        // build the table to find the LCS
        for(int i=0; i<=w1Length; i++){
            for(int j=0; j<=w2Length; j++){

                //if were on the first column or row, we initialize first row and column values to 0 and do nothing else
                if(i == 0 || j == 0){
                    dpTable[i][j] = 0;
                }

                else{

                    //if the letter were on in the X column of the dp Table matches a letter in the Y column of the table
                    //we make the value in this spot one more than the diagonal value
                    //this is the spot that has the matching letters
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dpTable[i][j] = dpTable[i - 1][j - 1] + 1;

                    }

                    //else if they do not match
                    //we find the max between the value to the left of the spot and the value to the top of the spot [i][j]
                    //set this value as the spot we are at
                    else{
                        dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
                    }
                }
            }
        }

        // the index is the size of the LCS that we found in above loops.
        // That size is kept at the bottom/right most corner of the DP table
        int index = dpTable[w1Length][w2Length];

        // character array stores the LCS string that we will return
        char[] lcs = new char[index+1];
        lcs[index] = ' '; // last char to be blank

        // Start from the right/bottom corner of DP table and find chars
        // If the current chars in word1 and word2
        // are equal, they are part of the LCS so we go both up and left
        // If not, we go up or left, depending on which cell has a higher number
        int i = w1Length, j = w2Length;
        while(i > 0 && j > 0){

            //if the char of the words are the same then it is the char to be put into LCS
            if(word1.charAt(i-1) == word2.charAt(j-1)){
                // Put current character in result
                lcs[index-1] = word1.charAt(i-1);

                index--;
                i--;
                j--;
            }

            // If the chars we are on are not same we have to decide whether to go up or left
            // (find which number is higher)
            else{
                if(dpTable[i - 1][j] > dpTable[i][j - 1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }


            //return the LCS
        StringBuilder retVal = new StringBuilder();

        for (char lc : lcs) {
            retVal.append(lc);
        }
        return retVal.toString();
    }


}
