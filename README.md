# Graph Database Backend
This is an assignment for a graduate course on databases that demonstrates the usage of Neo4j and a
backend RESTful webservice.
## Build & Run
```shell script
./build.sh
```
This will pull down the docker image for Neo4j and then build the REST service.
### Podman Users
If you have podman aliased to docker,
it will use podman normally. After that, it will detect whether or not podman-compose is available
and use it if it's there. otherise it uses docker-compose. Hint: there's a package called
podman-docker that will do the aliasing for you.