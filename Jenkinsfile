pipeline {
  agent {
    label 'master'
  }
  stages {
    stage('Build') {
      steps {
        script {
            sh "chmod +x stop.sh"
            sh "kill -9 $PID"
            sh "chmod u+x ./gradlew"
            sh "./gradlew clean"
            sh "./gradlew build -x test"
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
            sh "java -jar build/libs/demo-0.0.1-SNAPSHOT.jar &"
        }
      }
    }
  }
}
