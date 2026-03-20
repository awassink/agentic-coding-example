---
paths:
  - "src/**/*.java"
---

# Architectural Rules (ArchUnit-enforced)

These rules are enforced as tests — violations will fail the build.
- Class naming: services end in `Service`, repositories in `Repository`, controllers in `Controller`

## Tech stack
- Java 21, Spring Boot 4.0.1, Spring Modulith 2.0.1
- MapStruct for DTO ↔ entity mapping (generated at compile time via annotation processing)
- Lombok for boilerplate reduction
- H2 in-memory database (runtime/test)
- ArchUnit 1.4.1 for architectural test enforcement
