nohup java -jar scanner-data-0.0.1-SNAPSHOT.jar &
nohup java -jar scanner-eureka-0.0.1-SNAPSHOT.jar &
nohup java -jar scanner-gateway-0.0.1-SNAPSHOT.jar &
nohup java -jar scanner-processor-0.0.1-SNAPSHOT.jar --uploadPath=../upload/ --scannerPath=../luminous/run.sh --scannerInputPath=../luminous/demo_images --scannerOutputPath=../luminous/content &
