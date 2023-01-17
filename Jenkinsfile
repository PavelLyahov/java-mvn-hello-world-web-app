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
        }
    }

    stage('Rename war') {
    bat """
        call cd target
        call dir \\b
        call rename mvn-hello-world.war ROOT.war
        call dir \\b
    """
    }



    stage('Deploy') {
        steps {
            deploy adapters: [tomcat9(credentialsId: '', path: '', url: 'http://localhost:8086')], contextPath: '/pipeline', onFailure: false, war: 'target/ROOT.war'
                    }
    }

  }
}