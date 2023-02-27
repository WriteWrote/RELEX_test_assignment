package relex2023crypto.service.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResponseDto {
    private String message;

    private Boolean success;
    private Integer idArgs[];

    public ResponseDto(String message, Boolean success, Integer... idArgs) {
        this.message = message;
        this.success = success;
        this.idArgs = idArgs;
    }

    public ResponseDto(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public ResponseDto(String message, Integer... idArgs) {
        this.message = message;
        this.idArgs = idArgs;
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
}
