package com.yuuki.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Yuuki
 * @date 2022/6/21 14:27
 */
@Data
@AllArgsConstructor
public class ResponseEntity<T> {

    private final String OPERATE_SUCCESSFULLY = "操作成功";

    private Integer code;

    private T data;

    private String description;

    public ResponseEntity() {
        this.code = HttpStatus.OK.value();
        this.description = this.OPERATE_SUCCESSFULLY;
    }

    public ResponseEntity(T data) {
        this.code = HttpStatus.OK.value();
        this.data = data;
        this.description = this.OPERATE_SUCCESSFULLY;
    }

    public ResponseEntity(Integer code, T data) {
        this.code = code;
        this.data = data;
        this.description = this.OPERATE_SUCCESSFULLY;
    }
}
