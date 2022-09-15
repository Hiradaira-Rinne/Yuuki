package com.yuuki.entity.response;

import com.yuuki.enums.response.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.parameters.P;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Yuuki
 * @date 2022/6/21 14:27
 */
@Data
@AllArgsConstructor
public class ResponseEntity<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -1862589847917837321L;

    private ResponseCodeEnum code;

    private T data;

    private String description;

    public ResponseEntity() {
        this.code = ResponseCodeEnum.Y00000;
        this.description = ResponseCodeEnum.E00005.getMsg();
    }

    public ResponseEntity(T data) {
        this.code = ResponseCodeEnum.Y00000;
        this.data = data;
        this.description = ResponseCodeEnum.Y00000.getMsg();
    }

    public ResponseEntity(ResponseCodeEnum code, T data) {
        this.code = code;
        this.data = data;
        this.description = ResponseCodeEnum.Y00000.getMsg();
    }
}
