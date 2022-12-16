package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class Aspect2 {

    @Pointcut("execution(* start.aop.order..*(..))")
    private void allOrder(){} // 포인트컷 시그니처, 반환형은 void

    @Around("allOrder()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
