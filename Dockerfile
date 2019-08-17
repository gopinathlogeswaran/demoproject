FROM jenkinsci/blueocean
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY my-new-dsl.groovy /usr/share/jenkins/my-new-dsl.groovy
COPY testpipeline.groovy /usr/share/jenkins/testpipeline.groovy
COPY config.xml /usr/share/jenkins/seed-job-config.xml
COPY create-new-seed-job.groovy /usr/share/jenkins/ref/init.groovy.d/create-new-seed-job.groovy
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
