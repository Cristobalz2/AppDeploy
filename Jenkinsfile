pipeline {
  agent {
    label 'master'
  }
  stages {
    stage('Build') {
      steps {
        script {
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
            sh "chmod u+x ./gradlew"
            sh "./gradlew bootrun "
        }
      }
    }
  }
}
