package com.wanted.onboarding.common.response;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private static final String SUCCESS = "요청에 성공하였습니다.";

    public void setSuccessResponse(Result result) {
        result.setSuccess(true);
        result.setMessage(SUCCESS);
    }

    public Result getSuccessResponse() {
        Result result = new Result();
        setSuccessResponse(result);
        return result;
    }

    public <T> SingleResult<T> getSingleData(T data) {
        SingleResult<T> result = new SingleResult<>();
        setSuccessResponse(result);
        result.setData(data);
        return result;
    }

    public <T> ListResult<T> getListData(List<T> data) {
        ListResult<T> result = new ListResult<>();
        setSuccessResponse(result);
        result.setData(data);
        return result;
    }

}
