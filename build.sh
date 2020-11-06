mvn -f pom.xml clean -DskipTests package
if [ -x "$(command -v podman)" ]; then
  podman build -t latest -f Dockerfile
  else docker build -t latest -f Dockerfile
fi

if [ -x "$(command -v podman-compose)" ]; then
  podman-compose up -d >&2
  exit 1
fi
docker-compose up -d