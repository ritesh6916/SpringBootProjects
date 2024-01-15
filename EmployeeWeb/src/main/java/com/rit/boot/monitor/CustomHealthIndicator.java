package com.rit.boot.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		boolean error = false; // we can change the flag based on our requirement
		if (error) {
			return Health.down().withDetail("Cause", 404).build();
		}
		return Health.up().withDetail("Sab thik h:", "Radhe-Radhe").build();

		// http://localhost:8080/MyApp/actuator/health (to invoke)
	}
}
