package io.github.vishalmysore.tools4ai;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ConditionalAgentImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // Check if @EnableSecureAgent is present
        if (importingClassMetadata.hasAnnotation("io.github.vishalmysore.secure.EnableAgentSecurity")) {
            // Skip importing AgentConfiguration
            return new String[0];
        }

        // Otherwise, import AgentConfiguration
        return new String[]{"io.github.vishalmysore.tools4ai.AgentConfiguration"};
    }
}
