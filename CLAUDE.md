# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
./mvnw clean verify          # Full build + all tests (unit + integration + arch)
./mvnw test                  # Unit tests only
./mvnw verify -Dit.test=FunctionalIT  # Run a specific integration test
./mvnw spring-boot:run       # Start the application (H2 in-memory DB)
./mvnw clean package         # Build without running tests
```

Integration tests use the `*IT.java` suffix and run via maven-failsafe-plugin during `verify`.

## Architecture

This is a **hexagonal architecture** (ports & adapters) application built with **Spring Modulith**. The architecture is enforced at build time via ArchUnit tests (`ArchUnitHexagonalTest`, `ArchUnitLayerNamingTest`) — violations cause test failures.

### Module structure

Two domain modules (`booking`, `customer`) plus a `common` module, each following the same internal layout:

```
<module>/
  domain/
    model/          # Pure domain objects — no Spring, no JPA, only Java + Lombok
    port/
      inbound/      # Interfaces the domain exposes to callers (commands/queries)
      outbound/     # Interfaces the domain requires from infrastructure
    service/        # Implements inbound ports; depends only on domain layer
  adapter/
    inbound/web/    # REST controllers + request/response DTOs
    outbound/
      persistence/  # JPA entities, MapStruct mappers, Spring Data repositories
      manager/      # Outbound adapter implementations (e.g. calling customer module)
  config/           # @Configuration classes wiring beans together
```

### Cross-module communication

The `booking` module has **two alternative outbound adapters** for reaching the `customer` module:
- `adapter.outbound.manager.spring` — calls `CustomerApi` in-process via Spring (used in tests/default)
- `adapter.outbound.manager.rest` — calls the customer service over HTTP (alternative deployment)

The active adapter is selected via the `@Configuration` class in `booking/config/`.

### Key architectural rules (enforced by ArchUnit)
- Domain models (`domain.model`) have zero external dependencies (no Spring, no JPA)
- Domain services only depend on domain-layer classes and their own module's ports
- Inbound and outbound adapters must not depend on each other
- Class naming: services end in `Service`, repositories in `Repository`, controllers in `Controller`

### Tech stack
- Java 17, Spring Boot 4.0.1, Spring Modulith 2.0.1
- MapStruct for DTO ↔ entity mapping (generated at compile time via annotation processing)
- Lombok for boilerplate reduction
- H2 in-memory database (runtime/test)
- ArchUnit 1.4.1 for architectural test enforcement

See [docs/hexagonal.md](docs/hexagonal.md) for detailed architecture rationale.
