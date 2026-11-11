# Spring Boot / WebFlux

- Bean lifecycle and auto-configuration debugging.
- @Transactional proxies: self-invocation, propagation, rollback rules.
- MVC vs WebFlux: blocking servlet threads vs nonblocking event loops.
- Mono/Flux, cold publishers, flatMap vs concatMap, backpressure.
- Why block() on a Netty event loop is dangerous.
- Handling blocking libraries with boundedElastic (and its limits).
- Retry with exponential backoff, timeouts, circuit breakers, idempotency.
- Spring Security: JWT issuer, audience, signature and authorization.

## Scenario
Design a durable order-intake REST API with asynchronous processing, recovery, status polling and an outbox. A local DB transaction does not automatically make remote message delivery atomic.
