# Self-introduction — 5-minute version

**Context:** iSoftStone / UOB Singapore Java backend interview. Use when asked to walk through your CV. Estimated around five minutes depending on pace.

Hi, I'm Jack. It's a pleasure to meet you, and thank you for giving me the opportunity to introduce myself.

I'm a backend software engineer with over seven years of professional experience. My main technical background is in Java, Spring Boot, distributed systems, and enterprise backend development.

I've worked in several industries, including logistics, cloud computing, and banking. What connects these experiences is that I've generally been working on backend systems involving integration, asynchronous processing, data pipelines, and production reliability.

I'd like to briefly walk you through my career, starting with my most recent role.

**Currently, I'm working at NCS, supporting a centralised big data platform for DBS Bank.**

The platform handles data across several layers, including metadata, data lake, data warehouse, and datamart.

My responsibilities cover backend development, data processing, and operational automation.

On the backend side, I developed tools using Kotlin, Spring Boot, and WebFlux.

Previously, many operational tasks were handled through separate Python scripts. I worked on consolidating these scripts into backend services that could perform diagnostics and operational tasks across technologies such as Cloudera, HDFS, YARN, Hive, and S3.

This work gave me practical experience in understanding existing operational processes, defining service interfaces, and building reusable backend components.

Another part of my role involved developing Spark applications that consume data from Kafka in batches.

One of the important requirements was recoverability. These applications needed checkpoint and resume capabilities so that processing could continue after failures rather than always starting from scratch.

I also contributed to deployment automation using Jenkins, Helmfile, and Terraform, with applications deployed to OpenShift and Google Cloud environments.

Working on this platform has helped me develop a broader understanding of production systems, particularly how applications interact with infrastructure and how failures can affect data processing.

**Before NCS, I worked at TEKsystems on HSBC's foreign exchange order management system.**

This role was primarily focused on Java backend development.

One of the major components I worked on was an FX Gateway, which was responsible for integrating orders from different upstream systems.

These systems communicated through several protocols, including IBM MQ, SFTP, and REST APIs.

Our gateway needed to receive these different message formats, normalise them, and convert them into FIX messages for downstream processing.

One of the challenges in this type of system is ensuring that incoming orders are handled reliably, especially when processing involves multiple asynchronous stages.

In our implementation, raw incoming messages were persisted before being processed asynchronously. This helped reduce the risk of losing data if a failure occurred during processing.

I also worked with Disruptor for in-process event handling and Spring WebFlux for reactive backend development.

For user-facing updates, we supported asynchronous communication through Server-Sent Events and WebSocket.

This experience strengthened my understanding of message-driven architecture, protocol integration, and the importance of reliability in financial systems.

**Before HSBC, I worked at Chinasoft International on a monitoring platform for Huawei Cloud.**

The platform processed operational data such as traces, logs, and metrics collected from different systems.

I developed Flink jobs that consumed data from Kafka and performed operations such as cleaning, enrichment, alerting, and persistence.

I also participated in refactoring an alerting module that had become highly coupled.

The goal was to separate core contracts from business-specific implementations, allowing different teams to extend the system through mechanisms such as event listeners, filters, and notification channels.

This experience helped me better understand modular design and extensibility in large systems.

**I started my professional career at Neusoft, working on logistics and enterprise management systems.**

These included warehouse management, transportation management, and order management applications.

A major part of my work involved migrating legacy systems towards Spring Boot and Spring Cloud microservices.

I also developed a code generation tool using FreeMarker, worked on authentication integration using Keycloak, and implemented a TCP-based integration component using Netty.

These projects gave me a solid foundation in Java backend development, service integration, and maintaining enterprise applications.

**If I were to summarise my technical strengths, I would highlight three areas.**

First, backend development with Java, Spring Boot, and related frameworks.

Second, distributed and asynchronous systems, including Kafka, message queues, and data processing frameworks.

And third, production engineering, including troubleshooting, deployment automation, and reliability.

I believe this combination is valuable because I don't just focus on implementing application features. I also try to understand how the system will behave under failures, how it can be maintained, and how it can be operated reliably.

**As for my next career step, I'd like to continue developing my expertise in Java backend engineering, particularly in the banking and financial services sector.**

Having already worked on projects for HSBC and DBS, I'm familiar with the engineering discipline required in banking environments, and I believe that experience would help me contribute effectively to a team at UOB.

That's an overview of my background. I'd be happy to discuss any of these projects in more detail.

Thank you.
