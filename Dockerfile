FROM openjdk:8-jdk-oracle
ENTRYPOINT ["java","-Dworker_id=1","-jar","/backend/single-blog.jar"]