package hello.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Slf4j
public class MemoryCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //-Dmemory=on
        String memory = context.getEnvironment().getProperty("memory");
        log.info("memory = " + memory);     //스프링이 로딩되는 과정은 복잡해서 `MemoryCondition`이 여러번 호출될 수 있음.
        return "on".equals(memory);
    }
}
