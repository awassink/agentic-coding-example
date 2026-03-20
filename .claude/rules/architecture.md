# Architecture

This is a **hexagonal architecture** (ports & adapters) application built with **Spring Modulith**. The architecture is enforced at build time via ArchUnit tests (`ArchUnitHexagonalTest`, `ArchUnitLayerNamingTest`) — violations cause test failures.

## Module structure

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

# Architectural Rules (ArchUnit-enforced)

These rules are enforced as tests — violations will fail the build.

- Domain models (`domain.model`) have zero external dependencies (no Spring, no JPA, only Java + Lombok)
- Domain services only depend on domain-layer classes and their own module's ports
- Inbound and outbound adapters must not depend on each other


## Cross-module communication

The `booking` module has **two alternative outbound adapters** for reaching the `customer` module:
- `adapter.outbound.manager.spring` — calls `CustomerApi` in-process via Spring (used in tests/default)
- `adapter.outbound.manager.rest` — calls the customer service over HTTP (alternative deployment)

The active adapter is selected via the `@Configuration` class in `booking/config/`.

See [docs/hexagonal.md](../../docs/hexagonal.md) for detailed architecture rationale.
