# Java core

1. HashMap vs ConcurrentHashMap: synchronization, atomic compute, iteration.
2. volatile vs synchronized vs AtomicInteger: visibility, mutual exclusion, CAS.
3. Thread pools: sizing, bounded queues, rejection policies, saturation and shutdown.
4. CompletableFuture: composition, exception handling and executor selection.
5. Java Memory Model: happens-before, safe publication, immutability.
6. JVM troubleshooting: heap dumps, thread dumps, JFR, GC logs, direct memory.

## Drill
A production API has rising p99 latency, low CPU and hundreds of waiting threads. Explain a methodical investigation: latency breakdown, thread dumps, connection pools, downstream timeouts, recent deploys and mitigation.

## Coding
Implement an idempotency-key guard with a unique database constraint; explain why an in-memory map alone is insufficient across instances.
