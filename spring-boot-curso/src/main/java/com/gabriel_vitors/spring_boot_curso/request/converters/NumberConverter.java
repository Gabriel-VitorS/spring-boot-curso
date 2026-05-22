package com.gabriel_vitors.spring_boot_curso.request.converters;

import com.gabriel_vitors.spring_boot_curso.exception.UnsuportedMathOperationException;

public class NumberConverter {


    public static boolean isNumeric(String strNumber){
        var number = isNullOrEmpty(strNumber);

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
    
    public static Double convertToDouble(String strNumber) throws UnsuportedMathOperationException{
        
        var number = isNullOrEmpty(strNumber);
        
        return Double.parseDouble(number);
        
    }


    public static String isNullOrEmpty(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) 
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return strNumber.replace(",", ".");
    }
}
