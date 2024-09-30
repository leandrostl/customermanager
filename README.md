# customermanager
A customer management system created just for practice some technologies

## Starting the application
1. Inicialize Minikube: execute the command on terminal `minkube start`
2. Open the minikube dashboard: make your experience easier, execute the command `minikube dashboard`
3. Dando acesso a imagens locais: para que o minikube consiga carregar imagens do docker local, execute o comando `eval $(minikube docker-env)`
4. Run `gradle build`
5. Create the application image on docker: `docker build . -t mybank\customer-manager:v1`
6. Deploy you database: `kubectl apply -f deploy/db-deployment.yaml`
7. Wait its stabilization on cluster, verify its status on minikube dashboard
8. Deploy your application: `kubectl apply -f deploy/deployment.yaml`
9. Get the IP of the application container: `minikube service customer-manager`
10. Finalize your resources running the command `minikube delete --all`