# Java & Spring — interview questions with model answers

These are **reference answers**, not claims about any particular employer's implementation.

## 1. HashMap vs ConcurrentHashMap
**Answer:** HashMap is not thread-safe for concurrent mutation. ConcurrentHashMap supports concurrent reads and updates using fine-grained coordination/CAS (implementation depends on JDK). Its iterators are weakly consistent, not fail-fast snapshots. It disallows null keys and values. Use atomic compound operations such as `computeIfAbsent` instead of `if (!containsKey) put`. A ConcurrentHashMap does **not** make operations spanning multiple keys atomic.

**Follow-up:** For a cache with expiration, ConcurrentHashMap alone does not provide TTL or eviction; use a bounded cache with explicit expiry semantics.

## 2. volatile, synchronized and AtomicInteger
**Answer:** `volatile` ensures visibility and ordering around reads/writes but does not make `count++` atomic. `synchronized` gives mutual exclusion and happens-before on monitor release/acquire. `AtomicInteger.incrementAndGet()` uses atomic read-modify-write (typically CAS). Use a lock when multiple state changes must be consistent together.

## 3. Thread pool sizing and overload
**Answer:** For CPU-bound work start near available CPU cores; for blocking I/O, more threads can help but must be bounded by downstream capacity and connection pools. Monitor active threads, queue depth, rejection count, latency and saturation. Use bounded queues, explicit rejection/backpressure, timeouts and graceful shutdown. An unbounded queue hides overload until latency/memory explodes.

## 4. CompletableFuture
**Answer:** `thenApply` maps a value; `thenCompose` flattens a nested future for dependent asynchronous calls. `thenCombine` combines independent futures. `exceptionally` recovers failures, `handle` observes both success and failure. Explicitly choose an executor for blocking tasks; async stages without one may use the common pool. Cancellation does not guarantee a running remote call is stopped.

## 5. Java Memory Model and happens-before
**Answer:** Happens-before defines when writes in one thread must be visible to another. Examples: monitor unlock before later lock of same monitor, volatile write before subsequent read, thread start/join rules. Safe publication can use final fields, volatile references or synchronized access. Double-checked locking requires a volatile singleton reference to prevent unsafe publication.

## 6. JVM high memory / OOM investigation
**Answer:** Identify which memory: heap, metaspace, native/direct buffers or container memory. Inspect GC logs, JFR, heap usage, `jcmd VM.native_memory` (if enabled), heap dumps and process/container limits. Frequent full GC and retained objects suggest heap pressure; direct buffer or thread-stack growth may trigger container OOM without Java heap OOM. Stabilise service first, then compare allocation and retention paths.

## 7. Spring @Transactional self-invocation
**Answer:** In common proxy-based Spring AOP, an internal call like `this.save()` bypasses the proxy, so the annotation on the invoked method may not apply. Put the transactional method behind a Spring-managed proxy, call via another bean, or use programmatic transactions. Default rollback is for unchecked exceptions and Errors; checked exceptions need configuration.

## 8. REQUIRED vs REQUIRES_NEW
**Answer:** REQUIRED joins an existing transaction or creates one. REQUIRES_NEW suspends an existing transaction and opens a new independent transaction; inner commit can succeed even if outer later rolls back. It may require an additional DB connection and create pool pressure. Do not use it casually.

## 9. Spring MVC vs WebFlux
**Answer:** MVC usually processes requests with servlet threads; WebFlux uses nonblocking I/O and Reactor publishers, often with a small event-loop pool. WebFlux can improve resource utilisation for high-concurrency I/O waits, but not CPU-intensive work, and blocking code on an event loop harms all requests sharing that loop. If using blocking JDBC, isolate it on a bounded scheduler or prefer a reactive driver, and measure throughput.

## 10. Mono, Flux, flatMap, concatMap and backpressure
**Answer:** Mono emits zero or one item; Flux emits zero to many. Most Reactor publishers are lazy until subscribed. `flatMap` can interleave concurrent inner streams; `concatMap` preserves sequential processing order. Backpressure expresses downstream demand, but sources/operators may buffer: bound concurrency and prefetch, and define overflow behaviour. Avoid unbounded buffering under overload.

## 11. Diagnose rising p99 with low CPU
**Answer:** Check metrics by endpoint, traces and recent releases; inspect thread dumps, event-loop blocking, connection-pool waits, lock contention, downstream latency and timeouts. Low CPU does not mean healthy: threads may be waiting on I/O. Mitigate via rollback, rate limiting or isolating a failing dependency, then confirm root cause with traces and thread state.

## 12. Spring Security JWT
**Answer:** Validate signature using trusted keys, expected issuer, audience, expiration and token type; then map scopes/roles to endpoint authorisation. Authentication answers *who*; authorisation answers *what they may do*. Never trust unsigned decoded JWT payloads.
