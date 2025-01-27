package com.gestion.localserviceapi.resource;

import java.time.Instant;

public record ResourceEmail(
        String contact,
        String ville,
        Instant date,
        String type
) {
}
