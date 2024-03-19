### Commande pour créer une image docker

docker build -t <nom_image> -f <chemin_vers_le_docker_file> <context_de_buid>
docker build t image-demo-quarkus -f Dockerfile.native .

## Pour créer un conteneur à partir d'une image
docker run <option_possible> -p <PORT_HOST:PORT_CONTAINER> <NOM_IMAGE>

docker run -d -p 8080:8080 image-demo-quarkus