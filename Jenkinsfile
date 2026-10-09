
pipeline {
    agent any

    environment {
        DOCKERHUB_REPO = 'druvitapatel/hospital-management'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Push Microservices') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_TOKEN'
                    )
                ]) {
                    sh '''
                        set -eu
                        echo "$DOCKER_TOKEN" | docker login \
                          -u "$DOCKER_USER" --password-stdin

                        for service in \
                          api-gateway \
                          patient-service \
                          doctor-service \
                          appointment-service \
                          notification-service \
                          auth-service \
                          eureka-server
                        do
                          echo "Building Maven service: $service"
                          docker run --rm \
                            -v "$PWD:/workspace" \
                            -w "/workspace/$service" \
                            maven:3.9.9-eclipse-temurin-21 \
                            mvn clean package -DskipTests

                          echo "Building Docker image: $service"
                          docker build \
                            -t "$DOCKERHUB_REPO:$service-v1" \
                            "./$service"

                          echo "Pushing Docker image: $service"
                          docker push "$DOCKERHUB_REPO:$service-v1"
                        done
                    '''
                }
            }
        }
    }

    post {
        always {
            sh 'docker logout || true'
        }
    }
}