# Kafka, MQ and reliability

## Kafka
- Partition ordering is per partition, not globally.
- Consumer groups, partition assignment and rebalances.
- Commit offsets only after the intended processing boundary.
- At-least-once means duplicates are possible; make sinks idempotent.
- Kafka transactions have boundaries and do not automatically cover external databases.
- Explain replay and application checkpoints vs consumer group offsets.

## FX gateway deep dive
1. Why receive messages through MQ, SFTP and REST?
2. Why persist raw inbound messages before asynchronous processing?
3. What happens if the process crashes after DB commit but before enqueue?
4. How would recovery scans, deduplication and reconciliation work?
5. Why Disruptor rather than BlockingQueue? What happens on process crash?
6. How do you handle downstream FIX acknowledgement loss and unknown order status?

Only describe mechanisms you genuinely implemented. Separate real project behaviour from a hypothetical redesign.
