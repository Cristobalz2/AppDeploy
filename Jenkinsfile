pipeline {
  agent {
    label 'master'
  }
  stages {
    stage('Build') {
      steps {
        script {
          sh '''
            kill -9 7887
            chmod u+x ./gradlew
            ./gradlew clean
            ./gradlew build -x test
            '''
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
