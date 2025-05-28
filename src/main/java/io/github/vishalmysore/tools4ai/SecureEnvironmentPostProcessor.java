package io.github.vishalmysore.tools4ai;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

@Log
public class SecureEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // Here, check classpath or some logic to determine security
        boolean secureMode = checkSecureMode();
        log.info("Secure mode enabled found jar on classppath: " + secureMode);
        if (secureMode) {
            environment.getSystemProperties().put("agent.secure.enabled", "true");
        }
    }

    private boolean checkSecureMode() {
        try {
            Class.forName("io.github.vishalmysore.secure.EnableAgentSecurity");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
