pipeline {
  agent {
    label 'master'
  }
  stages {
    stage('Build') {
      steps {
        script {
          sh '''
            PID=ps -ef | grep demo-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{ print $2 }'
            echo $PID
            kill -9 $PID
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
