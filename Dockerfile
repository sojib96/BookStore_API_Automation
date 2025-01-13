FROM openjdk:21-jdk-slim AS build

WORKDIR /app

RUN apt-get update && apt-get install -y maven curl unzip

RUN curl -sL https://github.com/allure-framework/allure2/releases/download/2.24.0/allure-2.24.0.tgz | tar -xz -C /opt/ \
    && ln -s /opt/allure-2.24.0/bin/allure /usr/bin/allure

COPY . .

RUN mvn dependency:resolve


