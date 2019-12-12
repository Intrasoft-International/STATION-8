FROM java:8-jdk-alpine
ADD . /code
WORKDIR /code
EXPOSE 7001
EXPOSE 27017
CMD echo 127.0.0.1 mongodb >> /etc/hosts; supervisord -n;
CMD sleep 5 && java -jar /code/releases/demo-app-1.0.0.jar