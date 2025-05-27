package io.github.vishalmysore.tools4ai;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AgentConfiguration.class) // This will import your config when the annotation is used
public @interface EnableAgent {
}
