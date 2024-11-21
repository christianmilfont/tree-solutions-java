package org.example.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    // Não há necessidade de código adicional aqui, o JAX-RS vai procurar as classes com a anotação @Path
}
