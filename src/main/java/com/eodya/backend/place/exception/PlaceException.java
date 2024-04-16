package com.eodya.backend.place.exception;

import com.eodya.backend.common.exception.BusinessException;
import com.eodya.backend.common.exception.ExceptionCode;

public class PlaceException extends BusinessException {

    public PlaceException(ExceptionCode exceptionCode, Object... rejectedValues) {
        super(exceptionCode, rejectedValues);
    }
}

