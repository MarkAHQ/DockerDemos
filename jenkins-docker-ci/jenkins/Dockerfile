FROM jenkins/jenkins:lts-alpine

LABEL maintainer "dan.humphrey@accesshq.com"

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

USER root

# install wget
RUN apk update
RUN apk add ca-certificates wget   

# get maven 3.6.0
RUN wget --no-verbose -O /tmp/apache-maven-3.6.0-bin.tar.gz http://apache.cs.utah.edu/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz

# install maven
RUN tar xzf /tmp/apache-maven-3.6.0-bin.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.6.0 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.6.0-bin.tar.gz
ENV MAVEN_HOME /opt/maven

RUN chown -R jenkins:jenkins /opt/maven

# jenkins user
RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

USER jenkins

# config
COPY ./config.xml /usr/share/jenkins/ref/config.xml

# initial admin user
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy

# plugins
COPY ./plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

# prevent banner prompt for pipeline plugins
RUN echo 2.164.2 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
RUN echo 2.164.2 > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion
# maven installations
COPY ./hudson.tasks.Maven.xml /usr/share/jenkins/ref/hudson.tasks.Maven.xml