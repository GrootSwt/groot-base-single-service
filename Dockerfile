FROM openjdk:8-jdk-oracle
COPY single-blog-0.0.1-SNAPSHOT.jar single-blog.jar
LABEL author="swt"
ENTRYPOINT ["java","-jar","blog.jar"]