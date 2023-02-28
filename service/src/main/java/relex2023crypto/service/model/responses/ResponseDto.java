package relex2023crypto.service.model.responses;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResponseDto<T> {
    private String message;
    private Boolean success;
    private T[] args;

    @SafeVarargs
    public ResponseDto(String message, Boolean success, T... args) {
        this.message = message;
        this.success = success;
        this.args = args;
    }

    public ResponseDto(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    @SafeVarargs
    public ResponseDto(String message, T... args) {
        this.message = message;
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T[] getArgs() {
        return args;
    }

    @SafeVarargs
    public final void setArgs(T... args) {
        this.args = args;
    }
}
