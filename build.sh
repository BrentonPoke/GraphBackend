mvn -f pom.xml clean -DskipTests package
docker build -t neo4jbackend -f Dockerfile
docker-compose up -d