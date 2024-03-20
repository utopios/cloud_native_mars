### Construire l'image de notre application en native
docker build -t contact-app -f Dockerfile.native .

### Créer le cluster kind (k8s en local, en docker)
kind create cluster --name contact-app-cluster --config kind/kind.yml

### Déplacer l'image vers notre cluster kind(uniquement pour le dev et test)
kind load docker-image contact-app --name contact-app-cluster

### Créer les ressources k8s
kubectl create -f k8s/kubernetes.yml