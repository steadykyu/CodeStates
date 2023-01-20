package com.codestates.member.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    // Binding 으로 인한 에러를 모두 담는다.
    private List<FieldError> fieldErrors;
    // ConstraintValidation Error를 모두 담는다.
    private List<ConstraintViolationError> constraintViolationErrors;

    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationError> constraintViolationErrors) {
        this.fieldErrors = fieldErrors;
        this.constraintViolationErrors = constraintViolationErrors;
    }

    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> constraintViolations) {
        return new ErrorResponse(null, ConstraintViolationError.of(constraintViolations));
    }
    
    @Getter
    @AllArgsConstructor
    public static class FieldError{
        // 내가 원하는 정보
        private String field;
        private Object rejectedValue; 
        private String reason;
        
        public static List<FieldError> of(BindingResult bindingResult){
            List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();

            List<FieldError> processedFieldErrors = fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
            return processedFieldErrors;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ConstraintViolationError{
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        public static List<ConstraintViolationError> of(Set<ConstraintViolation<?>> constraintViolations){

            return constraintViolations.stream()
                    .map(error -> new ConstraintViolationError(
                            error.getPropertyPath().toString(),
                            error.getInvalidValue().toString(),
                            error.getMessage() ))
                    .collect(Collectors.toList());
        }
    }
}
// 스태틱 클래스 에서는 스태틱 메서드로 생성해야한다!!!
