package kr.co.pro.order.common.response;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode{
    SYSTEM_ERROR("일시적 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    INVALID_PARAMETER("값이 올바르지 않습니다."),
    NOT_FOUND("존재하지 않습니다."),
    ILLEGAL_STATUS("잘못된 상태입니다.");

    private final String message;

    public String getMessage(Object... arg){
        return String.format(message, arg);
    }
}