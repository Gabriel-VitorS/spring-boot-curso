package com.gabriel_vitors.spring_boot_curso.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel_vitors.spring_boot_curso.exception.UnsuportedMathOperationException;
import com.gabriel_vitors.spring_boot_curso.math.SimpleMath;
import com.gabriel_vitors.spring_boot_curso.request.converters.NumberConverter;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/math")
public class MathController {


    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo 
    )throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo 
    )throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo 
    )throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double media(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo 
    )throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/sqrt/{numberOne}")
    public Double sqrt(
        @PathVariable("numberOne") String numberOne
    )throws Exception {

        if(!NumberConverter.isNumeric(numberOne)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return math.sqrt(NumberConverter.convertToDouble(numberOne));
    }
    
}
