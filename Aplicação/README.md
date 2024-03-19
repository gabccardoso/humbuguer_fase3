# Documentação da aplicação

A aplicação está usando kubernetes com minikube, então para rodá-la com kubernetes, o minikube é necessário.

## Como subir
- Em seu terminal habilite o metrics-server para o hpa funcionar corretamente. Para isso
digite em seu terminal: 'minikube addons enable metrics-server'.
- Com o metrics habilitado, entre na raíz do projeto pelo terminal e digite: 
'kubectl apply -f kubernetes', e todos os arquivos yaml necessários para que a aplicação suba
serão rodados.
- Para acessar, verifique o ip do minikube com o comando 'minikube ip', e acesse com: <minikubeIp>:30000

## Como testar
- No link do drive (https://drive.google.com/file/d/1GCpNOuRQ-idTs-JWCDkeJGfXAEJkmrpa/view?usp=sharing) tem a collection do postman para testar. Rode a request na ordem para que todas
funcionem sem problemas.
