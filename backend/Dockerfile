# ============================================
# Multi-stage build для FinPlus Backend
# ============================================

# Stage 1: Build
FROM ubuntu:22.04 AS build

# Установка зависимостей для сборки
RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    maven \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Определяем путь к Java 21 и настраиваем
RUN JAVA_PATH=$(ls -d /usr/lib/jvm/java-*-openjdk-* 2>/dev/null | grep "21" | head -1) && \
    if [ ! -f "$JAVA_PATH/bin/javac" ]; then \
    echo "ERROR: javac not found in $JAVA_PATH"; \
    ls -la /usr/lib/jvm/; \
    exit 1; \
    fi && \
    update-alternatives --install /usr/bin/java java $JAVA_PATH/bin/java 1 && \
    update-alternatives --install /usr/bin/javac javac $JAVA_PATH/bin/javac 1 && \
    echo $JAVA_PATH > /tmp/java_home

WORKDIR /app

# Копирование pom.xml и установка зависимостей
COPY pom.xml .
RUN JAVA_HOME=$(cat /tmp/java_home) && \
    export JAVA_HOME && \
    mvn dependency:go-offline -B

# Копирование исходного кода
COPY src ./src

# Сборка приложения
RUN JAVA_HOME=$(cat /tmp/java_home) && \
    export JAVA_HOME && \
    mvn clean package -DskipTests

# ============================================
# Stage 2: Runtime
# ============================================
FROM ubuntu:22.04

# Установка только JRE для запуска
RUN apt-get update && apt-get install -y \
    openjdk-21-jre-headless \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Создание пользователя
RUN groupadd -r finplus && useradd -r -g finplus finplus

WORKDIR /app

# Копирование JAR из build stage
COPY --from=build /app/target/*.jar app.jar

# Создание директории для логов
RUN mkdir -p /app/logs && chown -R finplus:finplus /app

USER finplus

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

# Используем java напрямую (будет работать из PATH установленного пакетом)
ENTRYPOINT ["java", \
    "-XX:+UseContainerSupport", \
    "-XX:MaxRAMPercentage=75.0", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-jar", \
    "app.jar"]
