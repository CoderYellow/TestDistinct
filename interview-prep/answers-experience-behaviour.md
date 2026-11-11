# CV deep dive — sample answers and truthfulness checks

**Important:** The submitted CV supports the project themes below, but not precise throughput numbers, architecture ownership, recovery mechanisms or performance improvements. Replace bracketed details only with verified facts from your own experience.

## 1. Tell me about yourself
“I'm a backend software engineer with over seven years of experience, mainly in Java, Spring Boot and distributed systems. I worked on an FX order management gateway for HSBC, integrating IBM MQ, SFTP and REST inputs with FIX downstream processing. More recently, on a DBS data platform, I built Kotlin/Spring/WebFlux operational services and Spark/Kafka processing workflows. I enjoy engineering systems that are maintainable and reliable in production.”

## 2. Why has your recent work focused on SRE/data rather than Java?
“My responsibilities expanded into operational tooling and data workflows, but I remained hands-on with backend development. For example, I developed Kotlin/Spring Boot/WebFlux services for platform diagnostics and worked on Spark/Kafka batch processing. The operational perspective also helped me understand deployment, recovery and production failure modes. I'm now seeking a role with a stronger ongoing backend engineering focus.”

## 3. Describe HSBC FX Gateway
“The system integrated orders arriving through different interfaces, including MQ, SFTP and REST. I worked on normalising upstream data into FIX messages and asynchronous gateway components. We persisted raw inbound data before asynchronous processing to reduce the risk of losing accepted orders. I also worked with WebFlux/Disruptor and SSE/WebSocket updates. I can walk through the components I personally implemented and the failure cases we considered.”

**Do not add:** a claim of guaranteed exactly-once processing, a specific TPS, or an unverified recovery scanner.

## 4. Why use Disruptor?
“We needed an in-process event-driven processing mechanism. Disruptor was one option for coordinating producers and consumers with predictable overhead. I would compare it with BlockingQueue based on measured contention, ordering and latency. Because it is in-memory, persistence and recovery must be handled separately.” If asked why it was selected *in your project*, give only the real decision rationale.

## 5. Describe DBS work
“I worked on operational services for a centralised data platform with Cloudera/HDFS/YARN/Hive/S3, as well as Spark jobs reading Kafka in batches with checkpoint/resume support. I also contributed to Jenkins and deployment automation for OpenShift/GCP. I can explain my personal changes and how we verified recovery.” Provide exact offset and output commit semantics only if you remember them.

## 6. Tell me about a production incident
Use **STAR**: situation and impact; your responsibility; diagnosis and mitigation; measurable outcome; prevention. Do not invent an incident. Prepare one real example involving deployment, Kafka, Spark or downstream dependencies.

## 7. Why UOB / Singapore?
“I'm interested in continuing backend engineering in a banking environment where reliability and integration matter. My previous banking experience would help me understand production discipline, and Singapore offers opportunities to work with international engineering teams.”

## 8. Salary expectations
“My expectation is around SGD 9,500 per month in fixed base salary, depending on the overall benefits and employment terms.” Clarify 12-month base vs AWS/bonus, notice period, medical coverage and on-call.

## 9. Why should we hire you?
“I bring hands-on Java/backend experience plus experience supporting distributed systems in production. I've worked with integration protocols, asynchronous processing and data pipelines in banking contexts. I can contribute to implementation while also anticipating operational failure modes.”

## 10. Questions to ask interviewer
- Which Java and Spring versions are used, and is the team building new services or maintaining legacy systems?
- What are the on-call expectations and release cadence?
- How are integration tests and production incidents handled?
- Is the interview with UOB engineers or the vendor team?
- For HR: employing entity, EP sponsorship, work location, bench pay, notice period, insurance and contract duration.
