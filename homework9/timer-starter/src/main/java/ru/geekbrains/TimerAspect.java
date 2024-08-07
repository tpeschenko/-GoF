package ru.geekbrains;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class TimerAspect {

    @Pointcut("@annotation(ru.geekbrains.Timer)")
    private void methodsWithTimer(){}

    @Around("methodsWithTimer()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint)
        throws Throwable {
        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        double elapsedTime = (double) (System.currentTimeMillis() - start) / 1000;

        log.info("Класс: " + proceedingJoinPoint.getTarget().getClass().getName() +
                " Метод: " + proceedingJoinPoint.getSignature().getName() +
                " выполнился за " + elapsedTime + " секунд");

        return result;

    }

}
