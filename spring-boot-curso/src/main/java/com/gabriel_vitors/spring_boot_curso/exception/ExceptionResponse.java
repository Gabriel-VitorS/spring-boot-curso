package com.gabriel_vitors.spring_boot_curso.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

}
