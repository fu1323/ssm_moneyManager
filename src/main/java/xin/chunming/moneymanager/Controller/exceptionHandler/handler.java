package xin.chunming.moneymanager.Controller.exceptionHandler;

import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import xin.chunming.moneymanager.exception.DataNotEditableException;
import xin.chunming.moneymanager.exception.NullDateException;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.exception.loginfailException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class handler {

    @ExceptionHandler(DataNotEditableException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) // 返回 403 状态码
    @ResponseBody
    public Map<String, String> handleDataNotEditableException(DataNotEditableException ex) {
        Map<String, String> response = new HashMap<>();
//        response.put("error", "不可修改");
        response.put("message", ex.getMessage());
        return response;
    }
    @ExceptionHandler(NullDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleNullDateException(DataNotEditableException ex) {
        Map<String, String> response = new HashMap<>();
//        response.put("error", "不可修改");
        response.put("message", ex.getMessage());
        return response;
    }
    @ExceptionHandler(convertException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleUnknownFunctionOrVariableException(Exception ex) {
        Map<String, String> response = new HashMap<>();
//        response.put("error", "不可修改");

        response.put("message", ex.getMessage());
        return response;
    }
    @ExceptionHandler(loginfailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleloginfailException(Exception ex) {
        Map<String, String> response = new HashMap<>();
//        response.put("error", "不可修改");

        response.put("message", ex.getMessage());
        return response;
    }




}


