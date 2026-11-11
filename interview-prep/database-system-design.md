# SQL and system design

## SQL
- B-tree indexes, composite index prefix, selectivity and covering indexes.
- EXPLAIN ANALYZE, cardinality estimation, scans and joins.
- Isolation: read committed, repeatable read, serializable; DB-specific MVCC.
- Deadlocks, transaction ordering and retry.
- Offset vs keyset pagination.
- Idempotency via unique constraints and state transitions.

## Generic reference design (not client architecture)
```
MQ / SFTP / REST
    -> validation
    -> durable inbound record
    -> outbox / recovery worker
    -> bounded async processor
    -> downstream FIX engine
    -> status / reconciliation
```

Discuss durability boundaries, retries, ordering, duplicate delivery, audit trails, backpressure, p99 latency, capacity planning and observability.
