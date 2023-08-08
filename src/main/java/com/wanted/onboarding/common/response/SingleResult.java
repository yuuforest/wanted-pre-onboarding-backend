package com.wanted.onboarding.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends Result {

    private T data;

}
