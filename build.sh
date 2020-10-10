mvn -f pom.xml clean -DskipTests package
docker build -t neo4jbackend -f Dockerfile
if [ -x "$(command -v podman-compose)" ]; then
  podman-compose up -d >&2
  exit 1
fi
docker-compose up -d