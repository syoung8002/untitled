# 

## Model
www.msaez.io/#/storming/bead4f1d8f826ea9a86d43b85add9fea

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- order-management
- production-management
- logistics-management
- sales-management


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- order-management
```
 http :8088/orders orderId="orderId" customerId="customerId" productId="productId" orderStatus="orderStatus" orderStatusType="orderStatusType" 
```
- production-management
```
 http :8088/productions productionId="productionId" productId="productId" productionStatus="productionStatus" productionStatusType="productionStatusType" 
```
- logistics-management
```
 http :8088/logistics logisticsId="logisticsId" productId="productId" deliveryStatus="deliveryStatus" deliveryStatusType="deliveryStatusType" 
```
- sales-management
```
 http :8088/sales salesId="salesId" customerId="customerId" contractStatus="contractStatus" contractStatusType="contractStatusType" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

