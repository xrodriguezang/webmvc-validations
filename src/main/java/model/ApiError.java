package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiError {

    public ApiError (int code, String error) {
        this.code = code;
        this.error = error;
    }

    private int code;
    private String error;  // Suposen que és un codi intern nostre

}
