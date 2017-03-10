FROM sadema/payara-micro
ENV ARCHIVE_NAME basisregistratie-service.war
COPY ./target/basisregistratie-service.war ${DEPLOYMENT_DIR}
ENTRYPOINT java -agentlib:jdwp=transport=dt_socket,address=6666,suspend=n,server=y -jar ${PAYARA_ARCHIVE}.jar --deploy ${ARCHIVE_NAME}
