# Order Service

A small Java 17 / Spring Boot application for looking up customer orders. It uses
Spring Data JPA and a seeded H2 in-memory database. All monetary amounts are EUR;
order lines store the unit price agreed at purchase time.

## Build and run

Requirements: JDK 17 and Maven 3.6.3 or newer. Confirm that `java -version` and
`mvn -version` both use the intended JDK.

```sh
mvn clean verify
mvn spring-boot:run
```

Alternatively, after building:

```sh
java -jar target/order-service-0.0.1-SNAPSHOT.jar
```

The server listens on port 8080. The database is recreated at each start.

```sh
curl http://localhost:8080/api/customers/42/orders
```

The order listing returns up to 20 recent orders, newest ID first. Unknown
customers receive an empty list. Sample customers are 42, 84 and 99. Customer
contact email is optional. This local interview application has no authentication;
the supplied customer ID represents the customer selected by an internal caller.

## Code review exercise

Review the pull request from `feature/order-summary-endpoint` into `main` as you
would a teammate's feature change. The proposed feature provides recent order
summaries with product names, quantities, purchase prices and totals for a customer.

Use GitHub's **Files changed** view and read the surrounding code on the base
branch when useful. If reviewing locally:

```sh
git switch feature/order-summary-endpoint
git diff main...HEAD
mvn clean verify
```

Assess correctness, performance, maintainability and reliability. Prioritize your
findings by severity, explain the conditions and impact, and suggest concrete
improvements. Distinguish concerns that should block merging from optional
suggestions. You may run the service, add focused tests, or discuss assumptions
with your interviewer. There is no requirement to rewrite the application.

The project is intentionally small so the discussion can focus on the proposed
change. Review comments should explain the reasoning behind each recommendation.
