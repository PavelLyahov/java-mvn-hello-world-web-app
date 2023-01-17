pipeline {
  agent any

  stages {
    stage('Unit tests') {
        steps {
            bat 'mvn clean test'
        }
    }

    stage('Build') {
        steps {
            bat """
                call cd C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\javawebhelloworld
                call del /F /S /Q *.*
            """
            echo "build war file"
            bat 'mvn package'
            bat """
                call cd target
                call dir
                call rename mvn-hello-world.war ROOT.war
            """
        }
    }



    stage('Deploy') {
        steps {
            deploy adapters: [tomcat9(credentialsId: '', path: '', url: 'http://localhost:8085')], contextPath: '/pipeline', onFailure: false, war: 'target/*.war'
        }
    }

  }
}