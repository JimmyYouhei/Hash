package com.jimmyyouhei.hash;

public class StringHash {

    private String stringValue;

    public StringHash(String stringValue) {
        this.stringValue = stringValue;
    }

    public StringHash() {
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int additiveHash(){
        char [] thisCharArray = stringValue.toCharArray();

        int result = 0;

        for (char a : thisCharArray){
            result += (int) a;
        }

        return result;
    }

    public int foldingHash(){

        char[] thisCharArray = stringValue.toCharArray();

        int result = 0;

        for (int i = 0 ; i <  thisCharArray.length/4 ; i++){

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0 ; j< 4 ; j++){

                String eachCharBinary = Integer.toBinaryString(thisCharArray[i*4 + j]);
                if (eachCharBinary.length()<8){
                    eachCharBinary = StringHash.makeBinary8Bits(eachCharBinary);
                }
                stringBuilder.insert(0, eachCharBinary);
            }

            result += Integer.parseInt(stringBuilder.toString() , 2);
        }

        if (thisCharArray.length%4 !=0){

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i< thisCharArray.length%4 ; i++){

                String eachCHarBinary = Integer.toBinaryString(thisCharArray[thisCharArray.length/4 * 4 +i]);

                if (eachCHarBinary.length()<8){
                    eachCHarBinary = StringHash.makeBinary8Bits(eachCHarBinary);
                }

                stringBuilder.insert(0, eachCHarBinary);

            }

            result += Integer.parseInt(stringBuilder.toString() , 2);

        }

        return result;
    }


    private static String makeBinary8Bits (String value){

        while (value.length() <8){

            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.insert(0,'0');
            value = sb.toString();
        }

        return value;

    }

}
