FROM sadema/payara-micro
ENV ARCHIVE_NAME basisregistratie-service.war
COPY ./target/basisregistratie-service.war ${DEPLOYMENT_DIR}
ENTRYPOINT java -jar ${PAYARA_ARCHIVE}.jar --deploy ${ARCHIVE_NAME}
