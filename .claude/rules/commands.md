# Build & Test Commands

```bash
./mvnw clean verify          # Full build + all tests (unit + integration + arch)
./mvnw test                  # Unit tests only
./mvnw verify -Dit.test=FunctionalIT  # Run a specific integration test
./mvnw spring-boot:run       # Start the application (H2 in-memory DB)
./mvnw clean package         # Build without running tests
```

Integration tests use the `*IT.java` suffix and run via maven-failsafe-plugin during `verify`.
