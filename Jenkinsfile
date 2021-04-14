pipeline {
  agent {
    label 'master'
  }
  stages {
    stage('Build') {
      steps {
        script {
              sh "docker stop gradle 2>/dev/null"
              sh "docker rm gradle 2>/dev/null"
              sh "chmod u+x ./gradlew"
              sh "./gradlew clean"
              sh "./gradlew build -x test"
              sh "docker build -t gradle:latest ."
        }
      }
    }
    stage('Test') {
      steps {
          script {
              sh "chmod u+x ./gradlew"
              sh "./gradlew test"
          }      
      }
    }
    stage('Deploy') {
      steps {
        script {
            sh "docker run --name gradle -dp 8082:8080 gradle:latest"
        }
      }
    }
  }
}
