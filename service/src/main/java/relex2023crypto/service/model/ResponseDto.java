package relex2023crypto.service.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResponseDto {
    private String message;
    private Integer idArgs[];

    public ResponseDto(String message, Integer ... idArgs) {
        this.message = message;
        this.idArgs = idArgs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
