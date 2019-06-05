package com.jimmyyouhei.hash;

public class StringHash {

    // String for Hashing
    private String stringValue;

    // Quick constructor to set the String above
    public StringHash(String stringValue) {
        this.stringValue = stringValue;
    }

    // empty constructor
    public StringHash() {
    }

    // return the current String value
    public String getStringValue() {
        return stringValue;
    }

    // set the String value
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    // additive hashing algorithm
    public int additiveHash(){

        // convert the String to char array
        char [] thisCharArray = stringValue.toCharArray();

        // init the result int = 0
        int result = 0;

        // loop through the array and add the ASCII value of each string to the result
        for (char a : thisCharArray){
            result += (int) a;
        }

        // return the result
        return result;
    }

    // The folding hashing algorithm
    public int foldingHash(){

        // convert the String to char array
        char[] thisCharArray = stringValue.toCharArray();

        // init the int result = 0
        int result = 0;

        // loop through the char array for each 4 character at a time
        for (int i = 0 ; i <  thisCharArray.length/4 ; i++){

            // init a string builder to add the binary string later
            StringBuilder stringBuilder = new StringBuilder();

            // loop through each of the 4 character
            for (int j = 0 ; j< 4 ; j++){

                //convert each character to Binary String
                String eachCharBinary = Integer.toBinaryString(thisCharArray[i*4 + j]);

                // However not all Character will be convert to 8bits especially when there is "0" at front
                // As a result if so readd the 0 to make all binary 8 bits
                if (eachCharBinary.length()<8){
                    // method to readd 0 below
                    eachCharBinary = StringHash.makeBinary8Bits(eachCharBinary);
                }
                // insert the binary string at the front (from right to left) for the order of character in folding hashing is important
                stringBuilder.insert(0, eachCharBinary);
            }

            //convert the binary String back to int and then add to the result each time a 4-set of characters is convert
            result += Integer.parseInt(stringBuilder.toString() , 2);
        }

        //if there is some characters left that is not a 4-set (meaning the chararray length%4 != 0)
        if (thisCharArray.length%4 !=0){

            // do like above for each 4 set but this time only for any left character

            // init a string builder to add the binary string later
            StringBuilder stringBuilder = new StringBuilder();

            // loop through the left character
            for (int i = 0; i< thisCharArray.length%4 ; i++){

                // convert each character to Binary String
                String eachCHarBinary = Integer.toBinaryString(thisCharArray[thisCharArray.length/4 * 4 +i]);

                // if not 8 bits re add "0"
                if (eachCHarBinary.length()<8){
                    eachCHarBinary = StringHash.makeBinary8Bits(eachCHarBinary);
                }

                // insert the binary string at the front (from right to left) for the order of character in folding hashing is important
                stringBuilder.insert(0, eachCHarBinary);

            }

            //convert the binary String back to int and then add to the result for left over character
            result += Integer.parseInt(stringBuilder.toString() , 2);

        }

        // return the int result
        return result;
    }


    // readd "0" for to make 8 bits Binary String
    private static String makeBinary8Bits (String value){

        // loop until the binary string 8bits
        while (value.length() <8){

            // insert 0 to the front of binary string
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.insert(0,'0');
            //then the new value will be the new add "0" string and loop again
            value = sb.toString();
        }

        // return the new String 
        return value;

    }

}
