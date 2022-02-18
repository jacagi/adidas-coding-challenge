FROM openjdk:11
VOLUME /tmp
ADD subscriptionservice-boot-1.0.0-SNAPSHOT.jar first.jar
ADD SubscriptionPublicServices-1.0.0-SNAPSHOT.jar second.jar
ADD emailservice-1.0.0-SNAPSHOT.jar third.jar
ADD start_sc.sh start_sc.sh
CMD ["sh", "start_sc.sh"]