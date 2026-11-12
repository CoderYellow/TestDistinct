# Self-introduction — 5-minute DBS-first version

Hi, I'm Jack. It's a pleasure to meet you, and thank you for the opportunity.

I'm a backend software engineer with over seven years of professional experience, primarily in Java, Spring Boot, distributed systems and enterprise backend development. My career has covered logistics, cloud monitoring and banking. Over the last few years, I've mainly worked on banking technology projects for DBS and HSBC.

I'd like to start with DBS, where I've spent roughly three years through NCS, because that experience shows how my responsibilities evolved from core development to independent maintenance and then into data engineering.

During my first year, I worked on an SRE automation project as part of a five-person team. I was one of the main developers and became deeply familiar with the application's backend implementation and operational workflows. We developed Kotlin, Spring Boot and WebFlux services to consolidate operational capabilities that had previously been handled through separate Python scripts. These services supported diagnostics and operational tasks across technologies such as Cloudera, HDFS, YARN, Hive and S3.

I found this work interesting because it required understanding existing processes and designing reusable backend interfaces, rather than simply building isolated features.

In my second year, the team was gradually reduced. Because I had been heavily involved in development and knew the system particularly well, I became the sole engineer responsible for its ongoing maintenance.

That was an important transition for me. Instead of concentrating only on implementation, I had to think about maintainability and the day-to-day operation of an existing application. It strengthened my sense of ownership and my ability to work independently. I would describe myself as the sole maintainer, rather than claiming a formal team-lead position.

By my third year, the automation application had become relatively mature and its routine maintenance workload had decreased. My manager therefore gave me additional responsibilities in Spark-based data development. I worked on batch processing applications consuming Kafka data, including checkpoint and resume support for recoverable processing. Alongside this, my experience included Jenkins pipelines and deployment automation using Helmfile, Terraform, OpenShift and GCP.

So my DBS experience has been a combination of hands-on backend development, operational responsibility and data engineering. It also helped me become familiar with the engineering discipline involved in supporting a Singapore banking technology environment.

Before NCS, I worked at TEKsystems on HSBC's foreign exchange order management system. This was a more directly Java-focused backend development role.

One of the components I worked on was an FX Gateway integrating orders arriving through IBM MQ, SFTP and REST APIs. The gateway normalised different upstream message formats into FIX messages for downstream processing. Because financial orders need reliable handling, we persisted raw inbound messages before processing them asynchronously, reducing the risk of losing accepted data during processing failures.

I also worked with Disruptor for in-process event handling, Spring WebFlux for reactive backend components, and SSE/WebSocket for asynchronous user updates. That experience strengthened my understanding of integration protocols, event-driven systems and reliability considerations in financial applications.

Before HSBC, I worked at Chinasoft International on Huawei Cloud's monitoring platform. I developed Flink jobs consuming Kafka streams of traces, logs and metrics for cleaning, enrichment, alerting and persistence. I also helped refactor a tightly coupled alerting module into more modular contracts, including extension mechanisms such as listeners, filters and notification channels.

I started my career at Neusoft, working on logistics systems such as warehouse management, transportation management and order management. I participated in moving legacy applications towards Spring Boot and Spring Cloud microservices. I also worked on code generation with FreeMarker, authentication integration with Keycloak, and TCP-based terminal integration using Netty.

Looking across these roles, I would highlight three strengths. First, hands-on Java and Spring backend development. Second, distributed and asynchronous systems, including messaging and data processing. Third, production engineering and ownership: I care about how systems are maintained, diagnosed and recovered, not just how features are implemented.

For my next step, I'd like to continue focusing on Java backend engineering in banking. My experience with DBS and HSBC has given me relevant technical and operational context, and I believe I could contribute effectively to a UOB engineering team.

That's an overview of my background. I'd be happy to go deeper into any of these projects.

Thank you.

*Time yourself at your normal speaking pace. Keep client-internal details confidential and describe only work you personally performed.*
