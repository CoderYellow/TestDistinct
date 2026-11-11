# SQL and system design — model answers

## 1. Why does an index help?
A B-tree index narrows candidate rows and may avoid table lookups with covering columns. Composite index effectiveness depends on leading columns, filters, sort order and engine behaviour. Low-selectivity predicates or retrieving much of a table may make scans cheaper. Validate with EXPLAIN/EXPLAIN ANALYZE and realistic data.

## 2. Slow query diagnosis
Capture query and parameters, plan, actual vs estimated rows, timing, locks and I/O. Check missing/misordered indexes, stale statistics, N+1 queries, large sorts and joins. Benchmark the change under representative data; indexes speed reads but cost writes/storage.

## 3. Isolation levels
Read committed prevents dirty reads; repeatable read gives stronger stability of repeated reads (phantom behaviour depends on database/MVCC implementation); serializable aims for serial-equivalent results and may cause retries/serialization failures. State the database engine before promising exact behaviour.

## 4. Deadlocks
Two transactions acquire resources in conflicting order and wait cyclically. Reduce duration, access rows in consistent order, index to avoid wide locking, and retry the aborted transaction with limits. Deadlocks can still happen even with well-designed code.

## 5. Offset vs keyset pagination
OFFSET/LIMIT is easy but deep offsets are expensive and concurrent inserts can shift results. Keyset pagination uses a stable ordered cursor such as `(created_at, id) < (?, ?)` with a matching index, improving large-page navigation. It is less convenient for arbitrary page numbers.

## 6. Optimistic vs pessimistic locking
Optimistic locking uses a version column and compare-and-swap update, good when conflicts are rare. Pessimistic locking takes DB locks to serialize access but can reduce throughput and deadlock. Choose based on contention, invariants and latency.

## 7. Design a reliable order intake service
Clarify throughput, peak burst, ordering, accepted vs completed semantics, latency SLO, consistency, retention and external protocol guarantees. Validate input and authentication; assign an idempotency key; atomically persist order plus outbox; dispatch asynchronously with bounded workers; expose state transitions; reconcile unknown downstream outcomes; instrument latency, errors and backlog; audit sensitive actions. Explain that the diagram is a generic proposed design, **not** a disclosure of HSBC or UOB internal architecture.

## 8. What if 5,000 requests/sec suddenly becomes 20,000?
First identify the bottleneck and accepted latency/error budgets. Apply admission control, quotas, bounded queues, load shedding and autoscaling only where dependencies can scale. Protect DB connection pools and downstream rate limits. Measure queue wait, p99, saturation and backlog drain time. Prefer explicit 429/503 to silently dropping accepted orders.

## 9. How to ensure exactly one order is accepted?
A unique constraint on client/business idempotency key protects concurrent inserts across instances. Return the prior order ID for exact duplicates, and reject same key with conflicting payload. This guarantees one *accepted record* under the DB's constraints; it does not automatically guarantee exactly one external execution.

## 10. Observability for banking backend
Trace each request with a correlation ID (not sensitive payloads); log state transitions and sanitized errors; monitor p50/p95/p99, error rate, queue backlog, retries, connection pool and downstream latency. Alert on customer-impacting SLO burn, not every transient exception.
