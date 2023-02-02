package kr.co.pro.order.common.exception;

import kr.co.pro.order.common.response.ErrorCode;

public class IllegalStatusException extends BaseException {
    public IllegalStatusException(){
        super(ErrorCode.ILLEGAL_STATUS);
    }

    public IllegalStatusException(String message){
        super(message, ErrorCode.ILLEGAL_STATUS);
    }
}