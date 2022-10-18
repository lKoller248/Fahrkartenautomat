import java.util.Scanner;

// Does not check if number is a valid number.

public class Rome {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        char[] romanNumber;
        String input;


        System.out.print("Please enter a roman number: ");
        input = (keyboard.nextLine()).toUpperCase();
        romanNumber = input.toCharArray();
        if(validRomanNumber(input)){
            int result = romanToInt(romanNumber);
            System.out.println("The roman number " + input + " is equal to the decimal number " + result + ".");
        }else{
            System.out.println("The input " + input + " is not a roman number.");
        }
    }

    public static boolean validRomanNumber(String number) {
        if(number.contains("IIII") || number.contains("XXXX") || number.contains("CCCC") || number.contains("MMMM")){
            return false;
        }
        if(number.contains("VV") || number.contains("LL") || number.contains("DD")){
            return false;
        }
        if(number.contains("IL") || number.contains("IC") ||number.contains("ID") ||number.contains("IM")){
            return false;
        }
        if(number.contains("XD") || number.contains("XM")){
            return false;
        }
        if(number.contains("IIV") || number.contains("IIX") ||number.contains("IIL") ||number.contains("IIC") || number.contains("IID") || number.contains("IIM")){
            return false;
        }
        if(number.contains("XXL") || number.contains("XXC") ||number.contains("XXD") ||number.contains("XXM")){
            return false;
        }
        if(number.contains("CCD") || number.contains("CCM")){
            return false;
        }
        char[] a = number.toCharArray();
        for(int i = 0; i < a.length; i++){
            if(a[i] != 'M' && a[i] != 'D' && a[i] != 'C' && a[i] != 'L' && a[i] != 'X' && a[i] != 'V' && a[i] != 'I'){
                return false;
            }
        }
        return true;
    }

    public static int romanToInt(char[] romanNumber){
        int result = 0;
        for(int i = 0; i < romanNumber.length; i++) {
            switch (romanNumber[i]) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if(i < romanNumber.length - 1) {
                        if (romanNumber[i + 1] == 'M') {
                            result += 900;
                            i++;
                        } else if (romanNumber[i + 1] == 'D') {
                            result += 400;
                            i++;
                        } else {
                            result += 100;
                        }
                    }else {
                        result += 100;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if(i < romanNumber.length - 1) {
                        if (romanNumber[i + 1] == 'C') {
                            result += 90;
                            i++;
                        } else if (romanNumber[i + 1] == 'L') {
                            result += 40;
                            i++;
                        } else {
                            result += 10;
                        }
                    }else {
                        result += 10;
                    }
                    break;
                case 'V':
                    result +=5;
                    break;
                case 'I':
                    if(i < romanNumber.length - 1) {
                        if (romanNumber[i + 1] == 'X') {
                            result += 9;
                            i++;
                        } else if (romanNumber[i + 1] == 'V') {
                            result += 4;
                            i++;
                        } else {
                            result += 1;
                        }
                    }else {
                        result += 1;
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}

