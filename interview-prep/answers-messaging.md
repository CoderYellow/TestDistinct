# Kafka, messaging and banking gateway — model answers

## 1. What ordering does Kafka guarantee?
Within a partition, records are ordered by offset. There is no global ordering across partitions. Choose partition keys based on the business entity whose ordering matters (e.g., order ID), considering skew/hot partitions.

## 2. Consumer groups and rebalances
Each partition is assigned to at most one member of a consumer group at a time. A rebalance redistributes assignments after membership or partition changes. In-flight processing must be coordinated with partition revocation; commit only safe progress and ensure reprocessing is idempotent. More consumers than partitions do not improve partition-level parallelism.

## 3. When to commit offsets?
Commit after the business processing boundary you promise. Committing before durable side effects risks loss; committing afterward can replay already-completed work after a crash. Therefore at-least-once processing needs idempotent effects. A DB transaction and Kafka offset commit are separate unless explicitly coordinated.

## 4. At-most-once, at-least-once, exactly-once
At-most-once can lose records but avoids redelivery. At-least-once retries and can duplicate. Kafka's exactly-once semantics can coordinate Kafka transactional reads/writes and offsets for supported Kafka workflows; it does not magically make an external SQL DB or FIX counterparty exactly-once. End-to-end correctness often uses deduplication, outbox and reconciliation.

## 5. Idempotency implementation
Use a stable business idempotency key, a unique DB constraint and a state machine. In a transaction, insert-or-read existing key and return the original result/status for duplicates. Distinguish duplicate request from same key with different payload (reject or flag). Keep dedup state long enough for replay and operational requirements.

## 6. Why persist before asynchronous enqueue?
The DB write can become the durable acceptance point; an in-memory queue alone loses queued items on process failure. **But** there is a gap if the DB commit succeeds and enqueue fails. Recover with a polling worker, transactional outbox or pending-state scanner. The exact implemented mechanism must be verified before describing it as a past accomplishment.

## 7. Disruptor vs BlockingQueue
Disruptor uses preallocated ring-buffer sequencing and can reduce allocation/coordination overhead in certain high-throughput in-process pipelines. BlockingQueue is simpler and often adequate. Both are in-memory and not inherently crash-durable. Measure actual contention/latency; choose based on workload and complexity budget.

## 8. Downstream FIX ACK lost
Do not blindly resend a financial order as if it definitely failed. Track correlation IDs and order states; distinguish definitive rejection from unknown outcome. Query/reconcile downstream status, use protocol-supported sequence/recovery features, and make retry decisions based on business semantics and counterparty guarantees.

## 9. Retry and backoff
Retry transient failures with capped exponential backoff plus jitter; set timeouts and attempt budgets. Do not retry validation failures. Guard against retry storms with circuit breakers and bounded concurrency. Ensure idempotency before retrying side-effecting operations.

## 10. Spark Kafka batch checkpoint/resume
Record which topic partitions and offset ranges were selected, which output was durably committed, and which ranges are safe to mark complete. After crash, re-read incomplete ranges; ensure writes are idempotent or transactional. Kafka consumer-group commits and Spark/application checkpoints are different mechanisms. Discuss partition growth, schema evolution and partially completed batches.

## 11. How to migrate consumers between Kafka clusters?
Validate topic configuration, schemas, ACLs, consumer offsets and producer routing. If using MirrorMaker 2, offset translation is not always instantaneous or exact for every application; test lag and checkpoint propagation. Freeze or coordinate cutover, verify reads and replay strategy, and keep rollback criteria. Never claim a zero-loss guarantee without evidence.

## 12. Outbox pattern
Within one DB transaction, save business state and an outbox event. A separate dispatcher publishes pending events. This closes the DB-commit/queue-enqueue loss gap but **may publish duplicates** if it crashes after sending and before marking sent. Consumers still need idempotency.
